package com.springbok.priorities.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.springbok.priorities.models.UserModel;

public class UserDao {
    public static String create(UserModel model) {
        String toReturn = "";
        try {
            Connection conn = DaoManager.getConnection();
            String sql = "INSERT INTO user (username, email, password ) VALUES (" 
                + model.username + ", " 
                + model.email + ", " 
                + model.password + ")";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                toReturn = resultSet.getString(0);
            }

            DaoManager.closeConnection(conn);

            return toReturn;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return toReturn;
        }
    }

    public static String getUserIDByUserNameAndPassword(String user_name, String password) {
        String user_id = null;
        try {
            Connection conn = DaoManager.getConnection();
            String sql = "SELECT user_id FROM user WHERE user_name = " + user_name + " and password = " + password;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                user_id = result.getString(0);
            }
            DaoManager.closeConnection(conn);

            return user_id;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }

    public static UserModel read(String user_id) {
        UserModel userModel = null;
        try {
            Connection conn = DaoManager.getConnection();
            String sql = "SELECT * FROM user WHERE user_id = " + user_id;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                userModel = new UserModel(result.getString(0), result.getString(1), result.getString(2), result.getString(3));
            }
            DaoManager.closeConnection(conn);

            return userModel;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }
}