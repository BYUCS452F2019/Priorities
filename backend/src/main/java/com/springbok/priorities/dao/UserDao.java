package com.springbok.priorities.dao;

import java.sql.SQLException;

import com.springbok.priorities.models.UserModel;

public class UserDao {
    public static Integer create(UserModel model) {
        String sql = "INSERT INTO user (username, email, password ) VALUES ('" 
                        + model.username + "', '"
                        + model.email + "', '" 
                        + model.password + "')";

        try {
            return DaoManager.createObject(sql);
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }

    public static Integer getUserID(String email, String password) {
        Integer user_id = null;
        String sql = "SELECT user_id FROM user WHERE email = '" 
                        + email + "' and password = '" 
                        + password + "'";

        try {
            user_id = DaoManager.getObjectID(sql);
            return user_id;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }

    public static UserModel getUser(String user_id) {
        String sql = "SELECT * FROM user WHERE user_id = " + user_id;

        try {
            return DaoManager.getObject(UserModel.class, sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean updateUser(UserModel user) {
        String sql = "UPDATE user SET" 
            + "username = " + user.username
            + "email = " + user.email
            + "password = " + user.password
            + "user_id = " + user.user_id
            + "WHERE user_id = " + user.user_id;

        try {
            return DaoManager.updateObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}