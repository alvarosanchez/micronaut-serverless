package slack.message;

import io.micronaut.context.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slack.message.client.SlackClient;

import javax.inject.Singleton;

@Singleton
public class SlackService {

    private static final Logger LOG = LoggerFactory.getLogger(SlackService.class);

    private SlackClient slackClient;

    private String channel;

    public SlackService(SlackClient slackClient, @Value("${slack.channel:test}") String channel) {
        this.slackClient = slackClient;
        this.channel = channel;
    }

    public String postMessage(String message) {
        LOG.info("Sending a message to the channel: {}", this.channel);
        return slackClient.postMessage(channel, message, "Micronaut from Devoxx", "https://raw.githubusercontent.com/micronaut-projects/static-website/gh-pages/images/favicon-32x32.png");
    }
}
