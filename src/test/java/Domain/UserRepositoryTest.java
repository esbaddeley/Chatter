package Domain;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by emmabaddeley on 16/04/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {
    private UserRepository userRepository;
    @Mock User user;
    @Mock MessagePrinter messagePrinter;


    @Before
    public void initialize()  {
        userRepository = new UserRepository(messagePrinter);
    }

    @Test
    public void creatingANewUser(){
        userRepository.createUser("Emma", "@emmab");
        List<User> users = userRepository.allUsers();
        assertEquals(1, users.size());
        assertThat(users.get(0), is(createUser("Emma", "@emmab")));
    }


    @Test
    public void settingTheCurrentUser(){
       userRepository.createUser("Tom", "@toma");
        User currentUser = userRepository.currentUser();
        assertThat(currentUser, is(createUser("Tom", "@toma")));
    }

    @Test
    public void postingAMessage(){
        userRepository.createUser("Tom", "@toma");
        userRepository.changeCurrentUser(user);
        userRepository.postMessage("This is my first Post");
        verify(user).postMessage("This is my first Post");
    }

    @Test
    public void viewUserTimelinePrintReturnsFormattedString(){
        when(messagePrinter.printTimeline(user)).thenReturn("This is my first Post");
        userRepository.changeCurrentUser(user);
        String messages = userRepository.printCurrentUserTimeline();
        verify(messagePrinter).printTimeline(user);
        assertThat(messages, is("This is my first Post"));
    }

    private User createUser(String name, String handle) {
        return new User(name, handle);
    }

}