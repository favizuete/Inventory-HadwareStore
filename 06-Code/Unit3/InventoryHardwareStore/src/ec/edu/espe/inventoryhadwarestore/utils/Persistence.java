/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.utils;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public interface Persistence {
    public boolean save(String table, String data);
    public String find(String table, String data,String finder);
    public boolean delete(String table, String data);
    public boolean update(String table, String dataToUpdate, String finder);
    
}
