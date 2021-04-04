/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventorySimulator;

import ec.edu.espe.inventoryhadwarestore.controller.LoginController;
import ec.edu.espe.inventoryhadwarestore.model.Admin;
import ec.edu.espe.inventoryhadwarestore.view.LogIn;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class InventorySystem {
    public static void main(String[] args) {
        LogIn login;
        LoginController loginController;
        login = new LogIn();
        Admin admin = new Admin("Richard","codemaster23","codemaster");
        loginController = new LoginController(login,admin);
    }

}
