package com.mikeriddle.socialnetworkapp;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

public class Post {

    private String postText;
    private LocalDateTime timestamp;
    Clock clock;
    User user;

    public Post(String postText, User user) {
        this.postText = postText;
        this.user = user;
        timestamp = LocalDateTime.now();
    }

    /*
    This method is used for testing so that a custom clock can be passed in, instead of
    mocking static method LocalDateTime.now();
     */
    public Post(String postText, Clock clock, User user) {
        this.postText = postText;
        this.user = user;
        this.clock = clock;
        timestamp = LocalDateTime.now(clock);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return postText + " ( " + getTimeElapsedSincePost(timestamp) + " )\n";
    }

    public String toStringWithUserPrepend() {
        return user.getName() + " - " + toString();
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
