package com.springbok.priorities.mongodao;

import com.springbok.priorities.daofactory.TaskDaoInterface;
import com.springbok.priorities.models.TaskModel;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import com.mongodb.Block;
import org.bson.Document;

public class MongoTaskDao implements TaskDaoInterface{
    private final static String TASK_COLLECTION = "task";

    @Override
    public List<TaskModel> getTasksForUserID(String userID) {
        List<TaskModel> taskList = new ArrayList<>();
        
        MongoCollection<Document> coll = MongoDaoManager.getCollection(TASK_COLLECTION);

        coll.find(and(eq("user_id", Double.parseDouble(userID)))).forEach(new Block<Document>() {
            @Override
            public void apply(Document t) {
                taskList.add(new TaskModel(
                    (Integer) t.get("task_id"),
                    (Integer) t.get("user_id"),
                    (Integer) t.get("priority_id"),
                    (Date) t.get("due_date"),
                    (Date) t.get("start_remind_date"),
                    (String) t.get("title"),
                    (Date) t.get("creation_date"),
                    (String) t.get("description"),
                    (Boolean) t.get("completed")
                ));
            }
        });
        
        return taskList;
    }

    @Override
    public Integer create(TaskModel task) {
        MongoCollection<Document> coll = MongoDaoManager.getCollection(TASK_COLLECTION);

        Integer task_id = (int) coll.countDocuments(and(eq("user_id", task.getUser_id().toString())));

        Map<String, Object> map = new HashMap<>();

        map.put("task_id", task_id);
        map.put("user_id", task.getUser_id());
        map.put("priority_id", task.getPriority_id());
        map.put("due_date", task.getDue_date());
        map.put("start_remind_date", task.getStart_remind_date());
        map.put("title", task.getTitle());
        map.put("creation_date", task.getCreation_date());
        map.put("description", task.getDescription());
        map.put("completed", task.getCompleted());

        Document document = new Document(map);
    
        coll.insertOne(document);
        return task_id;
    }

    @Override
    public Boolean updateTask(TaskModel task) {
        MongoCollection<Document> coll = MongoDaoManager.getCollection(TASK_COLLECTION);

        coll.updateOne(
            and(eq("task_id", task.getTask_id()), eq("user_id", task.getUser_id())),
            combine(
                set("due_date", task.getDue_date()),
                set("start_remind_date", task.getStart_remind_date()),
                set("title", task.getTitle()),
                set("creation_date", task.getCreation_date()),
                set("description", task.getDescription()),
                set("completed", task.getCompleted())
            )
            );

        return true;
    }
}