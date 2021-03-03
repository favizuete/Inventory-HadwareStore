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

    public Tool(String quality, int id, String name, String brand, int quantity, float price, String category) {
        super(id, name, brand, quantity, price, category);
        this.quality = quality;
    }
    @Override
    public void add(int quantityToAdd){
        int quantity = getQuantity();
        int totalquantity= quantity + quantityToAdd;
        setQuantity(totalquantity);
       
    }
    @Override
    public float sell(int quantityToSell){
        
        int quantity = getQuantity();
        int totalquantity = quantity - quantityToSell;

        if(totalquantity<0){
            System.out.println("No hay stock suficiente para la cantidad solicitada");
            return -1F;
 
        }
        else{
            float price = getPrice();
            float totalPrice = price*quantity;
            if("Alta".equals(getQuality())){
                totalPrice = (float) (totalPrice*1.5F);
            }
            else if("Baja".equals(getQuality())){
                totalPrice = (float) (totalPrice*0.8F);
            }
            else{
                System.out.println("Ninguna calidad reconocida");
            }
            
            setQuantity(totalquantity);
            return totalPrice;
        }
        
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public Tool(int id, String name, String brand, int quantity, float price, String category) {
        super(id, name, brand, quantity, price, category);
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
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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
