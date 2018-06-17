package com.mikeriddle.socialnetworkapp;

import java.time.LocalDateTime;
import java.util.HashMap;

public class User {

    private String name;
    private Timeline timeline;

    private HashMap<LocalDateTime, Message> messages = new HashMap<>();

    public User(String name) {
        this.name = name;
        timeline = new Timeline();
    }

    public String getName() {
        return name;
    }
    public Timeline getTimeline(){
        return timeline;
    }

    public HashMap<LocalDateTime, Message> getMessages() {
        return messages;
    }

    public void addMessage(String messageText) {
        Message message = new Message(messageText);
        messages.put(message.getTimestamp(), message);
    }
}
