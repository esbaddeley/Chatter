package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class UserRepository {
    private List<User> users;
    private User currentUser;

    public UserRepository(){
        this.users = new ArrayList<User>();
        this.currentUser = null;
    }

    public void createUser(String name, String handle) {
        User newUser = new User(name, handle);
        users.add(newUser);
        currentUser = newUser;
    }

    public List<User> allUsers() {
        return Collections.unmodifiableList (users);
    }

    public User currentUser() {
        return currentUser;
    }
}
