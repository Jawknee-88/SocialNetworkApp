package com.mikeriddle.socialnetworkapp;

import java.io.Console;

public class Controller {

    static Users users = new Users();

    public static void main(String[] args) {
        Console console = System.console();
        ConsoleServiceImpl consoleService = new ConsoleServiceImpl(console, users);

        while(true) {
            console.printf(consoleService.readLine());
        }
    }
}
