/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.view;

import com.google.gson.Gson;
import ec.edu.espe.inventoryhadwarestore.model.Admin;
import ec.edu.espe.inventoryhadwarestore.model.ConstructionMaterial;
import ec.edu.espe.inventoryhadwarestore.model.ElectricTool;
import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.SalesRegistry;
import ec.edu.espe.inventoryhadwarestore.model.Tool;
import espe.edu.ec.filemanagerlibrary.FileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class InventoryHadwareStore {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Inventory inventory = new Inventory();
        Admin admin = new Admin("Richard", "richard123", "richard123");
        inventory.login(admin);
        Scanner scan = new Scanner(System.in);
        int opc;
        int option;

        do {
            System.out.println("\t****INVENTARIO FERRETERIA****");
            System.out.println("1. INGRESAR PRODUCTO A LA lISTA");
            System.out.println("2. INGRESAR PRODUCTO AL INVENTARIO ");
            System.out.println("3. VENDER PRODCUTO");
            System.out.println("4. MODIFICAR PRODUCTO");
            System.out.println("5. ELIMINAR PRODUCTO DE LA LISTA");
            System.out.println("6. MOSTRAR INVENTARIO");
            System.out.println("7. MOSTRAR REGISTRO DE VENTA");
            System.out.println("0. SALIR");
            System.out.print("ESCOJA UNA OPCION: ");
            opc = scan.nextInt();
            System.out.println("   ");
            switch (opc) {
                case 1:
                    inventory.addProduct(enterAProduct());
                    System.out.println("Inventario -->" + inventory);
                    break;
                case 2:
                    do{
                    System.out.println("Ingrese el producto que desea ingresar:");
                    String readedproduct = scan.nextLine();
                    for(Product product : inventory.getProducts())
                    {
                        if(readedproduct.equals(product.getName())){
                            System.out.println("Producto encontrado..");
                            System.out.println("Ingrese la cantidad que desea añadir a ese producto:");
                            int quantityToAdd = scan.nextInt();
                            scan.nextLine();
                            product.add(quantityToAdd);
                        }
                    }
                    System.out.println("Ingrese 1 para ingresar un nuevo producto");
                    System.out.println("Ingrese 2 para salir");
                    option = scan.nextInt();
                    scan.nextLine();
                    }while(option!=2);
                    break;
                case 3:
                    ArrayList<Product> productsToSell = new ArrayList<>();
                    System.out.println("Buen dia cliente, proporcione su nombre para continuar:");
                    System.out.println("Ingrese su nombre");
                    String name = scan.nextLine();                    
                    do{
                        System.out.println("Ingrese el producto que desea vender:");
                        String readedproduct = scan.nextLine();
                        for(Product product : inventory.getProducts()){
                            if(readedproduct.equals(product.getName())){
                                System.out.println("Producto encontrado..");
                                System.out.println("Ingrese la cantidad que desea vender de este producto:");
                                int quantityToSell = scan.nextInt();
                                scan.nextLine();
                                product.sell(quantityToSell);
                                productsToSell.add(product);
                                }
                        }
                        System.out.println("Ingrese 1 para vender otro producto");
                        System.out.println("Ingrese 2 para continuar al registro");
                        option = scan.nextInt();
                        scan.nextLine();
                    }while(option!=2);
                    Date date = new Date();
                    String id = "";
                    SalesRegistry registry = new SalesRegistry(name,date,id,productsToSell);
                    registry.generateId();
                    String registryString = gson.toJson(registry);
                    FileManager.writeFile("RegistroDeVentas.json", registryString);                    
                    break;
                case 0:
                    System.out.println("\t**GRACIAS POR USAR MI PROGRAMA....!!**0"
                            + "");
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");

            }

        } while (opc != 0);
    }

    public static Product enterAProduct() {
        Scanner reader = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("=====INGRESE UN NUEVO PRODUCTO=====");
        System.out.println("Ingrese el id del producto        :");
        int id = reader.nextInt();
        reader.nextLine();
        System.out.println("Ingrese el nombre del producto    :");
        String name = reader.nextLine();
        System.out.println("Ingrese la marca del producto     :");
        String brand = reader.nextLine();
        System.out.println("Ingrese la cantidad del producto  :");
        int quantity = reader.nextInt();
        reader.nextLine();
        System.out.println("Ingrese el precio del producto    :");
        float price = reader.nextFloat();
        reader.nextLine();
        System.out.println("Ingrese la categoría del producto :");
        String category = reader.nextLine();

        if ("Herramienta".equals(category)) {
            System.out.println("Ingrese la calidad de la herramienta:");
            String qualityh = reader.nextLine();
            Product tool = new Tool(qualityh, id, name, brand, quantity, price, category);
            return tool;

        } else if ("Herramienta electrica".equals(category)) {
            System.out.println("Ingrese la calidad de la herramienta electrica:");
            String qualityh = reader.nextLine();
            Product electricTool = new ElectricTool(qualityh, category, id, name, brand, quantity, price, category);
            return electricTool;
        } else if ("Material de Construcción".equals(category)) {
            System.out.println("Ingrese el peso del material:");
            float weigth = reader.nextFloat();
            Product material = new ConstructionMaterial(weigth, id, name, brand, quantity, price, category);
            return material;

        } else {
            Product product = new Product(id, name, brand, quantity, price, category);
            return product;
        }

    }
}
