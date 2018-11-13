package slack.message;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoteFunctionTest {

    @Test
    void testInvokeAws() {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class, CollectionUtils.mapOf(
                "aws.lambda.functions.slack.functionName", "slack-message",
                        "aws.lambda.region", "eu-west-1"
        ));
        SlackMessageClient remoteClient = server.getApplicationContext().getBean(SlackMessageClient.class);
        String response = remoteClient.postMessage(new SlackMessageRequest("Hello from remote test"));
        System.out.println(response);
        Assertions.assertNotNull(response);
        server.stop();
    }

}
