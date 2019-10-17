package com.springbok.priorities.command;

public class CommandResult {
    public String response;
    public String error;

    public CommandResult(String response, String error) {
        this.response = response;
        this.error = error;
    }

    public String getResponse() {return this.response;}
    public String getError() {return this.error;}

    public void setResponse(String response) {this.response = response;}
    public void setError(String error) {this.error = error;} 
}