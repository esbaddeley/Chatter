package Domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class UserTest {
    private User user;

    @Before
    public void initialize() {
        user = new User("Emma", "@emmab");
    }

    @Test
    public void postMessageCreatesAMessage(){
        user.postMessage("This is my first post");
        List<Message> messages = user.viewTimeline();
        assertThat(messages.get(0), is(createMessage("This is my first post")));
    }

    public Message createMessage(String text){
        return new Message(text);
    }

}