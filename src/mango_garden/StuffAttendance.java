/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mango_garden;

import java.util.ArrayList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author MSI
 */
public class StuffAttendance {
     private String StufName;
    private String MobileNumber;
    private String Attendace;

    public StuffAttendance(String StufName, String MobileNumber, String Attendace) {
        this.StufName = StufName;
        this.MobileNumber = MobileNumber;
        this.Attendace = Attendace;
    }

    public String getStufName() {
        return StufName;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getAttendace() {
        return Attendace;
    }
    
    
   
}
