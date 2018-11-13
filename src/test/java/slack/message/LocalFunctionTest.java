package slack.message;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class LocalFunctionTest {

    @Inject
    SlackMessageClient client;

    @Test
    public void testFunction() {
        String response = client.postMessage(new SlackMessageRequest("Hello from test"));
        System.out.println(response);
        Assertions.assertNotNull(response);
    }
}
