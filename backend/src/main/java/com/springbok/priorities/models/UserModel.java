package com.springbok.priorities.models;

public class UserModel {
    public String username;
    public String email;
    public String password;

    public UserModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}