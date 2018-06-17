package com.mikeriddle.socialnetworkapp;

import java.time.LocalDateTime;
import java.util.*;

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


    public String getAllMessagesToString() {
        String messagesText = "";

        SortedSet<LocalDateTime> keys = new TreeSet<>(getMessages().keySet());
        for (LocalDateTime key : keys) {
            Message value = getMessages().get(key);
            messagesText = messagesText + value.toString();
        }

        return messagesText;
    }
}
