package com.springbok.priorities.mongodao;

import java.util.List;

import com.springbok.priorities.daofactory.TaskDaoInterface;
import com.springbok.priorities.models.TaskModel;

public class MongoTaskDao implements TaskDaoInterface{
    
    @Override
    public List<TaskModel> getTasksForUserID(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer create(TaskModel task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean updateTask(TaskModel task) {
        // TODO Auto-generated method stub
        return null;
    }

}