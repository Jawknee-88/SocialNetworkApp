package com.mikeriddle.socialnetworkapp.Commands;

import com.mikeriddle.socialnetworkapp.User;
import com.mikeriddle.socialnetworkapp.Users;

public class FollowCommand implements Command {
    @Override
    public String execute(String[] inputParams, Users users) {

        User user = users.getUser(inputParams[0]);

        user.followUser(users.getUser(inputParams[2]));

        return null;
    }
}
