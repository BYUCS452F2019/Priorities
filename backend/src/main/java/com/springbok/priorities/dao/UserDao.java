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
            Boolean result = stmt.execute(sql);
            
            if (result) {
                sql = "SELECT user_id FROM user WHERE username = " + model.username;
                ResultSet resultSet = stmt.executeQuery(sql);
                while (resultSet.next()) {
                    toReturn = resultSet.getString(0);
                }
            }

            DaoManager.closeConnection(conn);

            return toReturn;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return toReturn;
        }
    }

    public static UserModel read(String user_id, String password) {
        UserModel user = null;
        try {
            Connection conn = DaoManager.getConnection();
            String sql = "SELECT * FROM user WHERE user_id = " + user_id + " and password = " + password;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                user = new UserModel(result.getString(0), result.getString(1), result.getString(2), result.getString(3));
            }
            DaoManager.closeConnection(conn);

            return user;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }
}