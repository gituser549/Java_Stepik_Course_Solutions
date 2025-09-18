package mailservice.persons;

import mailservice.MailService;
import mailservice.realmailservice.RealMailService;
import sendable.Sendable;

public class UntrustworthyMailWorker implements MailService {
    private MailService[] agents;
    private final RealMailService currentRealMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] services) {
        this.agents = services;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (int i = 0; i < agents.length; i++) {
            mail = agents[i].processMail(mail);
        }
        mail = currentRealMailService.processMail(mail);
        return mail;
    }

    public RealMailService getRealMailService() {
        return currentRealMailService;
    }
}