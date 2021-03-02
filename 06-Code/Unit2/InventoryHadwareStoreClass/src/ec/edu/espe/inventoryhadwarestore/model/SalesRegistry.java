/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 * @author Christopher Yépez ESPE-DCCO
 */
public class SalesRegistry {

    private String customer;
    private Date date;
    private String id;
    private static int staticTotalSales;
    private ArrayList<Product> selledProducts;

    @Override
    public String toString() {
        return "SalesRegistry{" + "customer=" + customer +"\n"+ ", date=" + date +"\n"+ ", id=" + id + "\n"+", selledProducts=" + selledProducts + '}';
    }
    
    

    public void generateId() {
        String customer = getCustomer();
        char[] charCustomer = new char[2];
        customer.getChars(0, 2, charCustomer, 0);
        String customerNewString = Arrays.toString(charCustomer);
        int sales = getStaticTotalSales();
        int totalsales = sales + 1;
        setStaticTotalSales(totalsales);
        Date date = getDate();
        String finalId = customerNewString + String.valueOf(totalsales) + String.valueOf(date.getDate());
        System.out.println(finalId);
        setId(finalId);
    }

    public SalesRegistry() {
    }

    public SalesRegistry(String customer, Date date, String id, ArrayList<Product> selledProducts) {
        this.customer = customer;
        this.date = date;
        this.id = id;
        this.selledProducts = selledProducts;
    }

    public ArrayList<Product> getSelledProducts() {
        return selledProducts;
    }

    public void setSelledProducts(ArrayList<Product> selledProducts) {
        this.selledProducts = selledProducts;
    }

    /**
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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

    /**
     * @return the staticTotalSales
     */
    public static int getStaticTotalSales() {
        return staticTotalSales;
    }

    /**
     * @param aStaticTotalSales the staticTotalSales to set
     */
    public static void setStaticTotalSales(int aStaticTotalSales) {
        staticTotalSales = aStaticTotalSales;
    }

}
