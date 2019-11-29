package com.springbok.priorities.mongodao;

import com.springbok.priorities.daofactory.UserDaoInterface;
import com.springbok.priorities.models.UserModel;

public class MongoUserDao implements UserDaoInterface {

    @Override
    public Integer create(UserModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getUserID(String user_name, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel getUser(String user_id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean updateUser(UserModel user) {
        // TODO Auto-generated method stub
        return null;
    }
    
}