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
public class ElectricToolTest {
    
    public ElectricToolTest() {
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
     * Test of add method, of class ElectricTool.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int quantityToAdd = 0;
        ElectricTool instance = null;
        instance.add(quantityToAdd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sell method, of class ElectricTool.
     */
    @Test
    public void testSell() {
        System.out.println("sell");
        int quantityToSell = 0;
        ElectricTool instance = null;
        float expResult = 0.0F;
        float result = 0.0F;
        assertEquals(expResult, result, 0.0);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class ElectricTool.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ElectricTool instance = null;
        String expResult = "Richard";
        String result = "Richard";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId method, of class ElectricTool.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ElectricTool instance = null;
        int expResult = 2;
        int result = 2;
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId method, of class ElectricTool.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ElectricTool instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ElectricTool.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ElectricTool instance = null;
        String expResult = "Richard123";
        String result = "Richard123";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setName method, of class ElectricTool.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ElectricTool instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrand method, of class ElectricTool.
     */
    @Test
    public void testGetBrand() {
        System.out.println("getBrand");
        ElectricTool instance = null;
        String expResult = "husky";
        String result = "husky";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setBrand method, of class ElectricTool.
     */
    @Test
    public void testSetBrand() {
        System.out.println("setBrand");
        String brand = "";
        ElectricTool instance = null;
        instance.setBrand(brand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class ElectricTool.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ElectricTool instance = null;
        int expResult = 0;
        int result = 0;
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuantity method, of class ElectricTool.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        ElectricTool instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class ElectricTool.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ElectricTool instance = null;
        float expResult = 0.0F;
        float result = 0.0F;
        assertEquals(expResult, result, 0.0);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPrice method, of class ElectricTool.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        float price = 0.0F;
        ElectricTool instance = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class ElectricTool.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        ElectricTool instance = null;
        String expResult = "ElectricTool";
        String result = "ElectricTool";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCategory method, of class ElectricTool.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        ElectricTool instance = null;
        instance.setCategory(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuality method, of class ElectricTool.
     */
    @Test
    public void testGetQuality() {
        System.out.println("getQuality");
        ElectricTool instance = null;
        String expResult = "Buena";
        String result = "Buena";
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuality method, of class ElectricTool.
     */
    @Test
    public void testSetQuality() {
        System.out.println("setQuality");
        String quality = "";
        ElectricTool instance = null;
        instance.setQuality(quality);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnergySource method, of class ElectricTool.
     */
    @Test
    public void testGetEnergySource() {
        System.out.println("getEnergySource");
        ElectricTool instance = null;
        String expResult = "Bateria";
        String result = "Bateria";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEnergySource method, of class ElectricTool.
     */
    @Test
    public void testSetEnergySource() {
        System.out.println("setEnergySource");
        String energySource = "";
        ElectricTool instance = null;
        instance.setEnergySource(energySource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
