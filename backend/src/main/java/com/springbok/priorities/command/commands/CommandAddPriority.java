package com.springbok.priorities.command.commands;

import java.util.Map;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.PriorityDao;
import com.springbok.priorities.models.PriorityModel;

public class CommandAddPriority implements CommandInterface {
    private PriorityModel priority;

    public CommandAddPriority(Map<String, Object> commandData) {
      Gson gson = new Gson();
      priority = gson.fromJson(gson.toJson(commandData), PriorityModel.class);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(PriorityDao.create(priority), "error string");
    }

}