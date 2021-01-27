/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import java.util.Scanner;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Customer {

    private String customerName;
    private String address;
    private int phoneNumber;
    private String mail;
    private int id;
    private String purchasedProduct;
    private float totalDebt;

    public Customer(String nameCustomer, String adress, int phoneNumber, String mail, int id,
            String purchasedProduct, float totalDebt) {
        this.customerName = nameCustomer;
        this.address = adress;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.id = id;
        this.purchasedProduct = purchasedProduct;
        this.totalDebt = totalDebt;
    }

    @Override
    public String toString() {
        return "Customer{" + "nameCustomer=" + customerName + ", adress=" + address + ", phoneNumber=" + phoneNumber + ", mail=" + mail + ", id=" + id + '}';
    }

    /**
     * @return the customerName
     */
    public String getNameCustomer() {
        return customerName;
    }

    /**
     * @param nameCustomer the customerName to set
     */
    public void setNameCustomer(String nameCustomer) {
        this.customerName = nameCustomer;
    }

    /**
     * @return the address
     */
    public String getAdress() {
        return address;
    }

    /**
     * @param adress the address to set
     */
    public void setAdress(String adress) {
        this.address = adress;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
