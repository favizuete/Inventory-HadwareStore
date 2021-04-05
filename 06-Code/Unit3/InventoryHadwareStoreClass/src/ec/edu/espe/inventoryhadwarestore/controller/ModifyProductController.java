/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.view.MainMenu;
import ec.edu.espe.inventoryhadwarestore.view.ModifyProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class ModifyProductController implements ActionListener, MouseListener{
    ModifyProduct modify;
    InventoryController IController;
    static String nameToModify;

    public ModifyProductController(ModifyProduct modify, InventoryController IController) {
        this.modify = modify;
        this.IController = IController;
        this.modify.setLocationRelativeTo(null);
        this.modify.setVisible(true);
        this.modify.btnExit.addActionListener(this);
        this.modify.btnSearch.addActionListener(this);
        this.modify.btnUpdate.addActionListener(this);
        this.modify.btnReturn.addActionListener(this);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==modify.btnSearch){
            IController.readProducts();
            boolean found = false;
            for(Product product: IController.getInventory().getProducts()){
                 if(product.getName().equals(modify.txtProductMod.getText())){
                     JOptionPane.showMessageDialog(modify,"Producto Encontrado");
                     modify.pnlUpdate.setVisible(true);
                     found = true;
                     nameToModify = product.getName();
                 }
            }
            if(found!=true){
                JOptionPane.showMessageDialog(modify,"Producto no Encontrado");    
            }
            
        }
        if(e.getSource()==modify.btnExit){
            this.modify.dispose();
        }
        if(e.getSource()==modify.btnReturn){
            MainMenu menu = new MainMenu();
            MainMenuController menuController = new MainMenuController(menu);
            this.modify.dispose();
        }
        if(e.getSource()==modify.btnUpdate){
            
            IController.readProducts();
            String brand = modify.txtBrand.getText();
            String name = modify.txtName.getText();
            int price1 =  (int) modify.spnPrice.getValue(); 
            float price = (float) price1;
            for(Product product : IController.getInventory().getProducts()){
                if(nameToModify.equals(modify.txtProductMod.getText())){
                    product.setBrand(brand);
                    product.setName(name);
                    product.setPrice(price);  
                    IController.updateProduct(product,nameToModify);
                    modify.btnUpdate.setVisible(false);
                }

            }

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
