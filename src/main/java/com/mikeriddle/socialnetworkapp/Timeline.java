package com.mikeriddle.socialnetworkapp;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Timeline {

    HashMap<LocalDateTime, Post> posts;

    public Timeline(){
        posts = new HashMap<>();
    }

    public HashMap<LocalDateTime, Post> getPosts() {
        return posts;
    }
}
