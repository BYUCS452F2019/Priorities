package com.springbok.priorities.dao;

import java.util.List;

import com.springbok.priorities.models.TaskModel;

public class TaskDao {
    public static String create(TaskModel task) {
        String sql = "INSERT into task (user_id, priority_id, title, descrition, completed, creation_date, due_date) VALUES ("
                        + task.user_id + ", " 
                        + task.priority_id + ", " 
                        + task.title + ", " 
                        + task.description + ", " 
                        + task.completed + ", "
                        + task.creation_date + ", " 
                        + task.due_date;
                        
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

    public static Boolean updateTask(TaskModel task) {
        String sql = "UPDATE task SET"
        + "task.user_id = " + task.user_id
        + "task.priority_id = " + task.priority_id
        + "task.title = " + task.title
        + "task.description = " + task.description
        + "task.completed = " + task.completed
        + "task.creation_date = " + task.creation_date
        + "task.due_date = " + task.due_date
         + "WHERE task_id = " + task.task_id;
                        
        try {
            return DaoManager.updateObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}