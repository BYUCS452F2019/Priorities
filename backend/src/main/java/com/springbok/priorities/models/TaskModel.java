package com.springbok.priorities.models;

import java.sql.Date;

public class TaskModel extends Object {
    public String id;
    public String userID;
    public String priorityID;
    public String title;
    public String description;
    public Boolean completed;
    public Date creationDate;
    public Date dueDate;


    public TaskModel(String id, String userID, String priorityID, String title, String description, Boolean completed, Date creationDate, Date dueDate) {
        this.id = id;
        this.userID = userID;
        this.priorityID = priorityID;
        this.title = title;
        this. description = description;
        this.completed = completed;
        this. creationDate = creationDate;
        this.dueDate = dueDate;
    }
}