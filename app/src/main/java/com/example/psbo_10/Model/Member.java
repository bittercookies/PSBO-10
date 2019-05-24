package com.example.psbo_10.Model;
import java.time.LocalDate;


public class Member extends User {
    private String user_email;
    private LocalDate user_dateofBirth;
    private String user_bio;
    private String user_address;

    //constructor
    public Member(String user_email, LocalDate user_dateofBirth, String user_bio, String user_address) {
        this.user_email = user_email;
        this.user_dateofBirth = user_dateofBirth;
        this.user_bio = user_bio;
        this.user_address = user_address;
    }

    //setters & getters
    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public LocalDate getUser_dateofBirth() {
        return user_dateofBirth;
    }

    public void setUser_dateofBirth(LocalDate user_dateofBirth) {
        this.user_dateofBirth = user_dateofBirth;
    }

    public String getUser_bio() {
        return user_bio;
    }

    public void setUser_bio(String user_bio) {
        this.user_bio = user_bio;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }




    public void register() {

    }

    public  void updateProfile(){

    }
}
