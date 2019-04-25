package com.example.psbo_10;

public class User {
    private Integer user_id;
    private String user_name;
    private String user_pass;
    private String user_address;

    //constructor
    public User() {
        this.user_id = 0;
        this.user_name = "";
        this.user_pass = "";
        this.user_address = "";

    }

    public setUser(Integer id, String name, String pass, String address) {
        this.user_id = id;
        this.user_name = name;
        this.user_pass = pass;
        this.user_address = address;
>>>>>>> 19546f7322eae4c2925c538c22ef5c97b90b3a25

    }
}
