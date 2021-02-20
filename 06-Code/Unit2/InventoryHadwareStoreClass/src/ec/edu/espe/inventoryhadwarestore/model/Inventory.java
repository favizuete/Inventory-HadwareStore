/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import com.google.gson.Gson;
import espe.edu.ec.filemanagerlibrary.FileManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Inventory {

    private ArrayList<Product> products = new ArrayList<>();

    public Inventory() {
    }

    public Inventory(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Stock { products=" + products + "}";
    }

    public void login(Admin admin) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el usuario");
        String user = reader.nextLine();
        if (user.equals(admin.getUser())) {
            System.out.println("Ingrese la contraseña");
            String password = reader.nextLine();
            while (!password.equals(admin.getPassword())) {
                System.out.println("Contraseña incorrecta, ingrese de nuevo:");
                password = reader.nextLine();

            }
        } else {
            System.out.println("Usuario incorrecto, ingrese más tarde..!!");
            System.out.println("Usuario incorrecto, ingrese más tarde");
            System.exit(0);
        }

    }

    public void readProducts() {

        Gson gson = new Gson();
        ArrayList<Product> productList = new ArrayList<>();
        try {
            FileReader freader = new FileReader("RegistroProductos.json");
            BufferedReader breader = new BufferedReader(freader);
            String product = breader.readLine();
            do {
                Product products = gson.fromJson(product, Product.class);
                productList.addAll(Arrays.asList(products));
                String productx = breader.readLine();
                product = productx;
            } while (product != null);
            setProducts(productList);
        } catch (Exception exception) {
            System.out.println("No se leyó la lista de productos..");
        }
    }

    public void addProduct(Product product) {
        getProducts().add(product);
        Gson gson = new Gson();
        gson.toJson(product);
        FileManager.writeFile("RegistroProductos.json", gson.toJson(product));
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
