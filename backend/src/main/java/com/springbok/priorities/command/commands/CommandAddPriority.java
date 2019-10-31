package com.springbok.priorities.command.commands;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.PriorityDao;
import com.springbok.priorities.models.PriorityModel;

public class CommandAddPriority implements CommandInterface {
    private PriorityModel priority;

    public CommandAddPriority(String commandData) {
      Gson gson = new Gson();
      priority = gson.fromJson(commandData, PriorityModel.class);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(PriorityDao.create(priority), "error string");
    }

}