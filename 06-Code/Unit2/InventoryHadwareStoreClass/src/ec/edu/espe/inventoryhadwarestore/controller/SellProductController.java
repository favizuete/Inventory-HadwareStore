/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import com.google.gson.Gson;
import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.SalesRegistry;
import ec.edu.espe.inventoryhadwarestore.utils.MongoManager;
import ec.edu.espe.inventoryhadwarestore.view.MainMenu;
import ec.edu.espe.inventoryhadwarestore.view.SaleRegistry;
import ec.edu.espe.inventoryhadwarestore.view.SellProduct;
import espe.edu.ec.filemanagerlibrary.FileManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class SellProductController implements ActionListener, MouseListener{
    SellProduct sell;
    InventoryController inventoryController;

    public SellProductController(SellProduct sell, InventoryController inventoryController) {
        this.sell = sell;
        this.inventoryController = inventoryController;
        this.sell.setLocationRelativeTo(null);
        this.sell.setVisible(true);
        this.sell.btnExit.addActionListener(this);
        this.sell.btnSell.addActionListener(this);
        this.sell.btnReturn.addActionListener(this);
    }

    
    
        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sell.btnSell){
        ArrayList<Product> productsToSell = new ArrayList<>();
        Gson gson = new Gson();
        inventoryController.readProducts();
        Boolean found = false;
        int quan=0;
        float totalPrice= 0;
        float addedPrice = 0;
        int quantityToSell= 0;
        for(Product product : inventoryController.getInventory().getProducts()){
            if(product.getName().equals(sell.txtProductToSell.getText())){
                quantityToSell = (int) sell.spinQuantity.getValue();
                int OldQuantity = product.getQuantity();
                addedPrice = product.sell(quantityToSell);
                    if(addedPrice==-1F){
                        JOptionPane.showMessageDialog(null,"Producto no Vendido");
                    }
                    else{
                        found = true;
                        totalPrice = totalPrice + addedPrice;
                        productsToSell.add(product);
                        int newQuantity = product.getQuantity();
                        quan = product.getQuantity();                       
                        sell.txtQuantityValue.setText(Integer.toString(quan));
                        MongoManager.updateQuantity(product.getName(),newQuantity);    
                    }
                        
            }
        }  
        Date date = new Date();
        String id = "";
        SalesRegistry registry = new SalesRegistry(sell.txtName.getText(), date, id, productsToSell,totalPrice);
        registry.generateId();
        String registryString = gson.toJson(registry);
        FileManager.writeFile("RegistroDeVentas.json", registryString);
        if(found==true){
            JOptionPane.showMessageDialog(null,"Cantidad vendida registrada");
            SaleRegistry sale = new SaleRegistry();
            SaleRegistryController saleController = new SaleRegistryController(sale);
            sale.setVisible(true);
            sale.txtGetName.setText(sell.txtName.getText());
            sale.txtGetProduct.setText(sell.txtProductToSell.getText());
            sale.txtGetQuantity.setText(Integer.toString(quantityToSell));
            sale.txtTotalPrice.setText(Float.toString(totalPrice));
            this.sell.setVisible(false);
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Cantidad no registrada"); 
        }
    }
      if(e.getSource()==sell.btnExit){
          this.sell.dispose();
      }  
      if(e.getSource()==sell.btnReturn){
            MainMenu menu = new MainMenu();
            MainMenuController menuController = new MainMenuController(menu);
            this.sell.dispose();
      }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
