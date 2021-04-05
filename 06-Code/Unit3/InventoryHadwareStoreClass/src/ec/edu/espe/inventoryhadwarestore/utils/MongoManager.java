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

public class MongoManager implements Persistence {
    
    
    @Override
    public boolean save(String table,String data){
        MongoClientURI uri = new MongoClientURI(
        "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection collection = database.getCollection("Example");
        Document productregistry = null;
        boolean saved = false;
        try{
            productregistry = Document.parse(data);  
            saved = true;
        }
        catch(Exception e){
            saved = false;
        }

        collection.insertOne(productregistry);
        mongoClient.close();   
        return saved;
    }
    
    @Override
    public String find(String table,String data,String nameToFind){
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
                return (found.toJson());
            }
            else{
                System.out.println("No encontrado");
                mongoClient.close();   
                return "null";
            }
        }
        catch (Exception e){
            System.out.println("Find Error..");
            return "null";
        }
        
    }
    @Override
    public  boolean delete(String table,String name){
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
    @Override
    public boolean update(String table, String dataToUpdate, String finder) {
        try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("Example");
            Document productRegistry;
            productRegistry = collection.find().filter(Filters.eq("name",finder)).first();
            Document updateRegistry;
            updateRegistry = Document.parse(dataToUpdate);
            collection.replaceOne(productRegistry, updateRegistry);
            mongoClient.close();    
            return true;
        }
        catch(Exception e){
            return false;
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
