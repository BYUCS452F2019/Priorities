package com.springbok.priorities.command.commands;

import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.models.*;
import com.springbok.priorities.dao.*;

public class CommandRegister implements CommandInterface {
    private String username;
    private String password;
    private String email;

    public CommandRegister(Map<String, String> commandData) {
        this.username = commandData.get("username");
        this.password = commandData.get("password");
        this.email = commandData.get("email");
    }

    @Override
    public CommandResult execute() {
        String result = UserDao.create(new UserModel(this.username, this.email, this.password));
        return new CommandResult(result, "no error ever");
    }
}