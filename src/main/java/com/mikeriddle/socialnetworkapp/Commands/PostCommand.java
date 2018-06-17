package com.mikeriddle.socialnetworkapp.Commands;

import com.mikeriddle.socialnetworkapp.User;
import com.mikeriddle.socialnetworkapp.Users;

public class PostCommand implements Command {


    @Override
    public String execute(String[] inputParams, Users users) {
        if(users.getUser(inputParams[0]) == null) {
            users.addUser(new User(inputParams[0]));
        }

        User user = users.getUser(inputParams[0]);

        user.addMessage(inputParams[2]);

        return null;
    }
}
