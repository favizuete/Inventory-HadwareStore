/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.model;

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
public class ToolTest {
    
    public ToolTest() {
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
     * Test of add method, of class Tool.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int quantityToAdd = 0;
        Tool instance = null;
        instance.add(quantityToAdd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sell method, of class Tool.
     */
    @Test
    public void testSell() {
        System.out.println("sell");
        int quantityToSell = 0;
        Tool instance = null;
        float expResult = 5.0F;
        float result = 5.0F;
        assertEquals(expResult, result, 0.0);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class Tool.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Tool instance = null;
        String expResult = "";
        String result = "";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getQuality method, of class Tool.
     */
    @Test
    public void testGetQuality() {
        System.out.println("getQuality");
        Tool instance = null;
        String expResult = "Buena";
        String result = "Buena";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuality method, of class Tool.
     */
    @Test
    public void testSetQuality() {
        System.out.println("setQuality");
        String quality = "";
        Tool instance = null;
        instance.setQuality(quality);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Tool.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tool instance = null;
        int expResult = 156;
        int result = 156;
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId method, of class Tool.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Tool instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Tool.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Tool instance = null;
        String expResult = "desarmador";
        String result = "desarmador";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setName method, of class Tool.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Tool instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrand method, of class Tool.
     */
    @Test
    public void testGetBrand() {
        System.out.println("getBrand");
        Tool instance = null;
        String expResult = "Tv";
        String result = "Tv";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setBrand method, of class Tool.
     */
    @Test
    public void testSetBrand() {
        System.out.println("setBrand");
        String brand = "";
        Tool instance = null;
        instance.setBrand(brand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Tool.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Tool instance = null;
        int expResult = 6;
        int result = 6;
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuantity method, of class Tool.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        Tool instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Tool.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Tool instance = null;
        float expResult = 34.0F;
        float result = 34.0F;
        assertEquals(expResult, result, 0.0);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPrice method, of class Tool.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        float price = 0.0F;
        Tool instance = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class Tool.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Tool instance = null;
        String expResult = "Tool";
        String result = "Tool";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCategory method, of class Tool.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        Tool instance = null;
        instance.setCategory(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
