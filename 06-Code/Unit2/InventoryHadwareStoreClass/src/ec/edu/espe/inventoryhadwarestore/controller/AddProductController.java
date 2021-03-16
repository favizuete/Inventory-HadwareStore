/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Admin;
import ec.edu.espe.inventoryhadwarestore.model.ConstructionMaterial;
import ec.edu.espe.inventoryhadwarestore.model.ElectricTool;
import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.Tool;
import ec.edu.espe.inventoryhadwarestore.view.AddProduct;
import ec.edu.espe.inventoryhadwarestore.view.MainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class AddProductController implements ActionListener, MouseListener{
    AddProduct add;
    Inventory inventory;


    public AddProductController(AddProduct add,Inventory inventory) {
        this.add = add;
        this.inventory = inventory;
        this.add.setLocationRelativeTo(null);
        this.add.setVisible(true);
        this.add.btnExit.addActionListener(this);
        this.add.btnCategory.addActionListener(this);
        this.add.btnOther.addActionListener(this);
        this.add.btnReturn.addActionListener(this);
        this.add.btnRegistry.addActionListener(this);
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add.btnRegistry){
        inventory.readProductsFromMongoDB();
        if(add.listCategory27.getSelectedIndex()==0){
           String id = add.txtId.getText();
           int id1 = Integer.parseInt(id);
           String name =add.txtName.getText();
           String brand = add.listBrand.getSelectedValue();
           int quantity = (int) add.spnQuantity.getValue();
           int price1 =  (int) add.spnPrice.getValue();
           float price = (float) price1;
           String quality = add.listQuality.getSelectedValue();
           String category = add.listCategory27.getSelectedValue();
           Product tool =new  Tool(id1,name,brand,quantity,price,category,quality);
            try {
                inventory.addProduct(tool);
                add.btnOther.setVisible(true);
                add.btnRegistry.setVisible(false);
            } catch (UnknownHostException ex) {
                Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
            }

       }else if(add.listCategory27.getSelectedIndex()==1){
            String id = add.txtId.getText();
            int id1 = Integer.parseInt(id);
            String name =add.txtName.getText();
            String brand = add.listBrand.getSelectedValue();
            int quantity = (int) add.spnQuantity.getValue();
            int price1 =  (int) add.spnPrice.getValue();
            float price = (float) price1;           
            String quality = add.listQuality.getSelectedValue();
            String eSource = add.listSource.getSelectedValue();
            String category = "Herramienta electrica";           
            Product eTool = new ElectricTool(id1,name,brand,quantity,price,category,quality,eSource);
            try {
                inventory.addProduct(eTool);
                add.btnOther.setVisible(true);
                add.btnRegistry.setVisible(false);
            } catch (UnknownHostException ex) {
                Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
            }                              
       }else if(add.listCategory27.getSelectedIndex()==2){
            String id = add.txtId.getText();
            int id1 = Integer.parseInt(id);
            String name =add.txtName.getText();
            String brand = add.listBrand.getSelectedValue();
            int quantity = (int) add.spnQuantity.getValue();
            int price1 =  (int) add.spnPrice.getValue(); 
            float price = (float) price1;
            String category = "Material";
            int weight1 = (int) add.spnWeight.getValue();
            float weight = (float) weight1;
            Product material = new ConstructionMaterial(id1,name,brand,quantity,price,category,weight);
            try {
                inventory.addProduct(material);
                add.btnOther.setVisible(true);
                add.btnRegistry.setVisible(false);
            } catch (UnknownHostException ex) {
                Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
            }            
       }else{
        JOptionPane.showMessageDialog(null,"No ha seleccionado una categoría"); 
       }            
        }         
        if(e.getSource()==add.btnCategory){
            if(add.listCategory27.getSelectedIndex()==0){
               add.AddProductPanel.setVisible(true);
               add.weightPanel.setVisible(false);
               add.eSourcePanel.setVisible(false);
               add.CategoryPannel.setVisible(false);
           }else if(add.listCategory27.getSelectedIndex()==1){
               add.AddProductPanel.setVisible(true);
               add.weightPanel.setVisible(false);    
               add.CategoryPannel.setVisible(false);        
         }else if(add.listCategory27.getSelectedIndex()==2){
               add.AddProductPanel.setVisible(true);
               add.eSourcePanel.setVisible(false);
               add.qualityPanel.setVisible(false);
               add.CategoryPannel.setVisible(false);          

           }else{
            JOptionPane.showMessageDialog(null,"No ha seleccionado una categoría"); 
           }            
        }
        if(e.getSource()==add.btnOther){
            AddProduct add = new AddProduct();
            AddProductController addController = new AddProductController(add,inventory);
            this.add.dispose();
        }
        if(e.getSource()==add.btnReturn){
            MainMenu menu = new MainMenu();
            MainMenuController menuController = new MainMenuController(menu);
            this.add.dispose();
            
        }
        if(e.getSource()==add.btnExit){
            this.add.dispose();
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
