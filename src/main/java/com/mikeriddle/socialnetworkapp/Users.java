package com.mikeriddle.socialnetworkapp;

import java.util.HashMap;

public class Users {
    private HashMap<String, User> users = new HashMap<>();

    public User addUser(User user) {
        users.put(user.getName(), user);
        return users.get(user);
    }


    public User getUser(String name) {
        return users.get(name);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}
