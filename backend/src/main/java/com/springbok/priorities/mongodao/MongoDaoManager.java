package com.springbok.priorities.mongodao;

import org.bson.Document;

import java.util.Arrays;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class MongoDaoManager {
    public static MongoCollection<Document> getCollection(String collection_name) {
        final String databaseHost = "localhost";
        
        MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                .applyToClusterSettings(builder -> 
                    builder.hosts(Arrays.asList(new ServerAddress(databaseHost))))
                .build());

        return mongoClient.getDatabase("priorities").getCollection(collection_name);
    }

}