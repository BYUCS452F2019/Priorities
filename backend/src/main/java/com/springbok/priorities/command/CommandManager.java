package com.springbok.priorities.command;

import com.springbok.priorities.RequestInfo;

public class CommandManager {
    public static CommandResult executeCommand(RequestInfo request) {
        return CommandFactory.getCommand(request.type, request.data).execute();
    }
}