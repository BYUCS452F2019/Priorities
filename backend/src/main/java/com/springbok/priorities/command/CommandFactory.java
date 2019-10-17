package com.springbok.priorities.command;

import java.util.Map;

import com.springbok.priorities.command.commands.*;

public class CommandFactory {
    
    public static CommandInterface getCommand(String type, Map<String, String> commandData) {
        if (type.equals("login")) {
            return new CommandLogin(commandData);
        } else if (type.equals("register")) {
            return new CommandRegister(commandData);
        } else {
            return null;
        }
    }
}