package com.springbok.priorities.command.commands;

import com.google.gson.Gson;
import com.springbok.priorities.command.*;
import com.springbok.priorities.dao.PriorityDao;
import com.springbok.priorities.models.PriorityModel;

public class CommandEditPriority implements CommandInterface {
    private PriorityModel priority;

    public CommandEditPriority(String commandData) {
      Gson gson = new Gson();
      priority = gson.fromJson(commandData, PriorityModel.class);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(Boolean.toString(PriorityDao.updatePriority(priority)), "no error");
    }

}