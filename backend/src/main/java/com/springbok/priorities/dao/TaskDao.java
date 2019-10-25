package com.springbok.priorities.dao;

import java.sql.*;

import com.springbok.priorities.models.TaskModel;

public class TaskDao {
    public static String create(TaskModel task) {
        String sql = "INSERT into task (user_id, priority_id, title, descrition, completed, creation_date, due_date) VALUES ("
                        + task.userID + ", " 
                        + task.priorityID + ", " 
                        + task.title + ", " 
                        + task.description + ", " 
                        + task.completed + ", "
                        + task.creationDate + ", " 
                        + task.dueDate;
                        
        try {
            return DaoManager.createObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static TaskModel getTasksForUserID(String userID) {
        String sql = "SELECT * FROM Tasks WHERE user_id = " + userID;
        try {
            return (TaskModel)DaoManager.getObject(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}