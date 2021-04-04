/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import com.google.gson.Gson;
import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.utils.MongoManager;
import ec.edu.espe.inventoryhadwarestore.view.EnterQuantity;
import ec.edu.espe.inventoryhadwarestore.view.MainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class EnterQuantityController implements ActionListener, MouseListener{
    EnterQuantity quan;
    InventoryController inventoryController;

    public EnterQuantityController(EnterQuantity quan, InventoryController inventoryController) {
        this.quan = quan;
        this.inventoryController = inventoryController;
        this.quan.setLocationRelativeTo(null);
        this.quan.setVisible(true);
        this.quan.btnExit.addActionListener(this);
        this.quan.btnRegistry.addActionListener(this);
        this.quan.btnReturn.addActionListener(this);
        this.quan.btnReload.addActionListener(this);
    }
    
    
        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==quan.btnRegistry){
        Gson gson = new Gson();
        inventoryController.readProducts();
        Inventory inventory = inventoryController.getInventory();
        Boolean found = false;
        int quant=0;
        for(Product product : inventory.getProducts()){
            if(product.getName().equals(quan.txtProductToAdd.getText())){
                found = true;
                int quantityToAdd = (int) quan.spnQuantityOfProduct.getValue();
                int oldQuantity = product.getQuantity();
                String name = product.getName();
                product.add(quantityToAdd);
                quant = product.getQuantity();
                gson.toJson(product);
                MongoManager.updateQuantity(name, quant);
            }
        }
        if(found==true){
            JOptionPane.showMessageDialog(null,"Cantidad añadida registrada"); 
            quan.lbTotalQuantity.setText(Integer.toString(quant));
        }else{
            JOptionPane.showMessageDialog(null,"Producto no existente o Error del Sistema"); 
        }
        }
        if(e.getSource()==quan.btnExit){
            this.quan.dispose();
        }
        if(e.getSource()==quan.btnReturn){
            MainMenu menu = new MainMenu();
            MainMenuController menuController = new MainMenuController(menu);
            this.quan.dispose();
        }
        if(e.getSource()==quan.btnReload){
            EnterQuantity enterquan = new EnterQuantity();
            EnterQuantityController quanController = new EnterQuantityController(enterquan,inventoryController);
            this.quan.dispose();

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
