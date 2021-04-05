/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.controller;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.inventoryhadwarestore.model.AdditionalValue;
import ec.edu.espe.inventoryhadwarestore.model.ConstructionMaterial;
import ec.edu.espe.inventoryhadwarestore.model.ElectricTool;
import ec.edu.espe.inventoryhadwarestore.model.Inventory;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.Tool;
import ec.edu.espe.inventoryhadwarestore.utils.FileManager;
import ec.edu.espe.inventoryhadwarestore.utils.MongoManager;
import ec.edu.espe.inventoryhadwarestore.utils.Persistence;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.bson.Document;


/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class InventoryController {
    private Inventory inventory = new Inventory();
    private static InventoryController instance;

    public InventoryController(Inventory inventory) {
        this.inventory = inventory;
    }
    public InventoryController(){        
    }
    public static InventoryController getInstance(Inventory inventory) {
        if (instance == null) {
            instance = new InventoryController(inventory);
        }
        return instance;
    }
    public void readProducts(){
        Gson gson = new Gson();
        MongoClientURI uri = new MongoClientURI(
        "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority");   
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("Example");
        ArrayList<Product> productlist = new ArrayList<>();
        ArrayList<Document> productDList = new ArrayList<>();
        productDList = collection.find().into(new ArrayList<>());
        for (Document product : productDList) {
            String category = (String) product.get("category");
            String productString = product.toJson();
            if("Herramienta".equals(category)){
                Tool tool = gson.fromJson(productString, Tool.class);
                productlist.add(tool);
            }else if("Material".equals(category)){
                ConstructionMaterial material = gson.fromJson(productString, ConstructionMaterial.class);
                productlist.add(material);
            }else if("Herramienta electrica".equals(category)){
                ElectricTool Etool = gson.fromJson(productString, ElectricTool.class);
                productlist.add(Etool);
            }             
        }
        getInventory().setProducts(productlist);
        mongoClient.close();
    }
        public void addProduct(Product product) throws UnknownHostException {
        Persistence persistence = new MongoManager();
        Gson gson = new Gson();
        getInventory().getProducts().add(product);
        String jsonProduct = gson.toJson(product);
        System.out.println(jsonProduct);
        boolean saved = persistence.save("Example",jsonProduct);   
    }
        public void updateProduct(Product product, String name){
            Persistence persistence = new MongoManager();
            Gson gson = new Gson();
            String jsonProduct = gson.toJson(product);
            System.out.println(jsonProduct);
            boolean updated = persistence.update("Example", jsonProduct, name);
        }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
