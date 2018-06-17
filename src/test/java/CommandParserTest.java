import com.mikeriddle.socialnetworkapp.Commands.CommandParser;
import com.mikeriddle.socialnetworkapp.Message;
import com.mikeriddle.socialnetworkapp.User;
import com.mikeriddle.socialnetworkapp.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandParserTest {

    CommandParser commandParser;
    Users users;

    @BeforeEach
    public void before() {
        users = new Users();
        commandParser = new CommandParser();
    }


    @Test
    public void inputWithPostingCommandFormatShouldAddNewUserIfITDoesntExist() {
        String input = "Alice -> Howdy";
        commandParser.parseInput(input, users);

        assertEquals(users.getUser("Alice").getName(), "Alice");
    }

    @Test
    public void inputWithPostingCommandFormatShouldAddANewMessageToTheUser() {
        String input = "Alice -> I love the weather today";
        commandParser.parseInput(input, users);

        assertEquals(users.getUsers().size(),1);
        assertEquals(users.getUser("Alice").getMessages().size(),1);
        for (Message value : users.getUser("Alice").getMessages().values()) {
            assertEquals(value.toString(), "I love the weather today\n");
        }
    }

    @Test
    public void inputWithReadCommandShouldReturnChronologicalPosts() {
        users.addUser(new User("Alice"));
        users.getUser("Alice").addMessage("Test message");
        users.getUser("Alice").addMessage("A second test message");
        users.getUser("Alice").addMessage("A third test message");

        String input = "Alice";

        String output = commandParser.parseInput(input, users);

        assertEquals(output, "Test message\n" +
                "A second test message\n" +
                "A third test message\n");
    }
}
