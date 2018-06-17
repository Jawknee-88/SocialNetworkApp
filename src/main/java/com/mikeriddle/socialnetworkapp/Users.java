package com.mikeriddle.socialnetworkapp;

import java.util.HashMap;

public class Users {
    private HashMap<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getName(), user);
    }


    public User getUser(String name) {
        return users.get(name);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}
