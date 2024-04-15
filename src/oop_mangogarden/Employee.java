
package oop_mangogarden;

import java.io.Serializable;

public class Employee implements Serializable{
    private String employeeType;
    private String employeeName;
    private String employeeID;
    private String gender;
    private String contactNumber;
    private String password;

    public Employee() {
    }

    public Employee(String employeeType, String employeeName, String employeeID, String gender, String contactNumber, String password) {
        this.employeeType = employeeType;
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.password = password;
        
        
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
  
    public boolean isemployeeType(String s) {
        if (s.equalsIgnoreCase(this.employeeType))
            return true;
        else
            return false;
    }

    public boolean isemployeeName(String s) {
        if (s.equalsIgnoreCase(this.employeeName))
            return true;
        else
            return false;
    }    

    public boolean isemployeeID(String s) {
        if (s.equalsIgnoreCase(this.employeeID))
            return true;
        else
            return false;
    }
    
    public boolean isPassword(String s) {
        if (s.equalsIgnoreCase(this.password))
            return true;
        else
            return false;
    }
         
    
    
}
