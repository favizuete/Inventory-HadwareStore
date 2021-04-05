/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Product;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public abstract class ProductController {
    private Product product;
    
    public abstract void addQuantity(int quantityToAdd);
    public abstract float sellQuantity(int quantityToSell);

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductController(Product product) {
        this.product = product;
    }
    
    
}
