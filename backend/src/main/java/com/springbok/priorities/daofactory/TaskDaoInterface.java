package com.springbok.priorities.daofactory;

import java.util.List;

import com.springbok.priorities.models.TaskModel;

public interface TaskDaoInterface {
    public Integer create(TaskModel task);
    public List<TaskModel> getTasksForUserID(Double userID);
    public Boolean updateTask(TaskModel task);   
}