/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 * @author Vanessa Zurita ESPE-DCCO
 * @author Christopher Yépez ESPE-DCCO
 */
public class Tool extends Product{
    
    private String quality;

    public Tool(int id, String name, String brand, int quantity, float price, String category,String quality) {
        super(id, name, brand, quantity, price, category);
        this.quality = quality;       
    }    
    public Tool(int id, String name, String brand, int quantity, float price, String category) {
        super(id, name, brand, quantity, price, category);
    }


    
    @Override
    public String toString() {
        return super.toString(); 
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public void setId(int id) {
        this._id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }


    
    
    
    
}
