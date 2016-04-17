package Domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 17/04/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MessagePrinterTest {

    @Mock User user;
    @Mock User nikeshUser;
    @Mock Message message;
    private MessagePrinter messagePrinter;
    private List<Message> messages = new ArrayList<>();
    private List<User> subscriptions = new ArrayList<>();

    @Before
    public void initialize(){
        messagePrinter = new MessagePrinter();
        messages.add(message);
        subscriptions.add(nikeshUser);
    }

    @Test
    public void messagePrinterShouldTakeAUserAndFormatMessages(){
        when(user.viewTimeline()).thenReturn(messages);
        when(user.handle()).thenReturn("@nikesh");
        when(message.messageBody()).thenReturn("My first message");
        String printedMessages;
        printedMessages = messagePrinter.printTimeline(user);
        verify(user).viewTimeline();
        verify(message).messageBody();
        assertEquals("My first message - @nikesh\n", printedMessages);
    }

    @Test
    public void printAllSubscriptionsShouldTakeAUserAndPrintAllSubscriptions(){
        when(user.subscriptions()).thenReturn(subscriptions);
        when(nikeshUser.viewTimeline()).thenReturn(messages);
        when(nikeshUser.handle()).thenReturn("@nikesh");
        when(message.messageBody()).thenReturn("My first message");
        String subscriptionMessages = messagePrinter.printSubscriptions(user);
        verify(user).subscriptions();
        verify(nikeshUser).viewTimeline();
        assertEquals("My first message - @nikesh\n", subscriptionMessages);
    }


}