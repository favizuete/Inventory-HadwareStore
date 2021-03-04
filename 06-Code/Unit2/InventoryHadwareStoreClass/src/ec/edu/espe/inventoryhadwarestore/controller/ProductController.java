/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.view.AddProduct;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class ProductController implements ActionListener, MouseListener {

    AddProduct addProduct;
    Inventory inventory;

    public ProductController(AddProduct addProduct) {
        this.addProduct = addProduct;
        inventory = new Inventory ();
        
    }

}
