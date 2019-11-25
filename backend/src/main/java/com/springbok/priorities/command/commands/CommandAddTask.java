package com.springbok.priorities.command.commands;

import java.sql.Date;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springbok.priorities.command.*;
import com.springbok.priorities.command.daofactory.DaoFactory;
import com.springbok.priorities.models.TaskModel;

public class CommandAddTask implements CommandInterface {
    private TaskModel task;

    public CommandAddTask(Map<String, Object> commandData) {
      Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).create();
      task = gson.fromJson(gson.toJson(commandData), TaskModel.class);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(DaoFactory.getTaskDao().create(task), "no error");
    }

}