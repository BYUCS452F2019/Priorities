package com.springbok.priorities.command.commands;

import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.command.daofactory.DaoFactory;

public class CommandGetTasks implements CommandInterface {
    private String user_id;

    public CommandGetTasks(Map<String, Object> commandData) {
      this.user_id = (String)commandData.get("user_id");
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(DaoFactory.getTaskDao().getTasksForUserID(user_id), "no error");
    }

}