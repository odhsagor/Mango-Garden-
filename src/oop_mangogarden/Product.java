
package oop_mangogarden;


public class Product {
    private String productName;
    private String productID;
    private Float price;

    public Product() {
    }

    public Product(String productName, String productID, Float price) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", productID=" + productID + ", price=" + price + '}';
    }
 
    
}
