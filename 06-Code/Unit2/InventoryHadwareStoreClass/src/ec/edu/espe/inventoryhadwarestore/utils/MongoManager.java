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
import java.util.Properties;
import org.bson.Document;

public class MongoManager {
    public static void saveTool(int id,String name,String brand,int quantity,float price,String category,String quality) throws UnknownHostException{       
        try {            
            Gson gson = new Gson();
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority");   
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document productregistry = new Document();           
            productregistry.append("_id", id).append("name",name).append("brand",brand)
                    .append("quantity",quantity).append("price",price).append("category",category).append("quality",quality); 
            collection.insertOne(productregistry);
            mongoClient.close();
        }
        catch (Exception e){
            System.out.println("Save Error..");
        }
    }    
    public static void saveElectricTool(int id,String name,String brand,int quantity,float price,String category,String quality,String ESource) throws UnknownHostException{       
        try {            
            Gson gson = new Gson();
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority");   
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document productregistry = new Document();           
            productregistry.append("_id", id).append("name",name).append("brand",brand)
                    .append("quantity",quantity).append("price",price).append("category",category).append("quality",quality).append("Electric source",ESource); 
            collection.insertOne(productregistry);
            mongoClient.close();
        }
        catch (Exception e){
            System.out.println("Save Error..");
        }
    }
        public static void saveMaterial(int id,String name,String brand,int quantity,float price,String category,float weight) throws UnknownHostException{       
        try {            
            Gson gson = new Gson();
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority");   
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document productregistry = new Document();           
            productregistry.append("_id", id).append("name",name).append("brand",brand)
                    .append("quantity",quantity).append("price",price).append("category",category).append("weight", weight);
            collection.insertOne(productregistry);
            mongoClient.close();
        }
        catch (Exception e){
            System.out.println("Save Error..");
        }  
    }
    public static void find(String nameToFind){
        try {
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document found = (Document) collection.find(Filters.eq("name",nameToFind)).first();
            System.out.println(found.toString());
            mongoClient.close();
        }
        catch (Exception e){
            System.out.println("Find Error..");
        }
    }
    public static void delete(String name){
             try {
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");

            collection.deleteOne(Filters.gte("name",name));
            mongoClient.close();
            
        }
        catch (Exception e){
               System.out.println("No funciono el delete");  
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
    public static void updateBrand(String oldBrand,String newBrand){
        try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("Example"); 
            Document firstDocument;
            firstDocument = collection.find().filter(Filters.eq("name", oldBrand)).first();           
            firstDocument.replace("name",newBrand);           
            collection.replaceOne(Filters.gte("name",oldBrand), firstDocument);
            mongoClient.close();
        }
        catch(Exception e){
            System.out.println("Update brand error");
        }

    }
     public static void updateQuantity(int oldQuantity,int newQuantity){
        try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("Example"); 
            Document firstDocument;
            firstDocument = collection.find().filter(Filters.eq("name", oldQuantity)).first();           
            firstDocument.replace("name",newQuantity);           
            collection.replaceOne(Filters.gte("name",oldQuantity), firstDocument);
            mongoClient.close();
        }
        catch(Exception e){
            System.out.println("Update Quantity error");
        }

    }   
        
}
