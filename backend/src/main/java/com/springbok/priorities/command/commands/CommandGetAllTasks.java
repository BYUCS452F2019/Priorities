package com.springbok.priorities.command.commands;

import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.daofactory.DaoFactory;

public class CommandGetAllTasks implements CommandInterface {
    private Double user_id;

    public CommandGetAllTasks(Map<String, Object> commandData) {
      this.user_id = (Double)commandData.get("user_id");
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(DaoFactory.getTaskDao().getAllTasksForUserID(user_id), "no error");
    }

}