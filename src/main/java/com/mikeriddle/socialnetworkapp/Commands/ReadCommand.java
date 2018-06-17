package com.mikeriddle.socialnetworkapp.Commands;

import com.mikeriddle.socialnetworkapp.User;
import com.mikeriddle.socialnetworkapp.Users;


public class ReadCommand implements Command {

    @Override
    public String execute(String[] command, Users users) {
        User user = users.getUser(command[0]);
        return user.getAllMessagesToString();

    }
}
