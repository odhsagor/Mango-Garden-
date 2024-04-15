
package horticulturist_Sagor;

import oop_mangogarden.Employee;


public class horticulturist extends Employee{

    public horticulturist(String employeeType, String employeeName, String employeeID, String password) {
    }

    public horticulturist(String employeeType, String employeeName, String employeeID, String gender, String contactNumber, String password) {
        super(employeeType, employeeName, employeeID, gender, contactNumber, password);
    }
    
}
