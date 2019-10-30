package com.springbok.priorities.models;

import java.sql.Date;

public class TaskModel {
    @DBTable(columnName = "id")
    public Integer id;
    @DBTable(columnName = "userID")
    public Integer userID;
    @DBTable(columnName = "priorityID")
    public Integer priorityID;
    @DBTable(columnName = "title")
    public String title;
    @DBTable(columnName = "description")
    public String description;
    @DBTable(columnName = "completed")
    public Boolean completed;
    @DBTable(columnName = "creationDate")
    public Date creationDate;
    @DBTable(columnName = "dueDate")
    public Date dueDate;


    public TaskModel(Integer id, Integer userID, Integer priorityID, String title, String description, Boolean completed, Date creationDate, Date dueDate) {
        this.id = id;
        this.userID = userID;
        this.priorityID = priorityID;
        this.title = title;
        this. description = description;
        this.completed = completed;
        this. creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(Integer priorityID) {
        this.priorityID = priorityID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    
}