package com.example.crapp;

public class User {
    public String FullName;
    public String Email;
    public Boolean isCr;

    public User(){

    }

    public User(String fullName, String email, Boolean isCr) {
        this.FullName = fullName;
        this.Email = email;
        this.isCr = isCr;
    }
}
