package objects;

import objects.trashmail.ExistMail;
import objects.trashmail.LoginTrash;
import objects.trashmail.OpenMail;
import org.junit.Test;

import java.awt.*;


public class PreconditionMail {
@Test
    public void newMail() throws AWTException {
        LoginTrash loginTrash = new LoginTrash();
        loginTrash.login();

        ExistMail existMail = new ExistMail();
        existMail.check();


    }
}
