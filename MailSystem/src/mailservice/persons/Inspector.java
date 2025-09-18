package mailservice.persons;

import Exceptions.IllegalPackageException;
import Exceptions.StolenPackageException;
import mailpackage.realmailpackage.MailPackage;
import mailservice.MailService;
import sendable.Sendable;

public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailProc = (MailPackage) mail;
            String mailContent = mailProc.getContent().getContent();
            if (mailContent.contains(WEAPONS) || mailContent.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            } else if (mailContent.contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}