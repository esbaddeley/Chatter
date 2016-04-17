package Domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class UserRepository {
    private final MessagePrinter messagePrinter;
    private Map<String,User> users;
    private User currentUser;
    private Map<String, User> subscriptions;

    public UserRepository(MessagePrinter messagePrinter){
        this.users = new HashMap<>();
        this.currentUser = null;
        this.messagePrinter = messagePrinter;
        this.subscriptions = new HashMap<>();
    }

    public void createUser(String name, String handle) {
        User newUser = new User(name, handle);
        users.put(name, newUser);
        currentUser = newUser;
    }

    public Map<String, User> allUsers() {
        return Collections.unmodifiableMap (users);
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

    public String printUserTimeline(String username) {
        User user = users.get(username);
        return messagePrinter.printTimeline(user);
    }

    public void subscribe(String username) {
        User user = users.get(username);
        currentUser.subscribe(user);
    }

    public String printAllSubscriptions() {
        return messagePrinter.printSubscriptions(currentUser);
    }

    public String printAllUsers() {
        String usersString = "";
        for (String username : users.keySet()){
            usersString += username + "\n";
        }
        return usersString;
    }
}
