/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.utils.MongoManager;
import ec.edu.espe.inventoryhadwarestore.utils.Persistence;
import ec.edu.espe.inventoryhadwarestore.view.DeleteProduct;
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
public class DeleteProductController implements ActionListener, MouseListener{
    DeleteProduct delete;
    InventoryController inventoryController;

    public DeleteProductController(DeleteProduct delete, InventoryController inventoryController) {
        this.delete = delete;
        this.inventoryController = inventoryController;
        this.delete.setLocationRelativeTo(null);
        this.delete.setVisible(true);
        this.delete.btnExit.addActionListener(this);
        this.delete.btnDelete.addActionListener(this);
        this.delete.btnReturn.addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete.btnDelete){
            Persistence persistence = new MongoManager();
            String name = delete.txtDelete.getText();         
            boolean validate = persistence.delete("Example",name);
            if(validate==true){
                JOptionPane.showMessageDialog(null,"Borrado Exitoso"); 
            }else{
                JOptionPane.showMessageDialog(null,"Borrado Fallido"); 
            }       
        }
        if(e.getSource()==delete.btnExit){
            this.delete.dispose();
        }
        if(e.getSource()==delete.btnReturn){
            MainMenu menu = new MainMenu();
            MainMenuController menuController = new MainMenuController(menu);
            this.delete.dispose();
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
