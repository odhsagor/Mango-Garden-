
package oop_mangogarden;

import java.io.Serializable;
public class Transport extends Vehicle implements Serializable{
    private String driverName;
    private String productID;
    private String dispatchDate;
    private String destination;
    
    public Transport(String chassisNo, String plateNo){
        super(chassisNo, plateNo);
    }


    public Transport(String DriverName, String productID, String dispatchDate, String destination, String chassisNo, String plateNo) {
        super(chassisNo, plateNo);
        this.driverName = DriverName;
        this.productID = productID;
        this.dispatchDate = dispatchDate;
        this.destination = destination;
        
//        System.out.println(DriverName);
//        System.out.println(productID);
//        System.out.println(dispatchDate);
//        System.out.println(destination);
//        System.out.println(chassisNo);
//        System.out.println(plateNo);
        
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String DriverName) {
        this.driverName = DriverName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Transport{" + "DriverName=" + driverName + ", productID=" + productID + ", dispatchDate=" + dispatchDate + ", destination=" + destination + '}';
    }
    
    
    
    
}
