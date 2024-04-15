
package SupplyChainManager_Sagor;

import oop_mangogarden.Employee;

public class SupplyChainManager extends Employee{

    public SupplyChainManager(String employeeType, String employeeName, String employeeID, String password) {
    }

    public SupplyChainManager(String employeeType, String employeeName, String employeeID, String gender, String contactNumber, String password) {
        super(employeeType, employeeName, employeeID, gender, contactNumber, password);
    }
    
    
}
