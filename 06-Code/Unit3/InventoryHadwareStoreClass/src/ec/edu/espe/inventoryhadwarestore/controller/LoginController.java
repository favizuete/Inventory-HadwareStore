/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import ec.edu.espe.inventoryhadwarestore.model.Admin;
import ec.edu.espe.inventoryhadwarestore.view.LogIn;
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
public class LoginController implements ActionListener, MouseListener{
    LogIn login;
    Admin admin;

    public LoginController(LogIn login, Admin admin) {
        this.login = login;
        this.admin = admin;
        this.login.setLocationRelativeTo(null);
        this.login.setVisible(true);
        this.login.btnExit.addActionListener(this);
        this.login.btnLogin.addActionListener(this);
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login.btnLogin){
        String user = login.txtUser.getText();
        String password = login.txtPassword.getText();
        if(user.equals(admin.getUser())){
            if(password.equals(admin.getPassword())){
                JOptionPane.showMessageDialog(null, "Bienvenido " + login.txtUser.getText());
                MainMenu menu = new MainMenu();
                MainMenuController menuController = new MainMenuController(menu);
                menu.setVisible(true);
                this.login.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
            }
        }
        else{
          JOptionPane.showMessageDialog(null,"Usuario Incorrecto");  
        }
                     
        }
        if(e.getSource()==login.btnExit){
            this.login.dispose();
            
            
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
