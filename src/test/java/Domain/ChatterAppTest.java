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

    @Before
    public void initialize(){
        chatter = new ChatterApp(userRepository);
    }

    @Test public void
    createUserShouldCreateAUser(){
        chatter.createUser("Emma");
        verify(userRepository).createUser("Emma");
    }


}