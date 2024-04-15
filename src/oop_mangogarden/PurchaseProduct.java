
package oop_mangogarden;

import java.io.Serializable;


public class PurchaseProduct implements Serializable{
    private String purchaseID;
    private String productName;
    private String quantity;
    private String issueDate;
    private String price;

    public PurchaseProduct(String purchaseID, String productName, String quantity, String issueDate, String price) {
        this.purchaseID = purchaseID;
        this.productName = productName;
        this.quantity = quantity;
        this.issueDate = issueDate;
        this.price = price;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PurchaseProduct{" + "purchaseID=" + purchaseID + ", productName=" + productName +
                ", quantity=" + quantity + ", issueDate=" + issueDate + ", price=" + price + '}';
    }
    
    
    
    
}
