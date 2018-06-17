import com.mikeriddle.socialnetworkapp.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    User user;

    @BeforeEach
    public void before() {
        user = new User("Alice");
    }

    @Test
    public void creatingNewUserShouldInitialiseEmptyTimeline(){
        assertEquals(user.getTimeline().getMessages().size(), 0);
    }

    @Test
    public void shouldOutputMessagesInTheOrderTheyWerePosted() {

        for(int i = 0; i<4; i++) {
            user.addMessage("Test " + i);
        }

        assertEquals(user.getAllMessagesToString(), "Test 0\n" +
                "Test 1\n" +
                "Test 2\n" +
                "Test 3\n");

    }
}
