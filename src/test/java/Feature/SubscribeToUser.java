package Feature;

import Domain.ChatterApp;
import Domain.Console;
import Domain.MessagePrinter;
import Domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by emmabaddeley on 17/04/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SubscribeToUser {

    @Mock Console console;
    private ChatterApp chatter;
    private UserRepository userRepository;
    private MessagePrinter messagePrinter;

    @Before
    public void initialise() {
        messagePrinter = new MessagePrinter();
        userRepository = new UserRepository(messagePrinter);
        chatter = new ChatterApp(userRepository, console);
    }

    @Before
    public void createAllUsersAndPosts(){
        chatter.createUser("Spike", "@spike");
        chatter.postMessage("spike's first post");
        chatter.createUser("Nikesh", "@nikesh");
        chatter.postMessage("nikesh's first post");
    }

    @Test
    public void usercanSubscribeToOtherUser(){
        chatter.createUser("Leo", "@leo");
        chatter.subscribe("Spike");
        chatter.subscribe("Nikesh");
        chatter.viewSubscriptionsTimeline();
        verify(console).printLine("Welcome to Chatter, Spike");
        verify(console).printLine("Welcome to Chatter, Nikesh");
        verify(console).printLine("Welcome to Chatter, Leo");
        verify(console).printLine("Messages:\nspike's first post - @spike\nnikesh's first post - @nikesh\n");
    }



}
