package Domain;

import java.util.List;

/**
 * Created by emmabaddeley on 17/04/2016.
 */
public class MessagePrinter {

    public String printTimeline(User user) {
        List<Message> messages = user.viewTimeline();
        String messageString = "";
        for( Message message : messages){
            messageString += message.messageBody() + "\n";
        }
     return messageString;
    }


}
