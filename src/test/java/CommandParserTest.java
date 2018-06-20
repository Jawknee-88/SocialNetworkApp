import com.mikeriddle.socialnetworkapp.Commands.CommandParser;
import com.mikeriddle.socialnetworkapp.Post;
import com.mikeriddle.socialnetworkapp.User;
import com.mikeriddle.socialnetworkapp.Users;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;


public class CommandParserTest {

    CommandParser commandParser;
    Users users;

    @Before
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
    public void inputWithPostingCommandFormatShouldAddANewPostToTheUser() {
        String input = "Alice -> I love the weather today";
        commandParser.parseInput(input, users);

        assertEquals(users.getUsers().size(),1);
        assertEquals(users.getUser("Alice").getPosts().size(),1);
        for (Post value : users.getUser("Alice").getPosts().values()) {
            assertTrue(value.toString().contains("I love the weather today"));
        }
    }

    @Test
    public void inputWithReadCommandShouldReturnChronologicalPosts() {
        users.addUser(new User("Alice"));
        users.getUser("Alice").addPost("Test message");
        //Adding sleep as for some reason items aren't added
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        users.getUser("Alice").addPost("A second test message");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        users.getUser("Alice").addPost("A third test message");

        String input = "Alice";

        String output = commandParser.parseInput(input, users);

        assertEquals(output, "Test message ( 0 seconds ago )\n" +
                "A second test message ( 0 seconds ago )\n" +
                "A third test message ( 0 seconds ago )\n");
    }

    @Test
    public void inputWithFollowCommandShouldAddAUserToTheFollowingList() {
        HashSet<User> expectedFollowing = new HashSet<>();
        User bob = new User("Bob");
        expectedFollowing.add(bob);
        users.addUser(new User("Alice"));
        users.addUser(new User("Bob"));

        commandParser.parseInput("Alice follows Bob", users);

        HashSet<User> following = users.getUser("Alice").getFollowing();
        assertThat(following, hasItem(hasProperty("name", is("Alice"))));
        assertThat(following, hasItem(hasProperty("name", is("Bob"))));
    }
}
