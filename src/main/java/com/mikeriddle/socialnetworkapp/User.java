package com.mikeriddle.socialnetworkapp;

import java.time.LocalDateTime;
import java.util.*;

public class User {

    private String name;
    private Timeline timeline;
    private HashSet<User> following = new HashSet<>();
    private HashMap<LocalDateTime, Post> posts = new HashMap<>();

    public User(String name) {
        this.name = name;
        timeline = new Timeline();
        this.followUser(this);
    }

    public String getName() {
        return name;
    }
    public Timeline getTimeline(){
        return timeline;
    }

    public HashMap<LocalDateTime, Post> getPosts() {
        return posts;
    }

    public void addPost(String postText) {
        Post post = new Post(postText, this);
        posts.put(post.getTimestamp(), post);
    }


    public String getAllPostsToString() {
        String postsText = "";

        SortedSet<LocalDateTime> keys = new TreeSet<>(getPosts().keySet());
        for (LocalDateTime key : keys) {
            Post value = getPosts().get(key);
            postsText = postsText + value.toString();
        }

        return postsText;
    }

    public SortedMap<LocalDateTime, Post> getSortedPosts() {
        SortedMap<LocalDateTime, Post> sortedPosts = new TreeMap<>(getPosts());

        return sortedPosts;
    }

    public void followUser(User user) {
        following.add(user);
    }

    public HashSet<User> getFollowing() {
        return following;
    }

    public String getWall() {
        String wallPosts = "";
        SortedMap<LocalDateTime, Post> orderedMessages = new TreeMap<>();

        following.stream().forEach(user -> orderedMessages.putAll(user.getSortedPosts()));

        for(Map.Entry<LocalDateTime,Post> entry : orderedMessages.entrySet()) {
            Post post = entry.getValue();

            wallPosts += post.toStringWithUserPrepend();
        }

        return wallPosts;
    }
}
