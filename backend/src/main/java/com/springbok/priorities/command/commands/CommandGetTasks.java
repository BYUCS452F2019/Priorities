package com.springbok.priorities.command.commands;

import java.sql.Date;
import java.util.Map;

import com.springbok.priorities.command.*;
import com.springbok.priorities.daofactory.DaoFactory;

public class CommandGetTasks implements CommandInterface {
    private Double user_id;
    private Date date;

    public CommandGetTasks(Map<String, Object> commandData) {
      this.user_id = (Double)commandData.get("user_id");
      if (commandData.containsKey("date")) {
        this.date = (Date) commandData.get("date");
      }
    }

    @Override
    public CommandResult execute() {
      if (this.date == null) {
        return new CommandResult(DaoFactory.getTaskDao().getTasksForUserID(user_id), "no error");
      } else {
        return new CommandResult(DaoFactory.getTaskDao().getTasksForUserIDForDate(user_id, date), "no error");
      }
    }

}