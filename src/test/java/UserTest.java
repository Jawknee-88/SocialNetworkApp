import com.mikeriddle.socialnetworkapp.Post;
import com.mikeriddle.socialnetworkapp.User;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserTest {

    User userAlice;

    private Clock baseClock = Clock.systemDefaultZone();

    @Before
    public void before() {
        userAlice = new User("Alice");
    }

    @Test
    public void creatingNewUserShouldInitialiseEmptyTimeline() {
        assertEquals(userAlice.getTimeline().getPosts().size(), 0);
    }

    @Test
    public void shouldOutputPostsInTheOrderTheyWerePosted() {

        for(int i = 0; i<4; i++) {
            userAlice.addPost("Test " + i);
            //Sleeping as otherwise for some reason items sometimes aren't added.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertEquals(userAlice.getAllPostsToString(), "Test 0 ( 0 seconds ago )\n" +
                "Test 1 ( 0 seconds ago )\n" +
                "Test 2 ( 0 seconds ago )\n" +
                "Test 3 ( 0 seconds ago )\n");

    }

    @Test
    public void addingFollowersShouldSuccessfullyAddThoseFollowers() {
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        HashSet<User> expectedFollowing = new HashSet<>();
        expectedFollowing.add(userAlice);
        expectedFollowing.add(bob);
        expectedFollowing.add(charlie);

        userAlice.followUser(bob);
        userAlice.followUser(charlie);

        assertTrue(expectedFollowing.equals(userAlice.getFollowing()));
    }

    @Test
    public void getUsersWallShouldReturnOrderedOutputOfFollowersAndUsersPosts() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        try {
            alice.addPost("Test 1");
            Thread.sleep(100);
            bob.addPost("Test 2");
            Thread.sleep(100);
            bob.addPost("Test 3");
            Thread.sleep(100);
            charlie.addPost("Test 5");
            Thread.sleep(100);
            alice.addPost("Test 4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alice.followUser(charlie);
        alice.followUser(bob);

        assertEquals(alice.getWall(), "Alice - Test 1 ( 0 seconds ago )\n" +
                "Bob - Test 2 ( 0 seconds ago )\n" +
                "Bob - Test 3 ( 0 seconds ago )\n" +
                "Charlie - Test 5 ( 0 seconds ago )\n" +
                "Alice - Test 4 ( 0 seconds ago )\n");
    }

    @Test
    public void getUserWallShouldNotOutputAnythingForFollowedUsersWithNoPosts() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        alice.addPost("Test 1");

        alice.followUser(bob);

        assertEquals(alice.getWall(), "Alice - Test 1 ( 0 seconds ago )\n");
    }

    @Test
    public void userShouldByDefaultFollowThemself() {
        HashMap<LocalDateTime, Post> posts= new HashMap<>();
        posts.put(LocalDateTime.now(getOffsetClockMinutes(-1)), new Post("Test 1", userAlice));
        userAlice.addPost("Test 1");

        assertTrue(userAlice.getWall().contains("Alice - Test 1"));

    }

    private Clock getOffsetClockMinutes(long minutes) {
        return Clock.offset(baseClock, Duration.ofMinutes(minutes));
    }

}
