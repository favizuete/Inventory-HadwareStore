/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.ConstructionMaterial;
import ec.edu.espe.inventoryhadwarestore.model.Product;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class MaterialController extends ProductController{
    ConstructionMaterial material = (ConstructionMaterial) super.getProduct();
    public MaterialController(Product product) {
        super(product);

    }

    @Override
    public void addQuantity(int quantityToAdd) {
        int quantity = material.getQuantity();
        int totalquantity= quantity + quantityToAdd;
        material.setQuantity(totalquantity);
       
    }

    @Override
    public float sellQuantity(int quantityToSell) {
               int quantity = material.getQuantity();
        int totalquantity = quantity - quantityToSell;
        if(totalquantity<0){
            System.out.println("No hay stock suficiente para la cantidad solicitada");
            return -1F;
        }
        else{
            float price = material.getPrice();
            float totalPrice = price*quantity;
            if(material.getWeight()>=100){
                totalPrice = totalPrice + 5F;     
                
            }else if(material.getWeight()>50){
                
                totalPrice = totalPrice + 3F;
                
            }else if(material.getWeight()>10){
            
                totalPrice = totalPrice + 1F;
            }            
            material.setQuantity(totalquantity);
            return totalPrice;
        }
        
    }
    
}
