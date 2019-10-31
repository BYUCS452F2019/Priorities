package com.springbok.priorities.command.commands;

import java.util.Map;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.models.*;
import com.springbok.priorities.dao.*;

public class CommandRegister implements CommandInterface {
    private String username;
    private String password;
    private String email;

    public CommandRegister(Map<String, Object> commandData) {
        Gson gson = new Gson();
        UserModel user = gson.fromJson(gson.toJson(commandData), UserModel.class);
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

    @Override
    public CommandResult execute() {
        String result = UserDao.create(new UserModel(this.username, this.email, this.password));
        return new CommandResult(result, "no error ever");
    }
}