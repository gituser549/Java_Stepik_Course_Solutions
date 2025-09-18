package sendable.salary;

import sendable.Sendable;

public class Salary implements Sendable<Integer> {
    private final String sender;
    private final String receiver;
    private final Integer amount;

    public Salary(String sender, String receiver, Integer amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
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
    public Integer getContent() {
        return amount;
    }
}