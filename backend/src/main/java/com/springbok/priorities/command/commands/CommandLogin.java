package com.springbok.priorities.command.commands;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.UserDao;
import com.springbok.priorities.models.UserModel;

public class CommandLogin implements CommandInterface {
    private String username;
    private String password;

    public CommandLogin(String commandData) {
        Gson gson = new Gson();
        UserModel user = gson.fromJson(commandData, UserModel.class);
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(UserDao.getUserID(this.username, this.password), "no error");
    }

}