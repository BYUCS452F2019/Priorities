package com.springbok.priorities.mongodao;

import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.Arrays;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;;

public class MongoDaoManager {
    public static MongoCollection<Document> getCollection(String collection_name) {
        final String databaseHost = "localhost";
        
        MongoCredential credential = MongoCredential.createCredential("userName", "database", "password".toCharArray());

        MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                .applyToClusterSettings(builder -> 
                    builder.hosts(Arrays.asList(new ServerAddress(databaseHost))))
                .credential(credential)
                .build());

        return mongoClient.getDatabase("databaseName").getCollection(collection_name);
    }

}