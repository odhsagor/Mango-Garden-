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
public class UpdateTrackOrder implements Serializable{
     private int Order_Number;
    private String Massage;

    public UpdateTrackOrder(int Order_Number, String Massage) {
        this.Order_Number = Order_Number;
        this.Massage = Massage;
    }
    
    public void UpdateTrackOrderInfo
        (){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("UpdateTrackOrder.bin");
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
            Logger.getLogger(UpdateTrackOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(UpdateTrackOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        public static ArrayList<UpdateTrackOrder> listTrackOrder(){
        ArrayList<UpdateTrackOrder>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("UpdateTrackOrder.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            UpdateTrackOrder u;
            try{
                while(true){
                    u = (UpdateTrackOrder)ois.readObject();
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

    public int getOrder_Number() {
        
        return Order_Number;
    }

    public String getMassage() {
        return Massage;

    
}
}

