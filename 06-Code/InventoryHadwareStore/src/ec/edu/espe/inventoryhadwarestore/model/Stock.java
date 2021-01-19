/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import java.util.ArrayList;

/**
 *
 * @author Daniel Vizcarra MaxDev ESPE-DCCO
 */
public class Stock {

    private int idStock;
    private ArrayList<Product> products;

    public Stock(int idStock, ArrayList<Product> products) {
        this.idStock = idStock;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Stock{" + "idStock=" + idStock + ", products=" + products;
    }

    /**
     * @return the idStock
     */
    public int getIdStock() {
        return idStock;
    }

    /**
     * @param idStock the idStock to set
     */
    public void setIdStock(int idStock) {
        this.idStock = idStock;
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
