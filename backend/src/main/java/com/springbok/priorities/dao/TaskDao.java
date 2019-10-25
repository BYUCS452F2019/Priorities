package com.springbok.priorities.dao;

import com.springbok.priorities.models.*;

public class TaskDao {
    public static String create(TaskModel task) {
        return "authorization";
    }

    public static String getTasksForUserID(String userID) {
        String sql = "SELECT * FROM Tasks WHERE user_id = " + userID;
        return "";
    }
}