/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Customer {
    private String nameCustomer;
    private String adress;
    private int phoneNumber;
    private String mail;
    private int id;

    public Customer(String nameCustomer, String adress, int phoneNumber, String mail, int id) {
        this.nameCustomer = nameCustomer;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "nameCustomer=" + nameCustomer + ", adress=" + adress + ", phoneNumber=" + phoneNumber + ", mail=" + mail + ", id=" + id + '}';
    }
    
    

    /**
     * @return the nameCustomer
     */
    public String getNameCustomer() {
        return nameCustomer;
    }

    /**
     * @param nameCustomer the nameCustomer to set
     */
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
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
