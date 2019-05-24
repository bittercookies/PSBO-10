package com.example.psbo_10.Model;

public class Cart {
    private Integer cart_id;
    private Integer quantity;


    public Cart(Integer cart_id, Integer quantity) {
        this.cart_id = cart_id;
        this.quantity = quantity;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void addToCart() {

    }

    public void checkOut(){

    }

    public void clearCart(){

    }
}
