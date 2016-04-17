package Domain;

import java.util.List;

/**
 * Created by emmabaddeley on 17/04/2016.
 */
public class MessagePrinter {

    private final String MESSAGE_SEPARATOR = " - ";

    public String printTimeline(User user) {
        List<Message> messages = user.viewTimeline();
        String messageString = "";
        for( Message message : messages){
            messageString += formattedMessage(message, user);
        }
     return messageString;
    }

    private String formattedMessage(Message message, User user){
        return message.messageBody()
                + MESSAGE_SEPARATOR
                + user.handle()
                + "\n";
    }


    public String printSubscriptions(User user) {
        List<User> subscriptions = user.subscriptions();
        String subscriptionMessageString = "";
        for ( User subscribedUser : subscriptions){
            subscriptionMessageString += printTimeline(subscribedUser);
        }
      return subscriptionMessageString;
    }
}
