
package oop_mangogarden;

import java.io.Serializable;

public class Bill implements Serializable{
    private String customerName;
    private String address;
    private String issueDate;
    private String productname;
    private int quantity;
    private int invoiceNo;
    private Float totalPrice;    

    public Bill() {
    }

    public Bill(String customerName, String address, String issueDate, String productname, int quantity, int invoiceNo, Float totalPrice) {
        this.customerName = customerName;
        this.address = address;
        this.issueDate = issueDate;
        this.productname = productname;
        this.quantity = quantity;
        this.invoiceNo = invoiceNo;
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" + "customerName=" + customerName + ", address=" + address + ", issueDate=" + issueDate + ", productname=" + productname + ", quantity=" + quantity + ", invoiceNo=" + invoiceNo + ", totalPrice=" + totalPrice + '}';
    }

    
    
}
