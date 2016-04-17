package Domain;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class Message {

    private final String messageBody;

    public Message(String text){
        this.messageBody = text;
    }

    public String messageBody(){
        return this.messageBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageBody != null ? messageBody.equals(message.messageBody) : message.messageBody == null;
    }

    @Override
    public int hashCode() {
        return messageBody != null ? messageBody.hashCode() : 0;
    }
}
