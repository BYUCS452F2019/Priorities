package com.springbok.priorities.sqldao;

import java.util.List;

import com.springbok.priorities.daofactory.PriorityDaoInterface;
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
    public List<PriorityModel> getPrioritiesForUserID(Double userID) {
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
         + " title = '" + priority.title
         + "', type = " + priority.type
         + ", number = " + priority.number
         + " WHERE priority_id = " + priority.priority_id;
                        
        try {
            Boolean first = SQLDaoManager.updateObject(sql);
            Boolean second = updatePriorityDependencies(priority);
            return first && second;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private Boolean updatePriorityDependencies(PriorityModel priority) {
        String sql = "UPDATE task t " + 
                "SET start_remind_date = " +
                "FROM_UNIXTIME(UNIX_TIMESTAMP(due_date) - (" +
                    "SELECT (p.type * p.number * 24 * 60 * 60) as priority_offset " +
                    "FROM priority p " +
                    "WHERE p.priority_id = t.priority_id) " +
                ") WHERE t.priority_id = " + priority.priority_id + ";";
        try {
            return SQLDaoManager.updateObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        
    }
}