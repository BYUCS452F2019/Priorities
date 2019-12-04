package com.springbok.priorities.sqldao;

import java.sql.SQLException;

import com.springbok.priorities.daofactory.UserDaoInterface;
import com.springbok.priorities.models.UserModel;

public class SQLUserDao implements UserDaoInterface {

    @Override
    public Integer create(UserModel model) {
        try {
            String sql = "INSERT INTO user (username, email, password ) VALUES ('" + model.username + "', '"
                    + model.email + "', '" + model.password + "')";
            return SQLDaoManager.createObject(sql);
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer getUserID(String username, String password) {
        Integer user_id = null;
        try {
            String sql = "SELECT user_id FROM user WHERE username = '" + username + "' and password = '" + password + "'";
            user_id = SQLDaoManager.getObjectID(sql);
            return user_id;
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }

    @Override
    public UserModel getUser(String user_id) {
        try {
            String sql = "SELECT * FROM user WHERE user_id = " + user_id;
            return SQLDaoManager.getObject(UserModel.class, sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean updateUser(UserModel user) {
        String sql = "UPDATE user SET" 
            + "username = " + user.username
            + "email = " + user.email
            + "password = " + user.password
            + "user_id = " + user.user_id
            + "WHERE user_id = " + user.user_id;
        try {
            return SQLDaoManager.updateObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}