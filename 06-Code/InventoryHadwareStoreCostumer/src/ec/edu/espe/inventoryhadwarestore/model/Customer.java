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

    public Customer(String nameCustomer, String adress, int phoneNumber, String mail, int id) {
        this.customerName = nameCustomer;
        this.address = adress;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.id = id;
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

    public Customer enterCustomer() {
        Scanner scanner = new Scanner(System.in);

        String nameCustomer;
        String adress;
        int phoneNumber;
        String mail;
        int id;

        System.out.println("Ingrese el nombre del cliente: ");
        nameCustomer = scanner.nextLine();

        System.out.println("Ingrese dirección: ");
        adress = scanner.nextLine();

        System.out.println("Ingrese la marca del producto: ");
        phoneNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese email del cliente: ");
        mail = scanner.nextLine();

        System.out.println("Ingrese la cantidad existente del producto (numero entero): ");
        id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = new Customer(nameCustomer, adress, phoneNumber, mail, id);

        return customer;

    }

}
