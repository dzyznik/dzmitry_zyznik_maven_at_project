package objects;

import objects.mailru.MailLink;
import objects.trashmail.LoginTrash;
import objects.trashmail.OpenMail;
import org.junit.Test;

import java.awt.*;

public class PreconditionOpenMail {

    public void openMail() throws AWTException {
        LoginTrash loginTrash = new LoginTrash();
        loginTrash.login();

        OpenMail openMail = new OpenMail();
        openMail.openTrashMail();



    }
}
