
package oop_mangogarden;

import java.io.Serializable;

public class PaymentDiscount implements Serializable{
    private String invoiceNo;
    private int quantity;
    private int price;
    private int discount;
    private int totalprice;


    public PaymentDiscount(String invoiceNo, int quantity, int price, int discount, int totalprice) {
        this.invoiceNo = invoiceNo;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.totalprice = totalprice;
    }



    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "PaymentDiscount{" + "invoiceNo=" + invoiceNo + ", quantity=" + quantity + ", price=" + price + ", discount=" + discount + ", totalprice=" + totalprice + '}';
    } 
    
}
