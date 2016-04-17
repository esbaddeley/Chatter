package Domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    viewTargetUserTimeline(){
        when(userRepository.printUserTimeline("Nikesh")).thenReturn("This is my first chatter post! - @nikesh");
        chatter.viewTimeline("Nikesh");
        verify(userRepository).printUserTimeline("Nikesh");
        verify(console).printLine("Messages:\nThis is my first chatter post! - @nikesh");
    }

    @Test public void
    subscribeToTargetUser(){
        chatter.subscribe("Nikesh");
        verify(userRepository).subscribe("Nikesh");
    }

    @Test public void
    viewAllSubscriptionsTimeline(){
        when(userRepository.printAllSubscriptions()).thenReturn("This is my first chatter post! - @nikesh\nThis is a post from leo - @leo\n");
        chatter.viewSubscriptionsTimeline();
        verify(userRepository).printAllSubscriptions();
        verify(console).printLine("Messages:\nThis is my first chatter post! - @nikesh\nThis is a post from leo - @leo\n");
    }



}