package com.springbok.priorities.command;

public class CommandResult {
    public Object response;
    public String error;

    public CommandResult(Object response, String error) {
        this.response = response;
        this.error = error;
    }

    public Object getResponse() {return this.response;}
    public String getError() {return this.error;}

    public void setResponse(String response) {this.response = response;}
    public void setError(String error) {this.error = error;} 
}