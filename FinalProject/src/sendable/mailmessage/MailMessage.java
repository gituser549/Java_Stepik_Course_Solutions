package sendable.mailmessage;

import sendable.Sendable;

public class MailMessage implements Sendable<String> {
    private final String sender;
    private final String receiver;
    private final String message;

    public MailMessage(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    @Override
    public String getFrom() {
        return sender;
    }

    @Override
    public String getTo() {
        return receiver;
    }

    @Override
    public String getContent() {
        return message;
    }

    // implement here
}
