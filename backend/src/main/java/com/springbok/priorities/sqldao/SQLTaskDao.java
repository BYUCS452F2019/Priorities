package com.springbok.priorities.sqldao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.springbok.priorities.daofactory.TaskDaoInterface;
import com.springbok.priorities.models.TaskModel;

public class SQLTaskDao implements TaskDaoInterface{

    @Override
    public Integer create(TaskModel task) {
        System.out.println(task.toString());
        String sql = "INSERT into task (user_id, priority_id, title, description, completed, creation_date, due_date, start_remind_date) VALUES ("
                        + task.user_id + ", " 
                        + task.priority_id + ", '" 
                        + task.title + "', '" 
                        + task.description + "', " 
                        + task.completed + ", '"
                        + task.creation_date + "', '" 
                        + task.due_date + "', '" 
                        + task.start_remind_date + "')";
                        
        try {
            return SQLDaoManager.createObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TaskModel> getTasksForUserID(Double userID) {
        String sql = "SELECT * FROM task WHERE user_id = " + userID + " AND completed = 0 AND start_remind_date < CURRENT_TIMESTAMP" + " ORDER BY due_date";
        try {
            return SQLDaoManager.getObjects(TaskModel.class, sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TaskModel> getTasksForUserIDForDate(Double userID, Timestamp timestamp) {
        String sql = "SELECT * FROM task WHERE user_id = " + userID + 
            " AND completed = 0 AND start_remind_date < '" + timestamp + "'" +
            " AND (due_date >= '" + timestamp + "'" +
            " OR (YEAR(due_date) = YEAR('" + timestamp + "') " + 
            " AND MONTH(due_date) = MONTH('" + timestamp + "') " + 
            " AND DAY(due_date) = DAY('" + timestamp + "'))) " +
            " ORDER BY due_date";
            System.out.println(sql);
        try {
            return SQLDaoManager.getObjects(TaskModel.class, sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TaskModel> getAllTasksForUserID(Double userID) {
        String sql = "SELECT * FROM task WHERE user_id = " + userID + " ORDER BY due_date";
        try {
            return SQLDaoManager.getObjects(TaskModel.class, sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    

    @Override
    public Boolean updateTask(TaskModel task) {
        String sql = "UPDATE task SET"
        + " task.priority_id = " + task.priority_id
        + ", task.title = '" + task.title
        + "', task.description = '" + task.description
        + "', task.completed = " + task.completed
        + ", task.creation_date = '" + task.creation_date
        + "', task.due_date = '" + task.due_date
        + "', task.start_remind_date = '" + task.start_remind_date
        + "' WHERE task_id = " + task.task_id;
                        
        try {
            return SQLDaoManager.updateObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}