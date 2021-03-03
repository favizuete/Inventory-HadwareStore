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
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.util.Properties;
import org.bson.Document;

public class MongoManager {
    public static void save(int id,String name,String brand,int quantity,float price,String category) throws UnknownHostException{       
        try {            
            Gson gson = new Gson();
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/Proyect1?retryWrites=true&w=majority"); 
            
            MongoClient mongoClient = new MongoClient(uri);
            System.out.println("Paso el ");
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document productregistry = new Document();           
            productregistry.append("id", id).append("name",name).append("brand",brand)
                    .append("quantity",quantity).append("price",price).append("category",category); 
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
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
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
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
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
    public static void update(String nameToChange,String nameToUpdate){
            try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://dbChris:inventory123@proyect1.jfdts.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection collection = database.getCollection("Example");
            Document firstDocument = (Document) collection.find(Filters.eq("name", nameToChange)).first();
            System.out.println(firstDocument.toJson());
            collection.updateOne(firstDocument,
                    new Document("name",nameToUpdate));
            
            System.out.println("\nUpdated third document:");
            Document newDocument = (Document) collection.find(Filters.eq("name", nameToUpdate)).first();
            System.out.println(newDocument.toJson());  
            mongoClient.close();
            }
            catch(Exception e){
                System.out.println("No funciono el update");
            }
             
    }
        
}
