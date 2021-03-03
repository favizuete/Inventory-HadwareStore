/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.ConstructionMaterial;
import ec.edu.espe.inventoryhadwarestore.model.ElectricTool;
import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.Tool;
import java.util.Scanner;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class InventoryController {
    
        public void inventoryView(Inventory inventory) {

        System.out.println("*********Inventario Actual*********");
        System.out.println("Total de productos: " + inventory.getProducts().size());
        int i = 0;
        for (Product product : inventory.getProducts()) {
            System.out.println("Producto N°" + (i + 1));
            System.out.println("Nombre del producto-->" + product.getName());
            System.out.println("Marca del producto -->" + product.getBrand());
            System.out.println("ID del producto -->" + product.getId());
            System.out.println("Categoría del producto -->" + product.getCategory());
            System.out.println("Precio del producto -->" + product.getPrice());
            System.out.println("Cantidad actual en el inventario del producto -->" + product.getQuantity());
            int j = i + 1;
            i = j;
        }
        System.out.println("********************************");
    }
        public Product enterAProduct() {
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
        int x=0;
        Product productToReturn = null;
        while(x==0){
          System.out.println("Ingrese la categoría del producto :");
          String category = reader.nextLine();
          if ("Herramienta".equals(category)) {
            System.out.println("Ingrese la calidad de la herramienta:");
            String qualityh = reader.nextLine();
            Product tool = new Tool(qualityh, id, name, brand, quantity, price, category);
            x=1;
           productToReturn = tool;
        } else if ("Herramienta electrica".equals(category)) {
            System.out.println("Ingrese la calidad de la herramienta electrica:");
            String qualityh = reader.nextLine();
            Product electricTool = new ElectricTool(qualityh, category, id, name, brand, quantity, price, category);
            x=1;
            productToReturn = electricTool;

        } else if ("Material de Construcción".equals(category)) {
            System.out.println("Ingrese el peso del material:");
            float weigth = reader.nextFloat();
            Product material = new ConstructionMaterial(weigth, id, name, brand, quantity, price, category);
            x=1;
            productToReturn = material;

        } else {
            System.out.println("No hay su categoria ingrese de nuevo..");
            x=0;
        }          
        }
        return productToReturn;
    }
}
