package com.mikeriddle.socialnetworkapp.Commands;

import com.mikeriddle.socialnetworkapp.Users;

public class CommandParser {

    public String parseInput(String input, Users users) {
        final String[] splitInput = input.split("\\s+", 3);
        String output = "";
        if(splitInput[1].equals("->")) {
            PostCommand postCommand = new PostCommand();
            postCommand.execute(splitInput, users);
            output = "";
        }

        return output;
    }
}
