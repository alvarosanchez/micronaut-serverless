package slack.message;

import io.micronaut.function.client.FunctionClient;

import javax.inject.Named;

@FunctionClient
public interface SlackMessageClient {

    @Named("slack-message")
    String postMessage(SlackMessageRequest request);

}
