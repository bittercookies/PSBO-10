package com.example.psbo_10;

public class Member extends User {
    private String user_email;
    private Date user_dateofBirth;
    private String user_bio;
    private String user_address;

    //constructor
    public Member() {
        this.user_email = "";
        this.user_dateofBirth = 0;
        this.user_bio = "";
        this.user_address = "";

    }

    public setMember(String email, Date birth, String bio, String address) {
        this.user_email = email;
        this.user_dateofBirth = birth;
        this.user_bio = bio;
        this.user_address = address;
    }

    public register() {

    }

    public  updateProfile(){

    }
}
