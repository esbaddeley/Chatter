package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class UserRepository {
    private final MessagePrinter messagePrinter;
    private List<User> users;
    private User currentUser;

    public UserRepository(MessagePrinter messagePrinter){
        this.users = new ArrayList<User>();
        this.currentUser = null;
        this.messagePrinter = messagePrinter;
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

    public void changeCurrentUser(User user){
        currentUser = user;
    }

    public void postMessage(String text) {
        currentUser.postMessage(text);

    }

    public String printCurrentUserTimeline(){
        return messagePrinter.printTimeline(currentUser);
    }



}
