package Domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class ChatterAppTest {

    private  ChatterApp chatter;
    @Mock UserRepository userRepository;

    @Before
    public void initialize(){
        chatter = new ChatterApp();
    }

    @Test
    public void createUserShouldCreateAUser(){
        chatter.createUser("Emma");
        verify(userRepository).createUser("Emma");
    }


}