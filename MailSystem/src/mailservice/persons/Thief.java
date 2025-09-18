package mailservice.persons;

import mailpackage.realmailpackage.MailPackage;
import mailservice.MailService;
import sendable.Sendable;
import mailpackage.MailPackageContent;

public class Thief implements MailService {
    private int minValue;
    private int stolenValue;

    public Thief(int minValue) {
        this.minValue = minValue;
        this.stolenValue = 0;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailProc = (MailPackage) mail;
            if (mailProc.getContent().getPrice() >= minValue) {
                stolenValue += mailProc.getContent().getPrice();
                return new MailPackage(mailProc.getFrom(), mailProc.getTo(),
                        new MailPackageContent("stones instead of " + mailProc.getContent().getContent(),
                                0)
                );
            }
        }
        return mail;
    }
}
