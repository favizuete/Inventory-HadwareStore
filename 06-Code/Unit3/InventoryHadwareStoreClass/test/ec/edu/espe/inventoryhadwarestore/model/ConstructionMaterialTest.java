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
public class ConstructionMaterialTest {
    
    public ConstructionMaterialTest() {
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
     * Test of add method, of class ConstructionMaterial.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int quantityToAdd = 0;
        ConstructionMaterial instance = null;
        instance.add(quantityToAdd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sell method, of class ConstructionMaterial.
     */
    @Test
    public void testSell() {
        System.out.println("sell");
        int quantityToSell = 0;
        ConstructionMaterial instance = null;
        float expResult = 0.0F;
        float result = 0.0F;
        assertEquals(expResult, result, 0.0);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class ConstructionMaterial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConstructionMaterial instance = null;
        String expResult = "CEMENT";
        String result = "Cement";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getWeight method, of class ConstructionMaterial.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        ConstructionMaterial instance = null;
        float expResult = 0.0F;
        float result = 2F;
        assertEquals(expResult, result, 0.0);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setWeight method, of class ConstructionMaterial.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        float weight = 0.0F;
        ConstructionMaterial instance = null;
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class ConstructionMaterial.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ConstructionMaterial instance = null;
        int expResult = 0;
        int result = 2;
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId method, of class ConstructionMaterial.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ConstructionMaterial instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ConstructionMaterial.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ConstructionMaterial instance = null;
        String expResult = "MARTILLO";
        String result = "CEMENTO";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setName method, of class ConstructionMaterial.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ConstructionMaterial instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrand method, of class ConstructionMaterial.
     */
    @Test
    public void testGetBrand() {
        System.out.println("getBrand");
        ConstructionMaterial instance = null;
        String expResult = "husky";
        String result = "husky";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setBrand method, of class ConstructionMaterial.
     */
    @Test
    public void testSetBrand() {
        System.out.println("setBrand");
        String brand = "";
        ConstructionMaterial instance = null;
        instance.setBrand(brand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class ConstructionMaterial.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ConstructionMaterial instance = null;
        int expResult = 0;
        int result = 0;
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuantity method, of class ConstructionMaterial.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        ConstructionMaterial instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class ConstructionMaterial.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ConstructionMaterial instance = null;
        float expResult = 0.0F;
        float result = 0.5F;
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPrice method, of class ConstructionMaterial.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        float price = 0.0F;
        ConstructionMaterial instance = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class ConstructionMaterial.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        ConstructionMaterial instance = null;
        String expResult = "ConstructionMaterial";
        String result = "ConstructionMaterial";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCategory method, of class ConstructionMaterial.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        ConstructionMaterial instance = null;
        instance.setCategory(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
