
package oop_mangogarden;

import java.io.Serializable;

public class Salary implements Serializable{
    private String employeeType;
    private String name;
    private String ID;
    private String salary;

    public Salary(String employeeType, String name, String ID, String salary) {
        this.employeeType = employeeType;
        this.name = name;
        this.ID = ID;
        this.salary = salary;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" + "employeeType=" + employeeType + ", name=" + name + ", ID=" + ID + ", salary=" + salary + '}';
    }

 
    
}
