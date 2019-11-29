package com.springbok.priorities.command.commands;

import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.daofactory.DaoFactory;

public class CommandGetPriorities implements CommandInterface {
    private String user_id;

    public CommandGetPriorities(Map<String, Object> commandData) {
      this.user_id = (String)commandData.get("user_id");
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(DaoFactory.getPriorityDao().getPrioritiesForUserID(user_id), "no error");
    }

}