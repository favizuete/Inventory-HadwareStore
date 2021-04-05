/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.ElectricTool;
import ec.edu.espe.inventoryhadwarestore.model.Product;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class ElectricToolController extends ProductController{
    ElectricTool eTool = (ElectricTool) super.getProduct();
    public ElectricToolController(Product product) {
        super(product);
    }
    
    
    @Override
    public void addQuantity(int quantityToAdd) {
        int quantity = eTool.getQuantity();
        int totalquantity= quantity + quantityToAdd;
        eTool.setQuantity(totalquantity);
    }

    @Override
    public float sellQuantity(int quantityToSell) {
        int quantity = eTool.getQuantity();
        int totalquantity = quantity - quantityToSell;
        if(totalquantity<0){
            System.out.println("No hay stock suficiente para la cantidad solicitada");
            return -1F; 
        }
        else{
            float price = eTool.getPrice();
            float totalPrice = price*quantity;
            if("Alta".equals(eTool.getQuality())){
                totalPrice = (float) (totalPrice*1.5F);
            }
            else if("Baja".equals(eTool.getQuality())){
                totalPrice = (float) (totalPrice*0.8F);
            }
            else{
                System.out.println("Ninguna calidad reconocida");
            }
            if("Inalámbrica".equals(eTool.getEnergySource())){
                totalPrice = totalPrice + 5F;
            }else if("Alambrica".equals(eTool.getEnergySource())){
                totalPrice = totalPrice +1F;
            }else{
                System.out.println("Ningun tipo de corriente reconocido");
            }
            eTool.setQuantity(totalquantity);
            return totalPrice;
        }
        
    }
    
}
