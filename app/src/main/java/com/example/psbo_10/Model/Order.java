package com.example.psbo_10.Model;

public class Order {
    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Price;
    private String Duration;

    public Order() {
    }

    public Order(String productId, String productName, String price, String duration) {
        ProductId = productId;
        ProductName = productName;
        Price = price;
        Duration = duration;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public void displayOrder() {

    }

    public void updateOrderStatus() {

    }


}
