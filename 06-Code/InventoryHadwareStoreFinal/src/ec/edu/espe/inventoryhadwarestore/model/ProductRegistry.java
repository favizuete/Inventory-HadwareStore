/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import espe.edu.ec.filemanagerlibrary.FileManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fausto Vizuete
 */
public class ProductRegistry {

    ArrayList<Product> products = new ArrayList<>();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Validation validate = new Validation();

    Stock stock;
    Scanner scan = new Scanner(System.in);

    public void showProducts() throws IOException {

        File f = new File("Products.json");
        if (f.length() == 0) {
            System.out.println("No se han registrado productos");
        } else {
            String productsJson = new String(Files.readAllBytes(Paths.get("Products.json")));
            System.out.println(productsJson);
        }

    }

    public void enterAProduct() throws IOException {

        String name, brand, category;
        int id, quantity;
        float price;

        do {

            System.out.println("Ingrese el nombre del producto: ");
            name = scan.nextLine();

            System.out.println("Ingrese el id del producto: ");
            id = scan.nextInt();
            scan.nextLine();

            System.out.println("Ingrese la marca del producto: ");
            brand = scan.nextLine();

            System.out.println("Ingrese la cantidad: ");
            quantity = scan.nextInt();

            System.out.println("Ingrese el precio por unidad: ");
            price = scan.nextFloat();
            scan.nextLine();

            System.out.println("Ingrese la categoria del producto: ");
            category = scan.nextLine();

            Product product = new Product(id, name, brand, quantity, price, category);

            try {
                recordProduct("Products.json", product);
            } catch (Exception e) {
                System.out.println(e);
            }

        } while ("si".equals(validate.getYesOrNo("Agregar un nuevo producto?"
                + "[si/no]: ")));
    }

    public static void saveRecord(String fileName, Gson gson, ArrayList<Product> products) {
        FileManager.deleteFile(fileName);
        FileManager.writeFile(fileName, gson.toJson(products));
    }

    public boolean recordProduct(String fileName, Product product) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileManager.createFile(fileName);
        String productsJson = new String(Files.readAllBytes(Paths.get(fileName)));
        if (gson.fromJson(productsJson, ArrayList.class) != null) {
            products = gson.fromJson(productsJson, ArrayList.class);
        }
        products.add(product);
        saveRecord(fileName, gson, products);
        return true;
    }
}
