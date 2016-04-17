import Domain.ChatterApp;
import Domain.Console;
import Domain.MessagePrinter;
import Domain.UserRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emmabaddeley on 17/04/2016.
 */
public class ChatterInterface {

    private static UserRepository userRepository;
    private List<String> menu;
    private Console console;
    private MessagePrinter messagePrinter;
    private ChatterApp chatterApp;
    private BufferedReader reader;

    public ChatterInterface(){
        menu = new ArrayList<String>();
        menu.add("Post -  Create a Post");
        menu.add("View -  View Other Users");
        menu.add("Posts - View My Posts");
        menu.add("Subscribe - Subscribe to a User");
        menu.add("Subscriptions - View timeline of all Subscriptions");
        menu.add("Create - Create New User");
        menu.add("Quit - Quit");
    }

    private void initialize(){
        messagePrinter = new MessagePrinter();
        console = new Console();
        reader = new BufferedReader(new InputStreamReader(System.in));
        userRepository = new UserRepository(messagePrinter);
        chatterApp = new ChatterApp(userRepository, console);
    }


    private String promptAction() throws IOException {
        console.printLine("Welcome to Chatter, please choose an action");
        for (String menuItem : menu){
            console.printLine(menuItem);
        }
        console.printLine("What do you want to do?");
        String choice = reader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run(){
        initialize();
        String choice = "";
        do {
            try {
                choice = promptAction();
                switch (choice) {
                    case "post":
                        createPost();
                        break;
                    case "view":
                        viewUsers();
                        break;
                    case "posts":
                        viewPosts();
                        break;
                    case "subscribe":
                        subscribe();
                        break;
                    case "subscriptions":
                        viewSubscriptions();
                        break;
                    case "create":
                        createUser();
                        break;
                    case "quit":
                        console.printLine("Goodbye!");
                        break;
                    default:
                        console.printLine("Unknown Choice - try again");
                }

            } catch (IOException ioe) {
                console.printLine("Problem with Input");
                ioe.printStackTrace();
            }

        } while (!choice.equals("quit"));
    }

    private void createUser() throws IOException {
        console.printLine("Please enter a name");
        String name = reader.readLine().trim();
        console.printLine("Please enter a handle");
        String handle = reader.readLine().trim();
        chatterApp.createUser(name, handle);
    }

    private void viewSubscriptions() {
        chatterApp.viewSubscriptionsTimeline();
    }

    private void subscribe() throws IOException {
        console.printLine("Please enter the name of the user you want to subscribe to");
        String username = reader.readLine().trim();
        chatterApp.subscribe(username);
    }

    private void viewPosts() throws IOException {
        console.printLine("Please enter the name of the user you want to see the posts of");
        String username = reader.readLine().trim();
        chatterApp.viewTimeline(username);
    }

    private void viewUsers() {
        chatterApp.viewUsers();
    }

    private void createPost() throws IOException {
        console.printLine("Please enter the message you wish to post");
        String post = reader.readLine().trim();
        chatterApp.postMessage(post);
    }


}
