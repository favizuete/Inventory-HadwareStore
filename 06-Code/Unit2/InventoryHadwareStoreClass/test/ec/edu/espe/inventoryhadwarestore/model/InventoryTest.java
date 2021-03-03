/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pablo Yanez CodeMasters ESPE-DCCO
 */
public class InventoryTest {
    
    public InventoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Inventory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Inventory instance = new Inventory();
        String expResult = "Inventory";
        String result = "Inventory";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of login method, of class Inventory.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Admin admin = null;
        Inventory instance = new Inventory();
        instance.login(admin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readProducts method, of class Inventory.
     */
    @Test
    public void testReadProducts() {
        System.out.println("readProducts");
        Inventory instance = new Inventory();
        instance.readProducts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduct method, of class Inventory.
     */
    @Test
    public void testAddProduct() throws Exception {
        System.out.println("addProduct");
        Product product = null;
        Inventory instance = new Inventory();
        instance.addProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducts method, of class Inventory.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        Inventory instance = new Inventory();
        ArrayList<Product> expResult = null;
        ArrayList<Product> result = null;
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setProducts method, of class Inventory.
     */
    @Test
    public void testSetProducts() {
        System.out.println("setProducts");
        ArrayList<Product> products = null;
        Inventory instance = new Inventory();
        instance.setProducts(products);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testReadFromMongoDb(){
        Inventory inventory = new Inventory();        
        inventory.readProductsFromMongoDB();        
    }
    
}
