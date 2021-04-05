/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.Tool;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class ToolController extends ProductController{
    Tool tool = (Tool) super.getProduct();

    public ToolController(Product product) {
        super(product);
    }

    
    @Override
    public void addQuantity(int quantityToAdd) {
        
        int quantityx = tool.getQuantity();
        int totalquantity= quantityx + quantityToAdd;
        tool.setQuantity(totalquantity);
    }

    @Override
    public float sellQuantity(int quantityToSell) {
        int quantity = tool.getQuantity();
        int totalquantity = quantity - quantityToSell;

        if(totalquantity<0){
            System.out.println("No hay stock suficiente para la cantidad solicitada");
            return -1F;
 
        }
        else{
            float price = tool.getPrice();
            float totalPrice = price*quantity;
            if("Alta".equals(tool.getQuality())){
                totalPrice = (float) (totalPrice*1.5F);
            }
            else if("Baja".equals(tool.getQuality())){
                totalPrice = (float) (totalPrice*0.8F);
            }
            else{
                System.out.println("Ninguna calidad reconocida");
            }            
            getProduct().setQuantity(totalquantity);
            return totalPrice;
        }
    }
    
}
