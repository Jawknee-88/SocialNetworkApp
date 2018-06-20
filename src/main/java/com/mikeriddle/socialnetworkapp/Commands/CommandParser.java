package com.mikeriddle.socialnetworkapp.Commands;

import com.mikeriddle.socialnetworkapp.Users;

public class CommandParser {

    public String parseInput(String input, Users users) {
        final String[] splitInput = input.split("\\s+", 3);
        String output = "";
        if(splitInput.length == 1) {
            ReadCommand readCommand = new ReadCommand();
            output = readCommand.execute(splitInput, users);
        }
        else if(splitInput[1].equals("->")) {
            PostCommand postCommand = new PostCommand();
            postCommand.execute(splitInput, users);
            output = "";
        } else if(splitInput[1].equals("follows")) {
            FollowCommand followCommand = new FollowCommand();
            followCommand.execute(splitInput, users);
        } else if(splitInput[1].equals("wall")) {
            WallCommand wallCommand = new WallCommand();
            output = wallCommand.execute(splitInput, users);
        }

        return output;
    }
}
