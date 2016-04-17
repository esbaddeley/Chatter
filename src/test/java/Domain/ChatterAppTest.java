package Domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by emmabaddeley on 16/04/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class ChatterAppTest {

    private  ChatterApp chatter;
    @Mock private UserRepository userRepository;
    @Mock private Console console;

    @Before
    public void initialize(){
        chatter = new ChatterApp(userRepository, console);
    }

    @Test public void
    createUserShouldCreateAUser(){
        chatter.createUser("Emma", "@emmab");
        verify(userRepository).createUser("Emma", "@emmab");
    }

    @Test public void
    createUserShouldGreetUser(){
        chatter.createUser("Emma", "@emmab");
        verify(console).printLine("Welcome to Chatter, Emma");
    }

    @Test public void
    postMessageShouldCreatePost(){
        chatter.postMessage("This is my first post!");
        verify(userRepository).postMessage("This is my first post!");
    }

    @Test public void
    viewCurrentUserTimelineShowsPosts(){
        chatter.viewCurrentUserTimeline();
        verify(userRepository).printCurrentUserTimeline();
        verify(console).printLine("Messages:\n This is my first chatter post!");
    }


}