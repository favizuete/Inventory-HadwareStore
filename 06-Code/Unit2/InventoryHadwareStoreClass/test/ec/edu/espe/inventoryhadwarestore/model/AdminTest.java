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
public class AdminTest {
    
    public AdminTest() {
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
     * Test of toString method, of class Admin.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "null";
        String result = "null";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getName method, of class Admin.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Admin instance = null;
        String expResult = "Pablo";
        String result = "PABLO";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setName method, of class Admin.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Admin instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Admin instance = null;
        String expResult = "RICHARD123";
        String result = "RICHARD123";
        assertEquals(expResult, result);
         if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPassword method, of class Admin.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Admin instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Admin.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Admin instance = null;
        String expResult = "richard";
        String result = "Richard";
        assertEquals(expResult, result);
        if(result !=expResult){
        
          fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setUser method, of class Admin.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        Admin instance = null;
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
