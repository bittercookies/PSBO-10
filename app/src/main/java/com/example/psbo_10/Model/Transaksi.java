package com.example.psbo_10.Model;

public class Transaksi {
    private Integer transaksi_id;
    private Integer order_date;
    private String order_status;
    private Integer duration;
    private Integer quantity;
    private Integer price;

    public Transaksi(){
        transaksi_id = 0;
        order_date = 0;
        order_status = "status";
        duration = 1;
        quantity = 1;
        price = 1;
    }

    public void setTransaksi(Integer id, Integer date, String status, Integer duration, Integer quantity, Integer price) {
        this.transaksi_id = id;
        this.order_date = date;
        this.order_status = status;
        this.duration = duration;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getTransaksi_id() {
        return transaksi_id;
    }

    public Integer getOrder_date() {
        return order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void displayOrder() {

    }

    public void updateOrderStatus() {

    }


}
