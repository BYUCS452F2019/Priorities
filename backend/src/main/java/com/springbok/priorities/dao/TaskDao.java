package com.springbok.priorities.dao;

import java.sql.*;

import com.springbok.priorities.models.TaskModel;

public class TaskDao {
    public static String create(TaskModel task) {
        try {
            Connection conn = DaoManager.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT into task (user_id, priority_id, title, descrition, completed, creation_date, due_date) VALUES ("
                        + task.userID + ", " + task.priorityID + ", " + task.title + ", " + task.description + ", " + task.completed + ", "
                        + task.creationDate + ", " + task.dueDate;

            DaoManager.closeConnection(conn);
            return "authorization";
        } catch (Exception sQLException) {
            return "bad connection";
        }
    }

    public static String getTasksForUserID(String userID) {
        String sql = "SELECT * FROM Tasks WHERE user_id = " + userID;
        return "";
    }
}