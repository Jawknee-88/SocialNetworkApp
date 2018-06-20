package com.mikeriddle.socialnetworkapp.Commands;

import com.mikeriddle.socialnetworkapp.User;
import com.mikeriddle.socialnetworkapp.Users;

public class WallCommand implements Command {

    @Override
    public String execute(String[] inputParams, Users users) {
        User user = users.getUser(inputParams[0]);

        return user.getWall();
    }
}
