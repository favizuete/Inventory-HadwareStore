/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import com.google.gson.Gson;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.inventoryhadwarestore.utils.MongoManager;
import ec.edu.espe.inventoryhadwarestore.utils.Persistence;
import espe.edu.ec.filemanagerlibrary.FileManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author Fausto Vizuete ESPE-DCCO
 */
public class Inventory {

    private ArrayList<Product> products = new ArrayList<>();

    public Inventory() {
    }

    public Inventory(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Stock { products=" + products + "}";
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
        setProducts(productlist);
        mongoClient.close();
    }

    public void addProduct(Product product) throws UnknownHostException {
        Persistence persistence = new MongoManager();
        Gson gson = new Gson();
        getProducts().add(product);
        String jsonProduct = gson.toJson(product);
        System.out.println(jsonProduct);
        boolean saved = persistence.save("Example",jsonProduct);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
