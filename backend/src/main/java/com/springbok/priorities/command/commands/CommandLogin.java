package com.springbok.priorities.command.commands;

import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.UserDao;

public class CommandLogin implements CommandInterface {
    private String username;
    private String password;

    public CommandLogin(Map<String, String> commandData) {
        this.username = commandData.get("username");
        this.password = commandData.get("password");
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(UserDao.getUserIDByUserNameAndPassword(this.username, this.password), "no error");
    }

}