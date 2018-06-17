package com.mikeriddle.socialnetworkapp;

import java.time.LocalDateTime;

public class Message {

    private String message;
    private LocalDateTime timestamp;

    public Message(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
