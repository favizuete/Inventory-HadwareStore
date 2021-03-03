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

    public ConstructionMaterial(float weight, int id, String name, String brand, int quantity, float price, String category) {
        super(id, name, brand, quantity, price, category);
        this.weight = weight;
    }


      @Override
    public void add(int quantityToAdd){
        int quantity = getQuantity();
        int totalquantity= quantity + quantityToAdd;
        setQuantity(totalquantity);
       
    }
      @Override
    public void sell(int quantityToSell){
        int quantity = getQuantity();
        int totalquantity = quantity - quantityToSell;
        if(totalquantity<0){
            System.out.println("No hay stock suficiente para la cantidad solicitada");
 
        }
        else{
            setQuantity(totalquantity);
        }
        
    }
    
    
    
    
    @Override
    public String toString() {
        return "ConstructionMaterial{" + "wegith=" + weight + '}';
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

   
