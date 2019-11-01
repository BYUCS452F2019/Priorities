package com.springbok.priorities.command.commands;

import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.TaskDao;

public class CommandGetTasks implements CommandInterface {
    private Integer user_id;

    public CommandGetTasks(Map<String, Object> commandData) {
      this.user_id = ((Double)commandData.get("user_id")).intValue();
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(TaskDao.getTasksForUserID(user_id), "no error");
    }

}