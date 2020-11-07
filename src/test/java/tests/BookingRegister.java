package tests;

import driver.ThreadLocalDriver;
import objects.PreconditionMail;
import objects.PreconditionOpenMail;
import objects.booking.Booking;
import objects.mailru.MailLink;
import objects.trashmail.LoginTrash;
import objects.trashmail.OpenMail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;


public class BookingRegister {
    @Before
    public void mailCheck() throws AWTException {
        PreconditionMail preconditionMail = new PreconditionMail();
        preconditionMail.newMail();
    }
    @Test
    public void registrationTest() throws AWTException {
        Booking booking = new Booking();
        booking.bookingSite();
        booking.registerButton();
        booking.emailInput();
        booking.passwordInput();
        booking.passwordConfirm();
        booking.personalization();
        ThreadLocalDriver.getWebDriver().close();
        ThreadLocalDriver.setDriverNull();


        LoginTrash loginTrash = new LoginTrash();
        loginTrash.login();
        OpenMail openMail = new OpenMail();
        openMail.openTrashMail();

        MailLink mailLink = new MailLink();
        mailLink.confirmLink();

        booking.bookingSite();
        booking.checkAcc();

    }


}
