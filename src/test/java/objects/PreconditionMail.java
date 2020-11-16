package objects;

import driver.ThreadLocalDriver;
import objects.trashmail.Trashmail;
import org.junit.Test;


public class PreconditionMail {
@Test
    public void newMail() {
    Trashmail trashmail = new Trashmail();
    trashmail.login();
    trashmail.check();
    ThreadLocalDriver.getWebDriver().close();
    ThreadLocalDriver.setDriverNull();
    }
}
