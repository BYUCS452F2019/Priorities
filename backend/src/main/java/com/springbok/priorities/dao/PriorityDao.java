package com.springbok.priorities.dao;

import java.util.List;

import com.springbok.priorities.models.PriorityModel;;

public class PriorityDao {
    public static Integer create(PriorityModel priority) {
        String sql = "INSERT into priority (user_id, title, type, number) VALUES ("
         + priority.user_id + ", '"
         + priority.title + "', '"
         + priority.type + "', "
         + priority.number
         + ")";
        System.out.println(sql); 
        try {
            return DaoManager.createObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static List<PriorityModel> getPrioritiesForUserID(String userID) {
        String sql = "SELECT * FROM priority WHERE user_id = " + userID;
        try {
            return DaoManager.getObjects(PriorityModel.class, sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Boolean updatePriority(PriorityModel priority) {
      String sql = "UPDATE priority SET"
         + "user_id" + priority.user_id
         + "title" + priority.title
         + "type" + priority.type
         + "number" + priority.number
         + "WHERE priority_id = " + priority.priority_id;
                        
        try {
            return DaoManager.updateObject(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}