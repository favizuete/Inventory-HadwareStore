/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Inventory {

    private ArrayList<Product> products;

    public Inventory() {
    }

    public Inventory(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Stock { products=" + products + "}";
    }
    public void login(Admin admin){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el usuario");
        String user = reader.nextLine();
        if(user.equals(admin.getUser())){
            System.out.println("Ingrese la contraseña");
            String password = reader.nextLine();
            while(!password.equals(admin.getPassword())){
                System.out.println("Contraseña incorrecta, ingrese de nuevo:");
                password = reader.nextLine();
    
            }
        }
        else{
            System.out.println("Usuario incorrecto, ingrese más tardexd");
            System.exit(0);
        }
     
    }
    public void addProduct(Product product){
        products.add(product);
        
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
