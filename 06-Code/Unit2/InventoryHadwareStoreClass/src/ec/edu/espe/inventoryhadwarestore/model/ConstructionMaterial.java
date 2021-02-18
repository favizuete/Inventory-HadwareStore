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
public class ConstructionMaterial {
    
      private float wegith;

    @Override
    public String toString() {
        return "ConstructionMaterial{" + "wegith=" + wegith + '}';
    }

    /**
     * @return the wegith
     */
    public float getWegith() {
        return wegith;
    }

    /**
     * @param wegith the wegith to set
     */
    public void setWegith(float wegith) {
        this.wegith = wegith;
    }
}

   
