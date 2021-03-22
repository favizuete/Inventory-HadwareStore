/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.view.MainMenu;
import ec.edu.espe.inventoryhadwarestore.view.SaleRegistry;
import ec.edu.espe.inventoryhadwarestore.view.SellProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class SaleRegistryController implements ActionListener, MouseListener{
    SaleRegistry sale;

    public SaleRegistryController(SaleRegistry sale) {
        this.sale = sale;
        this.sale.setLocationRelativeTo(null);
        this.sale.setVisible(true);
        this.sale.btnReturn.addActionListener(this);
        this.sale.btnSellOther.addActionListener(this);
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sale.btnSellOther){
            SellProduct sell = new SellProduct();
            Inventory inventory = new Inventory();
            SellProductController sellController = new SellProductController(sell,inventory);
            this.sale.dispose();
        }
        if(e.getSource()==sale.btnReturn){
            MainMenu menu = new MainMenu();
            MainMenuController menuController = new MainMenuController(menu);
            this.sale.dispose();   
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
