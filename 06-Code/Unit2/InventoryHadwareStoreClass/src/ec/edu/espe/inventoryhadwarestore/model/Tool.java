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
public class Tool {
    
    private String quality;

    public Tool(String quality) {
        this.quality = quality;
    }
    /**
     * @return the quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Tool{" + "quality=" + quality + '}';
    }
    
    
    
    
}
