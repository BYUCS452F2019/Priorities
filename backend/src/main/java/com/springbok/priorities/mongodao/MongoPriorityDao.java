package com.springbok.priorities.mongodao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import com.mongodb.client.model.Updates;

import com.springbok.priorities.daofactory.PriorityDaoInterface;
import com.springbok.priorities.models.PriorityModel;

public class MongoPriorityDao implements PriorityDaoInterface{

    @Override
    public List<PriorityModel> getPrioritiesForUserID(String userID) {
        MongoCollection<Document> coll = MongoDaoManager.getUserCollection();

        String priorityJson = (String)coll.find(and(eq("user_id", userID))).first().get("priorities");
        
        Gson gson = new Gson();
        List<PriorityModel> prioritiesList = gson.fromJson(priorityJson, new TypeToken<List<PriorityModel>>(){}.getType());
        return prioritiesList;
    }

    @Override
    public Integer create(PriorityModel priority) {
        MongoCollection<Document> coll = MongoDaoManager.getUserCollection();

        Integer priority_id = (int) coll.count(and(eq("user_id", priority.getUser_id().toString())));

        Map<String, Object> map = new HashMap<>();

        map.put("priority_id", priority_id);
        map.put("user_id", priority.getUser_id());
        map.put("title", priority.getTitle());
        map.put("type", priority.getType());
        map.put("number", priority.getNumber());

        Document document = new Document(map);
    
        coll.insertOne(document);
        return priority_id;
    }

    @Override
    public Boolean updatePriority(PriorityModel priority) {

        return true;
    }

}