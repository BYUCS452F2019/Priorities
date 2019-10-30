package com.springbok.priorities.models;

import java.sql.Date;

public class TaskModel {
    @DBTable(columnName = "task_id")
    public Integer task_id;
    @DBTable(columnName = "user_id")
    public Integer user_id;
    @DBTable(columnName = "priority_id")
    public Integer priority_id;
    @DBTable(columnName = "due_date")
    public String due_date;
    @DBTable(columnName = "title")
    public String title;
    @DBTable(columnName = "creation_date")
    public Boolean creation_date;
    @DBTable(columnName = "description")
    public Date description;
    @DBTable(columnName = "completed")
    public Date completed;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(Integer priority_id) {
        this.priority_id = priority_id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Boolean creation_date) {
        this.creation_date = creation_date;
    }

    public Date getDescription() {
        return description;
    }

    public void setDescription(Date description) {
        this.description = description;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public TaskModel(Integer task_id, Integer user_id, Integer priority_id, String due_date, String title,
            Boolean creation_date, Date description, Date completed) {
        this.task_id = task_id;
        this.user_id = user_id;
        this.priority_id = priority_id;
        this.due_date = due_date;
        this.title = title;
        this.creation_date = creation_date;
        this.description = description;
        this.completed = completed;
    }
    
    
}