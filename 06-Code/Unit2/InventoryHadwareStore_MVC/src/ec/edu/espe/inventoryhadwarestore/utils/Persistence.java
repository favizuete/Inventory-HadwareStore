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
interface Persistence {
    public void save(String fileName, String data);
    public void find(String fileName, String dataToFind);
    public boolean delete(String fileNAme, String dataToDelete);
    public boolean update(String fileName, String dataToFind, String dataToUpdate);
    
}
