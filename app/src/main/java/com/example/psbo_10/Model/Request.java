package com.example.psbo_10.Model;

import java.util.List;

public class Request {
    private String phone;
    private String name;
    private String address;
    private String total;
    private List<Order> book;

    public Request() {
    }

    public Request(String phone, String name, String address, String total, List<Order> book) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.book = book;
    }
}
