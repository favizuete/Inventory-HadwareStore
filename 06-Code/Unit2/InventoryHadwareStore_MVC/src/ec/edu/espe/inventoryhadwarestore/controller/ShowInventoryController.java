/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.view.MainMenu;
import ec.edu.espe.inventoryhadwarestore.view.ShowInventory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class ShowInventoryController implements ActionListener, MouseListener{
    ShowInventory show;
    Inventory inventory;

    public ShowInventoryController(ShowInventory show, Inventory inventory) {
        this.show = show;
        this.inventory = inventory;
        this.show.setLocationRelativeTo(null);
        this.show.setVisible(true);
        this.show.btnExit.addActionListener(this);
        this.show.btnUpdate.addActionListener(this);
        this.show.btnReturn.addActionListener(this);
        this.show.btnShow.addActionListener(this);
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==show.btnUpdate){
            show.deleteTable();
            show.generateTable();
         
        }
        if(e.getSource()==show.btnShow){
            show.generate();
            show.generateTable();
            show.btnShow.setVisible(false);
            show.btnUpdate.setVisible(true);
   
        }
        if(e.getSource()==show.btnReturn){
            MainMenu menu = new MainMenu();
            MainMenuController menuController = new MainMenuController(menu);
            this.show.dispose();
        }
        if(e.getSource()==show.btnExit){
            this.show.dispose();
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
