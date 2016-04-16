package Domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class UserRepositoryTest {
    private UserRepository userRepository;
    @Mock User user;


    @Before
    public void initialize()  {
        userRepository = new UserRepository();
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


    private User createUser(String name, String handle) {
        return new User(name, handle);
    }

}