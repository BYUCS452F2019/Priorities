package com.springbok.priorities.command.commands;

import java.util.Map;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.TaskDao;
import com.springbok.priorities.models.TaskModel;

public class CommandEditTask implements CommandInterface {
    private TaskModel task;

    public CommandEditTask(Map<String, Object> commandData) {
      Gson gson = new Gson();
      task = gson.fromJson(gson.toJson(commandData), TaskModel.class);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(TaskDao.updateTask(task), "no error");
    }

}