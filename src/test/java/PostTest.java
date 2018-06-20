import com.mikeriddle.socialnetworkapp.Post;
import com.mikeriddle.socialnetworkapp.User;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class PostTest {

    private Clock baseClock = Clock.systemDefaultZone();
    private Clock offsetClock;
    private User user;

    @Before
    public void before() {
        offsetClock = null;
        user = new User("Alice");
    }


    @Test
    public void getPostShouldShowCorrectTimestampForSeconds() {
        offsetClock = Clock.offset(baseClock, Duration.ofSeconds(-12));
        Post post = new Post("Hello World", offsetClock, user);

        assertEquals(post.toString(), "Hello World ( 12 seconds ago )\n");
    }

    @Test
    public void getPostShouldShowCorrectTimestampForOneMinute() {
        offsetClock = Clock.offset(baseClock, Duration.ofMinutes(-1));
        Post post = new Post("Hello World", offsetClock, user);

        assertEquals(post.toString(), "Hello World ( 1 minute ago )\n");
    }

    @Test
    public void getPostShouldShowCorrectTimestampForMinutes() {
        offsetClock = Clock.offset(baseClock, Duration.ofMinutes(-9));
        Post post = new Post("Hello World", offsetClock, user);

        assertEquals(post.toString(), "Hello World ( 9 minutes ago )\n");
    }

}
