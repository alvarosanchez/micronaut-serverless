package slack.message;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import slack.message.client.SlackClient;

import javax.inject.Inject;

@MicronautTest
public class SlackClientTest {

    @Inject
    SlackClient client;

    @Test
    void testSendMessage() {
        final String response = client.postMessage("test", "Hello!", "Micronaut", "https://objectcomputing.com/files/cache/b6955553c8620cc0a3aed4c21d0588f0_f2130.jpg");

        Assertions.assertNotNull(response);
    }

}
