/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Product {

    private int id;
    private String name;
    private String brand;
    private int quantity;
    private float price;
    private String category;

    public Product(int id, String name, String brand, int quantity, float price, String category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

   
    public void add(int quantityToAdd){
        int quantity = getQuantity();
        int totalquantity= quantity + quantityToAdd;
        setQuantity(totalquantity);
       
    }
    public void sell(int quantityToSell){
        int quantity = getQuantity();
        int totalquantity = quantity - quantityToSell;
        if(totalquantity<0){
            System.out.println("No hay stock suficiente para la cantidad solicitada");
 
        }
        else{
            setQuantity(totalquantity);
        }
        
    }
    public void modify(){
       
    }
    


    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", brand=" + brand + ", quantity=" + quantity + ", price=" + price + ", category=" + category + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
