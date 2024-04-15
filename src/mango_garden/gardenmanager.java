
package mango_garden;

import oop_mangogarden.Employee;

public class gardenmanager extends Employee{

    public gardenmanager(String employeeType, String employeeName, String employeeID, String password) {
    }

    public gardenmanager(String employeeType, String employeeName, String employeeID, String gender, String contactNumber, String password) {
        super(employeeType, employeeName, employeeID, gender, contactNumber, password);
    }
    
    
}
