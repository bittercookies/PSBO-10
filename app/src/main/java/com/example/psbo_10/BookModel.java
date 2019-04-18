package com.example.psbo_10;

public class BookModel {
    private Integer book_id;
    private String book_title;
    private Double book_price;
    private Integer book_quantity;
    private String book_details;
    private String book_category;
    private String book_synopsis;



    public void setBook(Integer id, String title, Double price, Integer quantity, String details, String category, String synopsis) {
        this.book_id = id;
        this.book_title = title;
        this.book_price = price;
        this.book_quantity = quantity;
        this.book_details = details;
        this.book_category = category;
        this.book_synopsis = synopsis;
    }

}