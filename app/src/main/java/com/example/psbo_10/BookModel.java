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

    public Integer getBook_id() {
        return book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public Double getBook_price() {
        return book_price;
    }

    public Integer getBook_quantity() {
        return book_quantity;
    }

    public String getBook_details() {
        return book_details;
    }

    public String getBook_category() {
        return book_category;
    }

    public String getBook_synopsis() {
        return book_synopsis;
    }

    public void createBook(){

    }

    public void displayBook(){

    }

    public void updateBook(){

    }

    public void deleteBook(){

    }

    public void searchBook(){

    }

}