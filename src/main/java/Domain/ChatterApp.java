package Domain;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class ChatterApp {

    private final UserRepository userRepository;
    private  User currentUser;

    public ChatterApp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name) {
        userRepository.createUser(name);
    }



}