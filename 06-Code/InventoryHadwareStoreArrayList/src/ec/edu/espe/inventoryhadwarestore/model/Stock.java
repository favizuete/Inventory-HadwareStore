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
    private int idStock;
    private ArrayList<Product> products;
    private ArrayList<Category> categorys;

    public Stock(int idStock, ArrayList<Product> products, ArrayList<Category> categorys) {
        this.idStock = idStock;
        this.products = products;
        this.categorys = categorys;
    }

    @Override
    public String toString() {
        return "Stock{" + "idStock=" + idStock + ", products=" + products + ", categorys=" + categorys + '}';
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

    /**
     * @return the categorys
     */
    public ArrayList<Category> getCategorys() {
        return categorys;
    }

    /**
     * @param categorys the categorys to set
     */
    public void setCategorys(ArrayList<Category> categorys) {
        this.categorys = categorys;
    }
    
    
    
}
