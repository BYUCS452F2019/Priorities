package com.springbok.priorities.command;

import java.util.Map;

import com.springbok.priorities.command.commands.*;

public class CommandFactory {
    
    public static CommandInterface getCommand(String type, String commandData) {
        if (type.equals("login")) {
            return new CommandLogin(commandData);
        } else if (type.equals("register")) {
            return new CommandRegister(commandData);
        } else if (type.equals("addPriority")) {
            return new CommandAddPriority(commandData);
        } else if (type.equals("addTask")) {
            return new CommandAddTask(commandData);
        } else if (type.equals("editPriority")) {
            return new CommandEditPriority(commandData);
        } else if (type.equals("editTask")) {
            return new CommandEditTask(commandData);
        } else {
            return null;
        }
    }
}