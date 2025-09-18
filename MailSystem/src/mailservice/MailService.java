package mailservice;

import sendable.Sendable;

public interface MailService {
    Sendable processMail(Sendable mail);
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
}

