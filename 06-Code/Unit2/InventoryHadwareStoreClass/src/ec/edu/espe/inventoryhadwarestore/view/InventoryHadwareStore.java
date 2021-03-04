/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.view;

import com.google.gson.Gson;
import ec.edu.espe.inventoryhadwarestore.controller.InventoryController;
import ec.edu.espe.inventoryhadwarestore.model.Admin;
import ec.edu.espe.inventoryhadwarestore.model.ConstructionMaterial;
import ec.edu.espe.inventoryhadwarestore.model.ElectricTool;
import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.SalesRegistry;
import ec.edu.espe.inventoryhadwarestore.model.Tool;
import ec.edu.espe.inventoryhadwarestore.utils.MongoManager;
import ec.edu.espe.inventoryhadwarestore.utils.Validation;
import espe.edu.ec.filemanagerlibrary.FileManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        InventoryController iController = new InventoryController();
        SalesRegistry salesRegistry = new SalesRegistry();
        Validation validate = new Validation();
        Admin admin = new Admin("Richard", "richard123", "richard123");
        inventory.login(admin);
        inventory.readProductsFromMongoDB();
        Scanner scan = new Scanner(System.in);
        int opc,option,op;
        do {
            System.out.println("\t****INVENTARIO FERRETERIA****");
            System.out.println("1. INGRESAR PRODUCTO AL INVENTARIO ");
            System.out.println("2. INGRESAR CANTIDAD DE PRODUCTO AL INVENTARIO");
            System.out.println("3. VENDER PRODUCTO");
            System.out.println("4. MODIFICAR PRODUCTO");
            System.out.println("5. ELIMINAR PRODUCTO");
            System.out.println("6. MOSTRAR INVENTARIO");
            System.out.println("0. SALIR");
            System.out.print("ESCOJA UNA OPCION: ");
            opc = scan.nextInt();
            scan.nextLine();
            System.out.println("   ");
            switch (opc) {
                case 1:
                    
                    inventory.addProduct(iController.enterAProduct());
                    System.out.println("Inventario -->" + inventory);
                    break;
                case 2:
                    do {
                        System.out.println("Ingrese el producto que desea ingresar:");
                        String readedproduct = scan.nextLine();
                        for (Product product : inventory.getProducts()) {
                            if (readedproduct.equals(product.getName())) {
                                System.out.println("Producto encontrado..");
                                System.out.println("Ingrese la cantidad que desea añadir a ese producto:");
                                int quantityToAdd = scan.nextInt();
                                scan.nextLine();
                                int oldquantity = product.getQuantity();
                                product.add(quantityToAdd);
                                int newQuantity = product.getQuantity();
                                MongoManager.updateQuantity(product.getName(), oldquantity);
                            }
                        }
                        System.out.println("Ingrese 1 para ingresar un nuevo producto");
                        System.out.println("Ingrese 2 para salir");
                        option = scan.nextInt();
                        scan.nextLine();
                    } while (option != 2);
                    break;
                case 3:
                    ArrayList<Product> productsToSell = new ArrayList<>();
                    float totalPrice = 0F;
                    float addedPrice = 0F;
                    System.out.println("Ingrese su nombre");
                    String name = scan.nextLine();
                    do {
                        System.out.println("Ingrese el producto que desea vender:");
                        String readedproduct = scan.nextLine();
                        for (Product product : inventory.getProducts()) {
                            if (readedproduct.equals(product.getName())) {
                                System.out.println("Producto encontrado..");
                                System.out.println("Ingrese la cantidad que desea vender de este producto:");
                                int quantityToSell = scan.nextInt();
                                scan.nextLine();
                                int oldQuantity = product.getQuantity();
                                addedPrice = product.sell(quantityToSell);                                    
                                if(addedPrice==-1F){
                                   
                                    System.out.println("Producto no vendido");
                                }
                                else{
                                    totalPrice = totalPrice + addedPrice;
                                    productsToSell.add(product);
                                    int newQuantity = product.getQuantity();
                                    MongoManager.updateQuantity(product.getName(), newQuantity);
                                }

                            }
                        }
                        System.out.println("Ingrese 1 para vender otro producto");
                        System.out.println("Ingrese 2 para continuar al registro");
                        option = scan.nextInt();
                        scan.nextLine();
                    } while (option != 2);
                    Date date = new Date();
                    String id = "";
                    SalesRegistry registry = new SalesRegistry(name, date, id, productsToSell,totalPrice);
                    registry.generateId();
                    String registryString = gson.toJson(registry);
                    FileManager.writeFile("RegistroDeVentas.json", registryString);

                    while ("si".equals(validate.getYesOrNo("Desea imprimir el registro de venta?" + "[si/no]: "))) {
                        System.out.println("\t\t***Registo de Venta***");
                        int i = registry.getTotalSales();
                        System.out.println("Venta N°" + (i + 1));
                        System.out.println(registry);
                        System.out.println("==============================================");
                    }

                    String sales = gson.toJson(registry);
                    FileManager.readFile("RegistroDeVenta.jason");
                    SalesRegistry reg;
                    reg = gson.fromJson(sales, SalesRegistry.class);
                    System.out.println("\t\t***Registo de Venta***");
                    int i = 0;
                    System.out.println("Venta N°" + (i + 1));
                    System.out.println(reg);
                    System.out.println("==============================================");

                    break;

                case 4:
                    ArrayList<Product> products = inventory.getProducts();
                    System.out.println("Ingrese que producto desea modificar");
                    String searchName = scan.nextLine();
                    boolean found = false;
                    for (int j = 0; j < products.size(); j++) {
                        if (products.get(j).getName().equals(searchName)) {
                            found = true;
                            System.out.println("Que dato desea modificar?");
                            System.out.println("1:Marca");
                            System.out.println("2:Precio");
                            System.out.println("3:Categoria");
                            option = scan.nextInt();
                            scan.nextLine();
                            switch (option) {
                                case 1:
                                    System.out.println("Nueva Marca:");
                                    products.get(j).setBrand(scan.nextLine());
                                    break;
                                case 2:
                                    System.out.println("Nuevo Precio:");
                                    products.get(j).setPrice(scan.nextFloat());
                                    break;
                                case 3:
                                    System.out.println("Nueva Categoria:");
                                    products.get(j).setCategory(scan.nextLine());
                                    break;
                            }
                            gson.toJson(products.get(j));
                            FileManager.writeFile("RegistroProductos.json", gson.toJson(products.get(j)));
                            System.out.println("Producto modificado");
                        }
                    }
                    if (!found) {
                        System.out.println("No se encontro el producto");
                    }
                    break;

                case 5:
                    ArrayList<Product> newProducts = inventory.getProducts();
                    Product productToErase = null;
                    System.out.println("Ingrese nombre del producto que desea eliminar");
                    String nameToErase = scan.nextLine();
                    boolean found2 = false; 
                    for(Product product : newProducts){
                        if(nameToErase.equals(product.getName())){
                            System.out.println("Producto encontrado");
                            found2 = true;
                            productToErase = product;
                            
                        }
                        else{
                            System.out.println("Producto no encontrado..");
                        }
                    }
                    if(found2==true){
                       MongoManager.delete(productToErase.getName());                           
                            newProducts.remove(productToErase);
                            FileManager.deleteFile("RegistroProductos.json");
                            FileManager.createFile("RegistroProductos.json");
                            inventory.setProducts(newProducts);
                            for(Product productx : newProducts){
                                String productjson = gson.toJson(productx);
                                FileManager.writeFile("RegistroProductos.json", productjson);
                            } 
                    }
                                        
                    break;

                case 6:
                    System.out.println("Ingrese que desea ver del inventario");
                    System.out.println("1. Todo el inventario");
                    System.out.println("2. Un producto especifico de inventario");
                    option = scan.nextInt();
                    scan.nextLine();
                    switch (option) {
                        case 1:
                            System.out.println("Mostrando todo el inventario..");
                            iController.inventoryView(inventory);
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del producto que desea ver:");
                            String productToSee = scan.nextLine();
                            for (Product product : inventory.getProducts()) {
                                if (product.getName().equals(productToSee)) {
                                    System.out.println("**************************************");
                                    System.out.println("Nombre del producto-->" + product.getName());
                                    System.out.println("Marca del producto -->" + product.getBrand());
                                    System.out.println("ID del producto -->" + product.getId());
                                    System.out.println("Categoría del producto -->" + product.getCategory());
                                    System.out.println("Precio del producto -->" + product.getPrice());
                                    System.out.println("Cantidad actual en el inventario del producto -->" + product.getQuantity());
                                    System.out.println("**************************************");
                                }
                            }
                            break;
                        default:
                    }
                    break;
                case 0:
                    System.out.println("\t**GRACIAS POR USAR MI PROGRAMA....!!**"
                            + "");
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");

            }

        } while (opc != 0);

    }

}
