package com.example.psbo_10;

public class User {
    private Integer user_id;
    private String user_name;
    private String user_pass;

    public User(String name, String pass ) {
        this.user_name = name;
        this.user_pass = pass;
    }

    public User(Integer id, String name, String pass) {
        this.user_id = id;
        this.user_name = name;
        this.user_pass = pass;

    }


}
