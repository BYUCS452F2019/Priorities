package com.springbok.priorities.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.springbok.priorities.models.UserModel;

public class UserDao {
    public static String create(UserModel model) {
        try {
            Connection conn = DaoManager.getConnection();
            Statement stmt = conn.createStatement();
            DaoManager.closeConnection(conn);
            return "authorization";
        } catch (Exception sQLException) {
            return "bad connection";
        }
    }

    public static String read(UserModel model) {
        return "logged in";
    }

    public static List<String> getFieldTypesFromModel(UserModel model) {
        List<String> types = new ArrayList<String>();
        types.add("email");
        types.add("username");
        types.add("password");
        return types;
    }

    public static List<String> getFieldValuesFromModel(UserModel model) {
        List<String> types = new ArrayList<String>();
        if (!model.email.isEmpty()) {
            types.add(model.email);
        } else {
            types.add("null");
        }
        if (!model.username.isEmpty()) {
            types.add(model.username);
        } else {
            types.add("null");
        }
        if (!model.password.isEmpty()) {
            types.add(model.password);
        } else {
            types.add("null");
        }
        return types;
    }

    
}