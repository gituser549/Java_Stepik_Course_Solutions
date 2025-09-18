package mailservice.persons;

import mailservice.MailService;
import sendable.Sendable;
import sendable.mailmessage.MailMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private Logger mailMsgLog;
    public Spy(Logger logger) {
        this.mailMsgLog = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            MailMessage mailProc = (MailMessage) mail;
            if (mailProc.getFrom().equals(AUSTIN_POWERS) || mailProc.getTo().equals(AUSTIN_POWERS)) {
                mailMsgLog.log(Level.WARNING,
                        "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[] {mailProc.getFrom(), mailProc.getTo(), mailProc.getMessage()} );
            } else {
                mailMsgLog.log(Level.INFO,
                        "Usual correspondence: from {0} to {1}",
                        new Object[] {mailProc.getFrom(), mailProc.getTo() });
            }
        }
        return mail;
    }
}
