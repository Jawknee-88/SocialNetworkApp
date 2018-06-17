package com.mikeriddle.socialnetworkapp;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Timeline {

    HashMap<LocalDateTime, Message> messages;

    public Timeline(){
        messages = new HashMap<>();
    }

    public HashMap<LocalDateTime, Message> getMessages() {
        return messages;
    }
}
