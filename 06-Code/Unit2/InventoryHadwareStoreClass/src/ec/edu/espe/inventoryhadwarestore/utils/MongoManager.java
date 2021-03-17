/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.utils;

import com.google.gson.Gson;
import java.net.UnknownHostException;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
import com.google.gson.Gson;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.inventoryhadwarestore.model.ConstructionMaterial;
import ec.edu.espe.inventoryhadwarestore.model.ElectricTool;
import ec.edu.espe.inventoryhadwarestore.model.Product;
import ec.edu.espe.inventoryhadwarestore.model.Tool;
import java.util.Properties;
import org.bson.Document;

public class MongoManager {
    public static void save(Product product){
        MongoClientURI uri = new MongoClientURI(
        "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection collection = database.getCollection("Example");
        Document productregistry = new Document(); 
        productregistry.append("_id", product.getId()).append("name",product.getName()).append("brand",product.getBrand())
                .append("quantity",product.getQuantity()).append("price",product.getPrice())
                .append("category",product.getCategory());

        if("Herramienta".equals(product.getCategory())){
            Tool tool = (Tool) product;
            productregistry.append("quality",tool.getQuality()); 
        }
        if("Material".equals(product.getCategory())){
            ConstructionMaterial material = (ConstructionMaterial) product;
            productregistry.append("weight",material.getWeight());
            
        }if("Herramienta electrica".equals(product.getCategory())){
            ElectricTool eTool = (ElectricTool) product;
            productregistry.append("quality",eTool.getQuality()).append("Energy Source",eTool.getEnergySource());            
        }
        collection.insertOne(productregistry);
        mongoClient.close();   
    }
    
    public static void find(String nameToFind){
        try {
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document found = (Document) collection.find(Filters.eq("name",nameToFind)).first();
            if(found!=null){
                System.out.println("Encontrado");
                System.out.println(found.toString());   
                mongoClient.close();
            }
            else{
                System.out.println("No encontrado");
                mongoClient.close();   
            }
        }
        catch (Exception e){
            System.out.println("Find Error..");
        }
    }
    public static boolean delete(String name){
             try {
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document found = (Document) collection.find(Filters.eq("name",name)).first();
            if(found!=null){
                collection.deleteOne(Filters.eq("name",name)); 
                mongoClient.close();                
               return true;
            }
            else{
                mongoClient.close();   
                return false;
            }
        }
        catch (Exception e){
               System.out.println("No funciono el delete"); 
               return false;
        }
    }
    public static void updateName(String nameToChange,String nameToUpdate){
            try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("Example"); 
            Document firstDocument;
            firstDocument = collection.find().filter(Filters.eq("name", nameToChange)).first();           
            firstDocument.replace("name",nameToUpdate);
            collection.replaceOne(Filters.gte("name",nameToChange), firstDocument);
            mongoClient.close();
            }
            catch(Exception e){
                System.out.println("Update name ERROR");
            }
            
    }
    public static void updateBrand(String name,String newBrand){
        try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("Example"); 
            Document firstDocument;
            firstDocument = collection.find().filter(Filters.eq("name", name)).first();           
            firstDocument.replace("brand",newBrand);           
            collection.replaceOne(Filters.gte("name",name), firstDocument);
            mongoClient.close();
        }
        catch(Exception e){
            System.out.println("Update brand error");
        }

    }
     public static void updateQuantity(String name,int newQuantity){
        try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("Example"); 
            Document firstDocument;
            firstDocument = collection.find().filter(Filters.eq("name",name)).first();           
            firstDocument.replace("quantity",newQuantity);           
            collection.replaceOne(Filters.gte("name",name), firstDocument);
            mongoClient.close();
        }
        catch(Exception e){
            System.out.println("Update Quantity error");
        }

    }   


}
