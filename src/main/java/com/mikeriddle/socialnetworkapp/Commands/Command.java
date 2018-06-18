package com.mikeriddle.socialnetworkapp.Commands;

import com.mikeriddle.socialnetworkapp.Users;

public interface Command {

    String execute(String[] inputParams, Users users);
}
