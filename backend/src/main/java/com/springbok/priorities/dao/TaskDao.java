package com.springbok.priorities.dao;

import java.util.List;

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

    public static List<TaskModel> getTasksForUserID(String userID) {
        String sql = "SELECT * FROM task WHERE user_id = " + userID;
        try {
            return DaoManager.getObjects(TaskModel.class, sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}