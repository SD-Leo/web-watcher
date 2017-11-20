/*
 * 2017-11-19
 */
package ru.davist.webwatcher.core.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author Starovoytov Danil
 */
public class MongoDaoTest {

    private static final Logger log = LoggerFactory.getLogger(MongoDaoTest.class);

    public static void init() {

        String host = "ds261755.mlab.com";
        int port = 61755;
        String username = "admin";
        char[] password = "y2Hx+3d-w".toCharArray();
        String dbName = "web-watcher";

        String connString = "mongodb://" + username + ":" + String.valueOf(password) + "@" + host + ":" + port + "/?authSource=" + dbName + "&authMechanism=SCRAM-SHA-1";
        log.debug("Connection: {}", connString);

        MongoClient mongoClient = null;
        try {


            MongoCredential credential = MongoCredential.createScramSha1Credential(username, dbName, password);
            mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));

//            mongoClient = new MongoClient(new MongoClientURI(connString));

            PojoCodecProvider provider = PojoCodecProvider.builder().register(User.class).automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(provider));

//        MongoClientOptions opts = MongoClientOptions.builder().
//        MongoClient mongo = new MongoClient("ds261755.mlab.com", 61755);

            MongoDatabase db = mongoClient.getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);

//        db.withCodecRegistry(pojoCodecRegistry);


            MongoCollection<User> user = db.getCollection("user", User.class);

            System.out.println(db.getName());
            System.out.println(user.count());

            User jade = new User("Jade", 26);

            user.insertOne(jade);
            System.out.println(user.count());
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }

    }

    @Test
    public void test() {
        init();
    }

//    public static class User {
//        private String name;
//        private int age;
//
//        public User(String name) {
//            this.name = name;
//        }
//
//        public User(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//    }
}
