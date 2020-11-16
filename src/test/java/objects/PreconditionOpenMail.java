package objects;


import objects.mailru.Mail;
import org.junit.Test;

public class PreconditionOpenMail {
@Test
    public void openMail()  {
    Mail mail = new Mail();
    mail.openMail();
    mail.login();
    mail.findMail();
    mail.confirmLink();

    }
}
