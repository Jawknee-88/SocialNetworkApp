import com.mikeriddle.socialnetworkapp.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void creatingNewUserShouldInitialiseEmptyTimeline(){
        User user = new User("Alice");

        assertEquals(user.getTimeline().getMessages().size(), 0);
    }
}
