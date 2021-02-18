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
public class ElectricTool {
    private String quality;
    private String energySource;

    @Override
    public String toString() {
        return "ElectricTool{" + "quality=" + quality + ", energySource=" + energySource + '}';
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

    /**
     * @return the energySource
     */
    public String getEnergySource() {
        return energySource;
    }

    /**
     * @param energySource the energySource to set
     */
    public void setEnergySource(String energySource) {
        this.energySource = energySource;
    }
}
