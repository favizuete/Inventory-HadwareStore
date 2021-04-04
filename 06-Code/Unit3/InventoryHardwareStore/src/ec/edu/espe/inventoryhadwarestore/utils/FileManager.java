/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.inventoryhadwarestore.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher Yépez ESPE-DCCO
 */
public class FileManager implements Persistence{

  @Override
  public boolean save(String fileName, String data){
       //TODO saving data in the file FileName
       FileWriter file;
       BufferedWriter write;
        try
        {
            File f = new File(fileName);

            file = new FileWriter(fileName,true);
            if(f.exists())
            {
                write =new BufferedWriter(file);
                write.write(data);
                write.write(""+"\n");
                write.close();
    
            }
            else
            {
                file = new FileWriter(fileName,true);
            }   
        }catch(IOException ex)
        {
           Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE,null,ex);     
        }
        return true;
    }  
    public String find(String fileName, String dataToFind,String finder){
        //TODO finding dataToFind in file fileName
        FileReader readFile;
        BufferedReader read;
        boolean verify = false;
        try {
            readFile=new FileReader(fileName);
            read=new BufferedReader(readFile);
            String line;
            while((line = read.readLine()) != null){
                String[]data = line.split(",");
                for(int i=0;i<data.length;i++){
                    if(data[i].equals(dataToFind)){
                        System.out.println(line);
                        verify = true;
                    }
                    
                }
            }
            if(verify == false){
                    System.out.println("Dato no encontrado");
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataToFind;
    }
    
    public void findAll(String fileName){
        //TODO finding dataToFind in file fileName
        
        ArrayList<String> dataField;
        dataField = new ArrayList();
        
        FileReader file;
        BufferedReader read;
        try
        {
            File f = new File(fileName);

            file = new FileReader(fileName);
            
            if(f.exists())
            {
                read =new BufferedReader(file);
                
                String linea;
                while((linea=read.readLine())!=null)
                {
                    dataField.add(linea);
                }
                for(int i=0;i<dataField.size();i++)
                {
                    System.out.println(dataField.get(i));
                }
                read.close();
                  
            } 
        }catch(IOException ex)
        {
           Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE,null,ex);     
        }
    }
    
    public boolean update(String fileName,String dataToUpdate, String dataToFind){
        //TODO update Information
        
        boolean update;
        
        update = true;
        
        System.out.println("updating "+dataToFind+" in"+fileName);
        return update;
    }
    
    public  boolean delete(String fileNAme, String dataToDelete){
        //TODO delete information
        
        boolean deleted;
        
        deleted = true;
        
        return deleted;
    }

    
}
