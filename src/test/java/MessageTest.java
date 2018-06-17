import com.mikeriddle.socialnetworkapp.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {

    private Message message;

    private LocalDateTime messageTimeStamp;

    Clock baseClock = Clock.systemDefaultZone();
    Clock offsetClock;

    @BeforeEach
    public void before() {

    }


    @Test
    public void getMessageShouldShowCorrectTimestampForSeconds() {
        offsetClock = Clock.offset(baseClock, Duration.ofSeconds(-12));
        Message message = new Message("Hello World", offsetClock);

        assertEquals(message.toString(), "Hello World ( 12 seconds ago )\n");
    }

    @Test
    public void getMessageShouldShowCorrectTimestampForOneMinute() {
        offsetClock = Clock.offset(baseClock, Duration.ofMinutes(-1));
        Message message = new Message("Hello World", offsetClock);

        assertEquals(message.toString(), "Hello World ( 1 minute ago )\n");
    }

    @Test
    public void getMessageShouldShowCorrectTimestampForMinutes() {
        offsetClock = Clock.offset(baseClock, Duration.ofMinutes(-9));
        Message message = new Message("Hello World", offsetClock);

        assertEquals(message.toString(), "Hello World ( 9 minutes ago )\n");
    }

}
