
package oop_mangogarden;

import java.io.Serializable;


public class ProductInfo implements Serializable{
    private String name;
    private String id;
    private String oreder;
    private String destination;
    private String totalprice;

    public ProductInfo(String name, String id, String oreder, String destination, String totalprice) {
        this.name = name;
        this.id = id;
        this.oreder = oreder;
        this.destination = destination;
        this.totalprice = totalprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOreder() {
        return oreder;
    }

    public void setOreder(String oreder) {
        this.oreder = oreder;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "ProductInfo{" + "name=" + name + ", id=" + id + ", oreder=" + oreder + ", destination=" + destination + ", totalprice=" + totalprice + '}';
    }


    
}
