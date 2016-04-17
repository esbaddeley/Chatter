package Domain;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class ChatterApp {

    private final UserRepository userRepository;
    private  User currentUser;
    private final String WELCOME_MESSAGE = "\n\nWelcome to Chatter, ";
    private final String MESSAGES_HEADER = "\n\nMessages:\n";
    private final String USERS_HEADER = "\n\nUsers:\n";
    private Console console;

    public ChatterApp(UserRepository userRepository, Console console) {
        this.userRepository = userRepository;
        this.console = console;
    }

    public void createUser(String name, String handle) {
        userRepository.createUser(name, handle);
        console.printLine(WELCOME_MESSAGE + name );
    }

    public void postMessage(String text) {
        userRepository.postMessage(text);
    }

    public void viewTimeline(String username) {
        String messagesString = userRepository.printUserTimeline(username);
        console.printLine(MESSAGES_HEADER + messagesString);
    }

    public void subscribe(String username) {
        userRepository.subscribe(username);
    }

    public void viewSubscriptionsTimeline() {
        String subscriptionMessagesString = userRepository.printAllSubscriptions();
        console.printLine(MESSAGES_HEADER + subscriptionMessagesString);
    }

    public void viewUsers() {
        String users = userRepository.printAllUsers();
        console.printLine(USERS_HEADER + users);
    }
}