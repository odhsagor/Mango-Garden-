/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SupplyChainManager_Sagor;

import java.io.Serializable;

/**
 *
 * @author md.obidulhuqsagor
 */
    public class orderManagementBin implements Serializable{
    private String CoustomerName;
    private String quantity;
    private String product;
    private String Amount;
    private String date;

    public orderManagementBin(String CoustomerName, String quantity, String product, String Amount, String date) {
        this.CoustomerName = CoustomerName;
        this.quantity = quantity;
        this.product = product;
        this.Amount = Amount;
        this.date = date;
    }

    public String getCoustomerName() {
        return CoustomerName;
    }

    public void setCoustomerName(String CoustomerName) {
        this.CoustomerName = CoustomerName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "orderManagementBin{" + "CoustomerName=" + CoustomerName + ", quantity=" + quantity + ", product=" + product + ", Amount=" + Amount + ", date=" + date + '}';
    }
    

    

}
