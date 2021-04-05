/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 * @author Pablo Yánez ESPE-DCCO
 */
public class ConstructionMaterial extends Product{
    
      private float weight;

    public ConstructionMaterial(int id, String name, String brand, int quantity, float price, String category,float weight) {
        super(id, name, brand, quantity, price, category);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
       
    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
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

   
