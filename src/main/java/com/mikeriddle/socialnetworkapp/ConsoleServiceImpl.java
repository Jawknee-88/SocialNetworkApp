package com.mikeriddle.socialnetworkapp;

import com.mikeriddle.socialnetworkapp.Commands.CommandParser;

import java.io.Console;
import java.io.IOError;

public class ConsoleServiceImpl implements ConsoleService {

    private final java.io.Console delegateConsole;
    private Users users;

    public ConsoleServiceImpl(Console delegateConsole, Users users) {
        this.delegateConsole = delegateConsole;
        this.users = users;
    }

    @Override
    public String readLine() throws IOError {

        final String input = delegateConsole.readLine();
        CommandParser commandParser = new CommandParser();
        return commandParser.parseInput(input, users);

    }

}
