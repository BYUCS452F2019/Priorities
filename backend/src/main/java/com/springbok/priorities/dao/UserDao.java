package com.springbok.priorities.dao;

import java.sql.SQLException;

import com.springbok.priorities.models.UserModel;

public class UserDao {
    public static String create(UserModel model) {
        String toReturn = "";
        try {
            String sql = "INSERT INTO user (username, email, password ) VALUES ('" + model.username + "', '"
                    + model.email + "', '" + model.password + "')";
            toReturn = DaoManager.createObject(sql);

            return toReturn;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return toReturn;
        }
    }

    public static String getUserID(String user_name, String password) {
        String user_id = null;
        try {
            String sql = "SELECT user_id FROM user WHERE user_name = " + user_name + " and password = " + password;
            user_id = DaoManager.getObjectID(sql);
            return user_id;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }

    public static UserModel getUser(String user_id) {
        try {
            String sql = "SELECT * FROM user WHERE user_id = " + user_id;
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