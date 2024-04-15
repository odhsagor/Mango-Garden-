
package oop_mangogarden;

import java.io.Serializable;


public class Driver implements Serializable{
    private String driverName;
    private String ContactNumber;

    public Driver(String driverName, String ContactNumber) {
        this.driverName = driverName;
        this.ContactNumber = ContactNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    @Override
    public String toString() {
        return "Driver{" + "driverName=" + driverName + ", ContactNumber=" + ContactNumber + '}';
    }
    
    
    
    
}
