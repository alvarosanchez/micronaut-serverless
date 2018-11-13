package slack.message;

import io.micronaut.function.FunctionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

@FunctionBean("slack-message")
public class SlackMessageFunction implements Function<SlackMessageRequest, String> {

    private static final Logger LOG = LoggerFactory.getLogger(SlackMessageFunction.class);

    private SlackService slackService;

    public SlackMessageFunction(SlackService slackService) {
        this.slackService = slackService;
    }

    @Override
    public String apply(SlackMessageRequest slackMessageRequest) {
        LOG.info("Sending text: \"{}\" to Slack", slackMessageRequest.getText());
        try {
            return slackService.postMessage(slackMessageRequest.getText());
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
