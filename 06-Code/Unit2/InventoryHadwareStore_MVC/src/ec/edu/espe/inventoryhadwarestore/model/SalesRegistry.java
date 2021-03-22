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
    private static int TotalSales;
    private ArrayList<Product> selledProducts;
    private float profitInDollars;

    public SalesRegistry() {
    }

    public SalesRegistry(String customer, Date date, String id, ArrayList<Product> selledProducts, float profitInDollars) {
        this.customer = customer;
        this.date = date;
        this.id = id;
        this.selledProducts = selledProducts;
        this.profitInDollars = profitInDollars;
    }
  
    public void generateId() {
        String customer = getCustomer();
        char[] charCustomer = new char[2];
        customer.getChars(0, 2, charCustomer, 0);
        String customerNewString = Arrays.toString(charCustomer);
        int sales = getTotalSales();
        int totalsales = sales + 1;
        setTotalSales(totalsales);
        Date date = getDate();
        String finalId = customerNewString + String.valueOf(totalsales) + String.valueOf(date.getDate());
        System.out.println(finalId);
        setId(finalId);
    }


    @Override
    public String toString() {
        return "SalesRegistry{" + "customer=" + customer + ", date=" + date + ", id=" + id + ", selledProducts=" + selledProducts + ", profitInDollars=" + profitInDollars + '}';
    }


    public ArrayList<Product> getSelledProducts() {
        return selledProducts;
    }

    public void setSelledProducts(ArrayList<Product> selledProducts) {
        this.selledProducts = selledProducts;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public static int getTotalSales() {
        return TotalSales;
    }
    public static void setTotalSales(int aStaticTotalSales) {
        TotalSales = aStaticTotalSales;
    }

    public float getProfitInDollars() {
        return profitInDollars;
    }

    public void setProfitInDollars(float profitInDollars) {
        this.profitInDollars = profitInDollars;
    }

}
