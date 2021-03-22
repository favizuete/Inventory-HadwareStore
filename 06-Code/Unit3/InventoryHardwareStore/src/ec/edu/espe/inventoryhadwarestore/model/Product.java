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
public abstract class Product {

    int _id;
    String name;
    String brand;
    int quantity;
    float price;
    String category;

    public Product(int id, String name, String brand, int quantity, float price, String category) {
        this._id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }
  
    public abstract void add(int quantityToAdd);
    public abstract float sell(int quantityToSell);
    
    public void modify(){
       
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
  
    @Override
    public String toString() {
        return "Product{" + "id=" + _id + ", name=" + name + ", brand=" + brand + ", quantity=" + quantity + ", price=" + price + ", category=" + category + '}';
    }

}
