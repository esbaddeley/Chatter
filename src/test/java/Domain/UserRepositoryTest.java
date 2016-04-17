package Domain;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;


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
        Map<String, User> users = userRepository.allUsers();
        assertEquals(1, users.size());
        assertThat(users.get("Emma"), is(createUser("Emma", "@emmab")));
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
    public void viewUserTimelineReturnsFormattedString(){
        userRepository.createUser("Nikesh", "@nikesh");
        User nikeshUser = userRepository.currentUser();
        userRepository.printUserTimeline("Nikesh");
        verify(messagePrinter).printTimeline(nikeshUser);
    }

    @Test
    public void subscribeToUserAddsUserToSubscriptions(){
        userRepository.createUser("Nikesh", "@nikesh");
        User nikeshUser = userRepository.currentUser();
        userRepository.changeCurrentUser(user);
        userRepository.subscribe("Nikesh");
        verify(user).subscribe(nikeshUser);
    }

    @Test
    public void printSubscriptionsPrintsAllMessagesOfSubscribedUsers(){
        userRepository.createUser("Nikesh", "@nikesh");
        User nikeshUser = userRepository.currentUser();
        userRepository.printAllSubscriptions();
        verify(messagePrinter).printSubscriptions(nikeshUser);
    }

    private User createUser(String name, String handle) {
        return new User(name, handle);
    }


}