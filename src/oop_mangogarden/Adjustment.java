
package oop_mangogarden;

import java.io.Serializable;

public class Adjustment implements Serializable{
    private String invoiceno;
    private String quantity;
    private float total;
    private int paid;
    private int due;
    //protected static int totalPrice = 16000;

    public Adjustment(String invoiceno, String quantity, float total, int paid, int due) {
        this.invoiceno = invoiceno;
        this.quantity = quantity;
        this.total = total;
        this.paid = paid;
        this.due = due;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public String getTotal() {
        return quantity;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "Adjustment{" + "invoiceno=" + invoiceno + ", quantity=" + quantity + ", total=" + total + ", paid=" + paid + ", due=" + due + '}';
    }

    
}
