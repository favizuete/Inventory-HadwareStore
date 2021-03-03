/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class MongoManagerTest {
    
    public MongoManagerTest() {
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
     * Test of save method, of class MongoManager.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        int id = 1;
        String name = "Martillo";
        String brand = "APM";
        int quantity = 100;
        float price = (float) 0.2;
        String category = "Herramienta";
        MongoManager.save(id, name, brand, quantity, price, category);

    }

    /**
     * Test of find method, of class MongoManager.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String nameToFind = "";
        MongoManager.find(nameToFind);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MongoManager.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String name = "Martillo electrico";
        MongoManager.delete(name);

    }

    /**
     * Test of update method, of class MongoManager.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String nameToChange = "Cortadora";
        String nameToUpdate = "Martillo electrico";
        MongoManager.update(nameToChange, nameToUpdate);

    }
    
}
