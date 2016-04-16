package Domain;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class ChatterApp {

    private final UserRepository userRepository;
    private  User currentUser;
    private final String WELCOME_MESSAGE = "Welcome to Chatter, ";
    private Console console;

    public ChatterApp(UserRepository userRepository, Console console) {
        this.userRepository = userRepository;
        this.console = console;
    }

    public void createUser(String name, String handle) {
        userRepository.createUser(name, handle);
        console.printLine(WELCOME_MESSAGE + name );
    }



}