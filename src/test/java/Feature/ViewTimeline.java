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
public class ViewTimeline {

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

    @Test
    public void userCanViewOtherUserTimeline(){
        chatter.createUser("Nikesh", "@nikesh");
        chatter.postMessage("This is my first chatter post!");
        chatter.createUser("Spike", "@spike");
        chatter.viewTimeline("Nikesh");
        verify(console).printLine("Welcome to Chatter, Nikesh");
        verify(console).printLine("Welcome to Chatter, Nikesh");
        verify(console).printLine("Messages:\nThis is my first chatter post!\n");
    }

}
