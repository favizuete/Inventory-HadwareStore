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

    public ConstructionMaterial(int id, String name, String brand, int quantity, float price, String category) {
        super(id, name, brand, quantity, price, category);
    }

    public ConstructionMaterial() {
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

   
