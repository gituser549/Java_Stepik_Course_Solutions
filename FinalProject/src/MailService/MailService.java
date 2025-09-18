package MailService;

import SafetyTreeMap.SafetyTreeMap;
import sendable.Sendable;

import java.util.List;
import java.util.TreeMap;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    SafetyTreeMap<T> mailsByReceiver;

    public TreeMap<String, List<T>> getMailBox() {
        return mailsByReceiver;
    }

    @Override
    public void accept(Sendable t) {
        mailsByReceiver.get(t.getTo()).add((T) t.getContent());
    }

    public MailService() {
        mailsByReceiver = new SafetyTreeMap<T>();
    };
}