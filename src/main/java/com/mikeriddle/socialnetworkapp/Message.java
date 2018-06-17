package com.mikeriddle.socialnetworkapp;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

public class Message {

    private String message;
    private LocalDateTime timestamp;
    Clock clock;

    public Message(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    /*
    This method is used for testing so that a custom clock can be passed in, instead of
    mocking static method LocalDateTime.now();
     */
    public Message(String message, Clock clock) {
        this.message = message;
        this.clock = clock;
        timestamp = LocalDateTime.now(clock);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return message + " ( " + getTimeElapsedSincePost(timestamp) + " )\n";
    }

    private String getTimeElapsedSincePost(LocalDateTime time){
        LocalDateTime now = LocalDateTime.now();
        Duration timeElapsed = Duration.between(time, now);
        String output = "";

        if(timeElapsed.toMinutes() <= 0) {
            output = Long.toString(timeElapsed.toMillis() / 1000) + " seconds ago";
        } else {
            String minuteString = timeElapsed.toMinutes() > 1 ? " minutes ago" : " minute ago";
            output = Long.toString(timeElapsed.toMinutes()) + minuteString;
        }
        return output;
    }
}
