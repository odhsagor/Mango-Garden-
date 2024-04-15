
package oop_mangogarden;

import java.io.Serializable;

public class MoneyReceipt extends Driver implements Serializable{
    private String date;
    private int totalprice;

    public MoneyReceipt(String date, int totalprice, String driverName, String ContactNumber) {
        super(driverName, ContactNumber);
        this.date = date;
        this.totalprice = totalprice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "MoneyReceipt{" + "date=" + date + ", totalprice=" + totalprice + '}';
    }
    
    
}
