
package oop_mangogarden;

import java.io.Serializable;


public class Supplier implements Serializable{
    private String supplierName;
    private String contact;
    private String address;

    public Supplier(String supplierName, String contact, String address) {
        this.supplierName = supplierName;
        this.contact = contact;
        this.address = address;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierName=" + supplierName + ", contact=" + contact + ", address=" + address + '}';
    }
    
    
}
