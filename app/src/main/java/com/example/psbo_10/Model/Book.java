package com.example.psbo_10.Model;

public class Book {
    private String title, image, price, cat_id, synopsis;

    public Book(){
    }

    public Book(String title, String image, String price, String cat_id, String synopsis) {
        this.title = title;
        this.image = image;
        this.price = price;
        this.cat_id = cat_id;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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