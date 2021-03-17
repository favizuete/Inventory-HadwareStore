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
    public void save();
    public void find();
    public void delete();
    public void update();
    
}
