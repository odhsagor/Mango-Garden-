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
class TransferBinFile implements Serializable{
    private String Name;
    private String From;
    private String TO;
    private String OrderID;
    private String Amount;
    private String MoveDate;

    public TransferBinFile(String Name, String From, String TO, String OrderID, String Amount, String MoveDate) {
        this.Name = Name;
        this.From = From;
        this.TO = TO;
        this.OrderID = OrderID;
        this.Amount = Amount;
        this.MoveDate = MoveDate;
    }

    TransferBinFile(String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public String getTO() {
        return TO;
    }

    public void setTO(String TO) {
        this.TO = TO;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getMoveDate() {
        return MoveDate;
    }

    public void setMoveDate(String MoveDate) {
        this.MoveDate = MoveDate;
    }

    @Override
    public String toString() {
        return "TransferBinFile{" + "Name=" + Name + ", From=" + From + ", TO=" + TO + ", OrderID=" + OrderID + ", Amount=" + Amount + ", MoveDate=" + MoveDate + '}';
    }
    
}
