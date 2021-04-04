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
 * 
 */
public class AdditionalValue {

    private float value;
    private float iva = (float) 0.12;

    private static AdditionalValue instance;

    private AdditionalValue(float value) {
        this.value = value;
    }

    public static AdditionalValue getInstance(Float value) {
        if (instance == null) {
            instance = new AdditionalValue(value);
        }
        return instance;
    }

    public float total(AdditionalValue aValue) {
        float total;
        total = aValue.getIva() * aValue.getValue();
        total += aValue.getValue();
        return total;
    }

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * @return the iva
     */
    public float getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(float iva) {
        this.iva = iva;
    }

}
