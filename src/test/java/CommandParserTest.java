import com.mikeriddle.socialnetworkapp.Commands.CommandParser;
import com.mikeriddle.socialnetworkapp.Message;
import com.mikeriddle.socialnetworkapp.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandParserTest {

    CommandParser commandParser = new CommandParser();
    Users users = new Users();

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
            assertEquals(value.getMessage(), "I love the weather today");
        }
    }
}
