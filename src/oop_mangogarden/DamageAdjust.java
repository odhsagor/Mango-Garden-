
package oop_mangogarden;

import java.io.Serializable;

public class DamageAdjust implements Serializable{
    private String Drivername;
    private String plateno;
    private String date;
    private String destination;
    private String productID;
    private String quantity;
    private String damagequantity;
    private String adjustment;
    

    public DamageAdjust(String Drivername, String plateno, String date, String destination, 
            String productID, String quantity, String damagequantity, String adjustment) {
        this.Drivername = Drivername;
        this.plateno = plateno;
        this.date = date;
        this.destination = destination;
        this.productID = productID;
        this.quantity = quantity;
        this.damagequantity = damagequantity;
        this.adjustment = adjustment;
    }

    public String getDrivername() {
        return Drivername;
    }

    public void setDrivername(String Drivername) {
        this.Drivername = Drivername;
    }

    public String getPlateno() {
        return plateno;
    }

    public void setPlateno(String plateno) {
        this.plateno = plateno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public String getDamagequantity() {
        return damagequantity;
    }

    public void setDamagequantity(String damagequantity) {
        this.damagequantity = damagequantity;
    }

    public String getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(String adjustment) {
        this.adjustment = adjustment;
    }

    @Override
    public String toString() {
        return "DamageAdjust{" + "Drivername=" + Drivername + ", plateno=" + plateno + ", date=" + date + ","
                + " destination=" + destination + ", productID=" + productID + ", quantity=" + quantity +
                ", damagequantity=" + damagequantity + ", adjustment=" + adjustment + '}';
    }
    
    
}
