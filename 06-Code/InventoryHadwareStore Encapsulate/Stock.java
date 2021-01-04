/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventory.model;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Stock {
    private String idProduct;
    private int quantityProduct;
    private String category;

    public Stock(String idProduct, int quantityProduct, String category) {
        this.idProduct = idProduct;
        this.quantityProduct = quantityProduct;
        this.category = category;
    }

    /**
     * @return the idProduct
     */
    public String getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the quantityProduct
     */
    public int getQuantityProduct() {
        return quantityProduct;
    }

    /**
     * @param quantityProduct the quantityProduct to set
     */
    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    /**
     * @return the category
     */
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
