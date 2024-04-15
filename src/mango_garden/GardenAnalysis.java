/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mango_garden;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class GardenAnalysis implements Serializable{
    private int new_planted_trees,old_number_of_trees,total_quantity_of_mango,total_waste;

    public GardenAnalysis(int new_planted_trees, int old_number_of_trees, int total_quantity_of_mango, int total_waste) {
        this.new_planted_trees = new_planted_trees;
        this.old_number_of_trees = old_number_of_trees;
        this.total_quantity_of_mango = total_quantity_of_mango;
        this.total_waste = total_waste;
    }
    
    public void AddGardenAnalysis
        (){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("GardenAnalysis.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(GardenAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(GardenAnalysis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static ArrayList<GardenAnalysis> ListOfGardenAnalysis(){
        ArrayList<GardenAnalysis>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("GardenAnalysis.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            GardenAnalysis u;
            try{
                while(true){
                    u = (GardenAnalysis)ois.readObject();
                    uList.add(u);
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch                 
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }    
        return uList;
    }

    public int getNew_planted_trees() {
        return new_planted_trees;
    }

    public int getOld_number_of_trees() {
        return old_number_of_trees;
    }

    public int getTotal_quantity_of_mango() {
        return total_quantity_of_mango;
    }

    public int getTotal_waste() {
        return total_waste;
    }
    
    
}


