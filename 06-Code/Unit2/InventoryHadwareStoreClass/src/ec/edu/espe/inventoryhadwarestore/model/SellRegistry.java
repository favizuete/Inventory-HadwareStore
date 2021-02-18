/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import java.util.Date;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 * @author Christopher Yépez ESPE-DCCO
 */
public class SellRegistry {
    
     private String customer;
     private Date date;
     private String id;
     private static int staticTotalSales;

    public SellRegistry(String customer, Date date, String id) {
        this.customer = customer;
        this.date = date;
        this.id = id;
    }

    public SellRegistry() {
    }

    @Override
    public String toString() {
        return "SellRegistry{" + "customer=" + customer + ", date=" + date + ", id=" + id + '}';
    }
     
    public void recordSale(){
        
        
        
        
    }
    public void generateId(){
        
        
        
        
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
