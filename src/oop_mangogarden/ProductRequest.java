
package oop_mangogarden;

import java.io.Serializable;

public class ProductRequest implements Serializable{
    private String EmployeeID;
    private String Contact;
    private String productID;
    private String quantity;
    private String date;

    public ProductRequest(String EmployeeID, String Contact, String productID, String quantity, String date) {
        this.EmployeeID = EmployeeID;
        this.Contact = Contact;
        this.productID = productID;
        this.quantity = quantity;
        this.date = date;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ProductRequest{" + "EmployeeID=" + EmployeeID + ", Contact=" + Contact + ", productID=" + productID + ", quantity=" + quantity + ", date=" + date + '}';
    }
    
    
    
}
