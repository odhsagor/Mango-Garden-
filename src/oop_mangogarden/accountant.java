
package oop_mangogarden;


public class accountant extends Employee{

    public accountant(String employeeType, String employeeName, String employeeID, String password) {
    }

    public accountant(String employeeType, String employeeName, String employeeID, String gender, String contactNumber, String password) {
        super(employeeType, employeeName, employeeID, gender, contactNumber, password);
    }
    
    
}
