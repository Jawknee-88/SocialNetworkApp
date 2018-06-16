import java.io.Console;

public class ConsoleReader {

    public static void main(String[] args) {

        Console console = System.console();
        String username = console.readLine("Hi, what's your name? ");

        console.printf("Welcome, " + username);

    }
}
