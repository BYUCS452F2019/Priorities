package com.springbok.priorities.sqldao;

import java.util.List;

import com.springbok.priorities.command.daofactory.PriorityDaoInterface;
import com.springbok.priorities.models.PriorityModel;;

public class SQLPriorityDao implements PriorityDaoInterface {
    
    @Override
    public Integer create(PriorityModel priority) {
        String sql = "INSERT into priority (user_id, title, type, number) VALUES ("
         + priority.user_id + ", '"
         + priority.title + "', '"
         + priority.type + "', "
         + priority.number
         + ")";
        System.out.println(sql); 
        try {
            return SQLDaoManager.createObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PriorityModel> getTasksForUserID(String userID) {
        String sql = "SELECT * FROM priority WHERE user_id = " + userID;
        try {
            return SQLDaoManager.getObjects(PriorityModel.class, sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean updatePriority(PriorityModel priority) {
      String sql = "UPDATE priority SET"
         + "user_id" + priority.user_id
         + "title" + priority.title
         + "type" + priority.type
         + "number" + priority.number
         + "WHERE priority_id = " + priority.priority_id;
                        
        try {
            return SQLDaoManager.updateObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}