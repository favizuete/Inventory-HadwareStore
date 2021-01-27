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
public class Depot {
  private Stock[] stocks = new Stock[1];

    public Depot() {
    }

    @Override
    public String toString() {
        return "Depot{" + "stocks=" + stocks + '}';
    }
  
  

    /**
     * @return the stocks
     */
    public Stock[] getStocks() {
        return stocks;
    }

    /**
     * @param stocks the stocks to set
     */
    public void setStocks(Stock[] stocks) {
        this.stocks = stocks;
    }
  
  
    
}
