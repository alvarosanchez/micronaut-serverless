package slack.message;

import java.io.Serializable;

public class SlackMessageRequest implements Serializable {

    private String text;

    public SlackMessageRequest() {}

    public SlackMessageRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
