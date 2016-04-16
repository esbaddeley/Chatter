package Feature;

import Domain.ChatterApp;
import Domain.Console;
import Domain.UserRepository;
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

public class CreateUser {

    @Mock Console console;
    private ChatterApp chatter;
    private UserRepository userRepository;

    @Before
    public void initialise() {
        userRepository = new UserRepository();
        chatter = new ChatterApp(userRepository, console);
    }


    @Test
    public void
    createANewUser() {
        chatter.createUser("Emma", "@emmab");
        verify(console).printLine("Welcome to Chatter, Emma");
    }




}
