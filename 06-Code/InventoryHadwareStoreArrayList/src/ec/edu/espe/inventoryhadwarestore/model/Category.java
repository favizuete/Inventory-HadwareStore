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
public class Category {
    private String idCategory;
    private String nameCategory;

    public Category(String idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", nameCategory=" + nameCategory + '}';
    }
    
       
    /**
     * @return the idCategory
     */
    public String getIdCategory() {
        return idCategory;
    }

    /**
     * @param idCategory the idCategory to set
     */
    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * @return the nameCategory
     */
    public String getNameCategory() {
        return nameCategory;
    }

    /**
     * @param nameCategory the nameCategory to set
     */
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    
    
}
