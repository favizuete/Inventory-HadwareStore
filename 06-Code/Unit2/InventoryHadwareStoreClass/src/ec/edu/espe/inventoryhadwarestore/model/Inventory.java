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

    public void login(Admin admin) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el usuario");
        String user = reader.nextLine();
        if (user.equals(admin.getUser())) {
            System.out.println("Ingrese la contraseña");
            String password = reader.nextLine();
            while (!password.equals(admin.getPassword())) {
                System.out.println("Contraseña incorrecta, ingrese de nuevo:");
                password = reader.nextLine();
            }
        } else {
            System.out.println("Usuario incorrecto, ingrese más tarde..!!");
            System.exit(0);
        }
    }

    public void readProducts() {

        Gson gson = new Gson();
        ArrayList<Product> productList = new ArrayList<>();
        try {
            FileReader freader = new FileReader("RegistroProductos.json");
            BufferedReader breader = new BufferedReader(freader);
            String product = breader.readLine();
            do {                            
                Tool products = gson.fromJson(product,Tool.class);                
                productList.addAll(Arrays.asList(products));
                String productx = breader.readLine();
                product = productx;
            } while (product != null);
            setProducts(productList);
        } catch (Exception exception) {
            System.out.println("No se leyó la lista de productos..");
        }
    }
    public void readProductsFromMongoDB(){
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
    }

    public void addProduct(Product product) throws UnknownHostException {
        Gson gson = new Gson();
        getProducts().add(product);
        System.out.println("Product-->" + product);

        String name = product.getName();
        String category = product.getCategory();
        int id = product.getId();
        float price = product.getPrice();
        String brand = product.getBrand();
        int quantity = product.getQuantity();
        if("Herramienta".equals(product.getCategory())){
            Tool tool = (Tool) product;
            String quality = tool.getQuality();
            MongoManager.saveTool(id, name, brand, quantity, price, category, quality);
        }else if("Material".equals(product.getCategory())){
            ConstructionMaterial material = (ConstructionMaterial) product;
            float weight = material.getWeight();
            MongoManager.saveMaterial(id, name, brand, quantity, price, category, weight);
        }else if("Herramienta electrica".equals(product.getCategory())){
            ElectricTool ETool = (ElectricTool) product;
            String quality = ETool.getQuality();
            String ESource = ETool.getEnergySource();
            MongoManager.saveElectricTool(id, name, brand, quantity, price, category, quality, ESource);
        }
        gson.toJson(product);
        FileManager.writeFile("RegistroProductos.json", gson.toJson(product));
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
