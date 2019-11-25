package com.springbok.priorities.command.commands;

import java.util.Map;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.command.daofactory.DaoFactory;
import com.springbok.priorities.models.UserModel;

public class CommandLogin implements CommandInterface {
    private String username;
    private String password;

    public CommandLogin(Map<String, Object> commandData) {
        Gson gson = new Gson();
        UserModel user = gson.fromJson(gson.toJson(commandData), UserModel.class);
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(DaoFactory.getUserDao().getUserID(this.username, this.password), "no error");
    }

}