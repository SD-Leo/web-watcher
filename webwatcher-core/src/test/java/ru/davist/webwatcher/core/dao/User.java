/*
 * 2017-11-19
 */
package ru.davist.webwatcher.core.dao;

import java.util.UUID;

/**
 * @author Starovoytov Danil
 */
public class User {

    private String id;

    private String name;
    private int age;

    public User() {
        this.id = UUID.randomUUID().toString().substring(0, 10);
    }

    public User(String name) {
        this();
        this.name = name;
    }

    public User(String name, int age) {
        this(name);
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
