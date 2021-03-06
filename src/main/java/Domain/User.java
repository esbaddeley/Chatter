package Domain;


import java.util.*;

/**
 * Created by emmabaddeley on 14/04/2016.
 */
public class User {


    private final String name;
    private final String handle;
    private final List<Message> messages = new ArrayList<Message>();
    private final List< User> subscriptions = new ArrayList<>();


    public User(String name, String handle) {
        this.name = name;
        this.handle = handle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return handle != null ? handle.equals(user.handle) : user.handle == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (handle != null ? handle.hashCode() : 0);
        return result;
    }

    public String handle(){
        return handle;
    }

    public List<Message> viewTimeline() {
        return messages;
    }

    public void postMessage(String text) {
        Message message = new Message(text);
        messages.add(message);
    }

    public String username() {
        return name;
    }

    public void subscribe(User user) {
        subscriptions.add(user);
    }

    public List<User> subscriptions() {
        return Collections.unmodifiableList(subscriptions);
    }

}