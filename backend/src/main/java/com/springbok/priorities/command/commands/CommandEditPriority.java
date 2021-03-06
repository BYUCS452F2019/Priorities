package com.springbok.priorities.command.commands;

import java.util.Map;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.daofactory.DaoFactory;
import com.springbok.priorities.models.PriorityModel;

public class CommandEditPriority implements CommandInterface {
    private PriorityModel priority;

    public CommandEditPriority(Map<String, Object> commandData) {
      Gson gson = new Gson();
      priority = gson.fromJson(gson.toJson(commandData), PriorityModel.class);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(DaoFactory.getPriorityDao().updatePriority(priority), "no error");
    }

}