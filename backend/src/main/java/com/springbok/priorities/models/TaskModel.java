package com.springbok.priorities.models;

import java.sql.Timestamp;

public class TaskModel {
    @DBTable(columnName = "task_id")
    public Integer task_id;
    @DBTable(columnName = "user_id")
    public Integer user_id;
    @DBTable(columnName = "priority_id")
    public Integer priority_id;
    @DBTable(columnName = "due_date")
    public Timestamp due_date;
    @DBTable(columnName = "start_remind_date")
    public Timestamp start_remind_date;
    @DBTable(columnName = "title")
    public String title;
    @DBTable(columnName = "creation_date")
    public Timestamp creation_date;
    @DBTable(columnName = "description")
    public String description;
    @DBTable(columnName = "completed")
    public Boolean completed;

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

    public Timestamp getDue_date() {
        return this.due_date;
    }

    public void setDue_date(Timestamp due_date) {
        this.due_date = due_date;
    }

    public Timestamp getStart_remind_date() {
        return this.start_remind_date;
    }

    public void setStart_remind_date(Timestamp start_remind_date) {
        this.start_remind_date = start_remind_date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreation_date() {
        return this.creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public TaskModel(Integer task_id, Integer user_id, Integer priority_id, Timestamp due_date, Timestamp start_remind_date, String title,
            Timestamp creation_date, String description, Boolean completed) {
        this.task_id = task_id;
        this.user_id = user_id;
        this.priority_id = priority_id;
        this.due_date = due_date;
        this.start_remind_date = start_remind_date;
        this.title = title;
        this.creation_date = creation_date;
        this.description = description;
        this.completed = completed;
    }
    
    public TaskModel() {
        
    }

    @Override
    public String toString() {
        return "TaskModel [completed=" + completed + ", creation_date=" + creation_date + ", description=" + description
                + ", due_date=" + due_date + ", priority_id=" + priority_id + ", start_remind_date=" + start_remind_date
                + ", task_id=" + task_id + ", title=" + title + ", user_id=" + user_id + "]";
    }

    
}