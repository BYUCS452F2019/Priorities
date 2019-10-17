package com.springbok.priorities.dao;

import com.springbok.priorities.models.*;

public class UserDao {
    public static String create(UserModel model) {
        return "authorization";
    }

    public static String read(UserModel model) {
        return "logged in";
    }
}