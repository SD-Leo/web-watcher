/*
 * 2017-11-19
 */
package ru.davist.webwatcher.core.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author Starovoytov Danil
 */
public class MongoDao {

    public static void init() {

//        MongoClientOptions opts = MongoClientOptions.builder().
        MongoClient mongo = new MongoClient("ds261755.mlab.com", 61755);

        MongoDatabase db = mongo.getDatabase("web-watcher");

        System.out.println(db.getName());

    }
}
