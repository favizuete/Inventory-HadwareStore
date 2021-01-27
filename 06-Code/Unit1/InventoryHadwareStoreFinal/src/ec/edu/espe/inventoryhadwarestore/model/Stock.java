/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import java.util.ArrayList;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Stock {

    private ArrayList<Product> products;

    public Stock() {
    }

    public Stock(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Stock { products=" + products + "}";
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
