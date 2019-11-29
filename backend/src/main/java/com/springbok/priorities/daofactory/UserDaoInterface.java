package com.springbok.priorities.daofactory;

import com.springbok.priorities.models.UserModel;

public interface UserDaoInterface {
    public Integer create(UserModel model);
    public Integer getUserID(String user_name, String password);
    public UserModel getUser(String user_id);
    public Boolean updateUser(UserModel user);
}