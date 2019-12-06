package com.springbok.priorities.daofactory;

import java.sql.Date;
import java.util.List;

import com.springbok.priorities.models.TaskModel;

public interface TaskDaoInterface {
    public Integer create(TaskModel task);
    public List<TaskModel> getTasksForUserID(Double userID);
    public List<TaskModel> getTasksForUserIDForDate(Double userID, Date date);
    public List<TaskModel> getAllTasksForUserID(Double userID);
    public Boolean updateTask(TaskModel task);   
}