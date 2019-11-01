package com.springbok.priorities.command.commands;

import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.PriorityDao;

public class CommandGetPriorities implements CommandInterface {
    private String user_id;

    public CommandGetPriorities(Map<String, Object> commandData) {
      this.user_id = (String)commandData.get(user_id);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(PriorityDao.getPrioritiesForUserID(user_id), "no error");
    }

}