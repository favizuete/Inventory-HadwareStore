/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.view.AddProduct;
import ec.edu.espe.inventoryhadwarestore.view.DeleteProduct;
import ec.edu.espe.inventoryhadwarestore.view.EnterQuantity;
import ec.edu.espe.inventoryhadwarestore.view.MainMenu;
import ec.edu.espe.inventoryhadwarestore.view.ModifyProduct;
import ec.edu.espe.inventoryhadwarestore.view.SellProduct;
import ec.edu.espe.inventoryhadwarestore.view.ShowInventory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class MainMenuController implements ActionListener, MouseListener{
    MainMenu menu;

    public MainMenuController(MainMenu menu) {
        this.menu = menu;
        this.menu.setLocationRelativeTo(null);
        this.menu.setVisible(true);
        this.menu.mniAdd.addActionListener(this);
        this.menu.mniDelete.addActionListener(this);
        this.menu.mniModify.addActionListener(this);
        this.menu.mniSell.addActionListener(this);
        this.menu.mniAddQuantity.addActionListener(this);
        this.menu.mniShow.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InventoryController inventoryController = new InventoryController();
        if(e.getSource()==menu.mniAdd){
            AddProduct add = new AddProduct();
            AddProductController addController = new AddProductController(add,inventoryController);
            this.menu.dispose();
            
        }
        if(e.getSource()==menu.mniDelete){
            DeleteProduct delete = new DeleteProduct();
            DeleteProductController deleteController = new DeleteProductController(delete,inventoryController);
            this.menu.dispose();
        }
        if(e.getSource()==menu.mniModify){
            ModifyProduct modify = new ModifyProduct();
            ModifyProductController modifyController = new ModifyProductController(modify,inventoryController);
            this.menu.dispose();
        }
        if(e.getSource()==menu.mniShow){
            ShowInventory show = new ShowInventory();
            ShowInventoryController showController = new ShowInventoryController(show,inventoryController);
            this.menu.dispose();
        }
        if(e.getSource()==menu.mniAddQuantity){
            EnterQuantity enterquan = new EnterQuantity();
            EnterQuantityController quanController = new EnterQuantityController(enterquan,inventoryController);
            this.menu.dispose();
        }
        if(e.getSource()==menu.mniSell){
            SellProduct sell = new SellProduct();
            SellProductController sellController = new SellProductController(sell,inventoryController);
            this.menu.dispose();
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
