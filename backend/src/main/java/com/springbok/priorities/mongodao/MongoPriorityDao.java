package com.springbok.priorities.mongodao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import com.mongodb.Block;
import org.bson.Document;

import com.springbok.priorities.daofactory.PriorityDaoInterface;
import com.springbok.priorities.models.PriorityModel;

public class MongoPriorityDao implements PriorityDaoInterface{

    private static final String PRIORITY_COLLECTION = "priority_collection";

    @Override
    public List<PriorityModel> getPrioritiesForUserID(String userID) {
        List<PriorityModel> prioritiesList = new ArrayList<>();
        
        MongoCollection<Document> coll = MongoDaoManager.getCollection(PRIORITY_COLLECTION);

        coll.find(and(eq("user_id", userID))).forEach(new Block<Document>() {
            @Override
            public void apply(Document t) {
                prioritiesList.add(new PriorityModel(
                    (Integer) t.get("priority_id"),
                    (Integer)  t.get("user_id"),
                    (String) t.get("title"),
                    (Integer) t.get("type"),
                    (Integer) t.get("number")
                ));
            }
        });
        
        return prioritiesList;
    }


    @Override
    public Integer create(PriorityModel priority) {
        MongoCollection<Document> coll = MongoDaoManager.getCollection(PRIORITY_COLLECTION);

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
        MongoCollection<Document> coll = MongoDaoManager.getCollection(PRIORITY_COLLECTION);

        coll.updateOne(
            and(eq("priority_id", priority.getPriority_id()), eq("user_id", priority.getUser_id())),
            combine(set("type", priority.getType()), set("number", priority.getNumber()), set("title", priority.getTitle()))
            );

        return true;
    }

}