package slack.message.client;

import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("${slack.url}")
@Header(name="Authorization", value="Bearer ${slack.token}")
public interface SlackClient {

    @Post("chat.postMessage")
    String postMessage(String channel, String text, String username, String icon_url);

}
