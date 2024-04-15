
package oop_mangogarden;

import java.io.Serializable;

public class SaleInfo implements Serializable{

    private String invoiceNo;
    private String productName;
    String quantity;
    String saleDate;
    String totalPrice;

    public SaleInfo(String invoiceNo, String productName, String quantity, String saleDate, String totalPrice) {
        this.invoiceNo = invoiceNo;
        this.productName = productName;
        this.quantity = quantity;
        this.saleDate = saleDate;
        this.totalPrice = totalPrice;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
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

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "SaleInfo{" + "invoiceNo=" + invoiceNo + ", productName=" + productName + ", quantity=" + quantity + ", saleDate=" + saleDate + ", totalPrice=" + totalPrice + '}';
    }


    
    
}
