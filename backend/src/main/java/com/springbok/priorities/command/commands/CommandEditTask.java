package com.springbok.priorities.command.commands;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.TaskDao;
import com.springbok.priorities.models.TaskModel;

public class CommandEditTask implements CommandInterface {
    private TaskModel task;

    public CommandEditTask(String commandData) {
      Gson gson = new Gson();
      task = gson.fromJson(commandData, TaskModel.class);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(Boolean.toString(TaskDao.updateTask(task)), "no error");
    }

}