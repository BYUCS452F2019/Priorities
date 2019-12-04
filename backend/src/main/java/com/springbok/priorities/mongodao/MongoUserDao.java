package com.springbok.priorities.mongodao;

import com.springbok.priorities.daofactory.UserDaoInterface;
import com.springbok.priorities.models.UserModel;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import com.mongodb.Block;
import org.bson.Document;

public class MongoUserDao implements UserDaoInterface {

    private static final String USER_COLLECTION = "user_collection";

    @Override
    public Integer create(UserModel model) {
        MongoCollection<Document> coll = MongoDaoManager.getCollection(USER_COLLECTION);

        Integer user_id = (int) coll.countDocuments();

        Map<String, Object> map = new HashMap<>();

        map.put("userId", user_id);
        map.put("username", model.getUsername());
        map.put("email", model.getEmail());
        map.put("password", model.getPassword());

        Document document = new Document(map);
    
        coll.insertOne(document);
        return user_id;
    }

    @Override
    public Integer getUserID(String user_name, String password) {
        UserModel user;

        MongoCollection<Document> coll = MongoDaoManager.getCollection(USER_COLLECTION);
        coll.find(and(eq("username", user_name), eq("password"), password)).forEach(new Block<Document>() {
            @Override
            public void apply(Document t) {
                return (Integer) t.get("user_id");
            }
        });

        throw new Exception("Could not find user with username and password");
    }

    @Override
    public UserModel getUser(String user_id) {
        UserModel user;

        MongoCollection<Document> coll = MongoDaoManager.getCollection(USER_COLLECTION);
        coll.find(and(eq("user_id", user_id)).forEach(new Block<Document>() {
            @Override
            public void apply(Document t) {
                user = new UserModel(
                    (Integer) t.get("user_id"),
                    (String)  t.get("username"),
                    (String) t.get("email"),
                    (String) t.get("password")
                ));
                return t.get("user_id");
            }
        });
        return user;
    }

    @Override
    public Boolean updateUser(UserModel user) {
        // TODO Auto-generated method stub
        return null;
    }
    
}