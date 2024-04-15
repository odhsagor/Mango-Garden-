
package oop_mangogarden;

import java.io.Serializable;

public class Vehicle implements Serializable{
    private String chassisNo;
    private String plateNo;

    public Vehicle(String chassisNo, String plateNo) {
        this.chassisNo = chassisNo;
        this.plateNo = plateNo;
        
//        System.out.println("Vehicle"+chassisNo);
//        System.out.println("Vehicle"+plateNo);
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
        //System.out.println("A"+chassisNo);
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "chassisNo=" + chassisNo + ", plateNo=" + plateNo + '}';
    }
    
    
    
}
