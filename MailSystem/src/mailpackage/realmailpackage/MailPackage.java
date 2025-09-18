package mailpackage.realmailpackage;

import mailpackage.MailPackageContent;
import sendable.AbstractSendable;

public class MailPackage extends AbstractSendable {
    private final MailPackageContent content;

    public MailPackage(String from, String to, MailPackageContent content) {
        super(from, to);
        this.content = content;
    }

    public MailPackageContent getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailPackage that = (MailPackage) o;

        if (!content.equals(that.content)) return false;

        return true;
    }

}