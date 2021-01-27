/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventory.model;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Customer {
    private String name;
    private String adress;
    private int phonenumber;
    private String mail;
    private String id;

    public Customer(String name, String adress, int phonenumber, String mail, String id) {
        this.name = name;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", adress=" + adress + ", phonenumber=" + phonenumber + ", mail=" + mail + ", id=" + id + '}';
    }

    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the phonenumber
     */
    public int getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
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
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
}
