package com.example.psbo_10.Model;

public class User {
    private String name;
    private String password;
    private String phone;
    private String salt;
    private static User currentUser;

    public User(){

    }

    public User(String name, String password, String salt) {
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt(){ return salt; }

    public void setSalt(String salt){
        this.salt = salt;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}
