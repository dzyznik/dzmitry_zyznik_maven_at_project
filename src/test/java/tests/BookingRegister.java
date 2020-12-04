//package tests;
//
//import driver.ThreadLocalDriver;
//import objects.PreconditionMail;
//import objects.booking.Booking;
//import objects.mailru.Mail;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.awt.*;
//
//
//public class BookingRegister {
//    @BeforeClass
//    public void mailCheck() {
//        PreconditionMail preconditionMail = new PreconditionMail();
//        preconditionMail.newMail();
//    }
//
//    @Test
//    public void registrationTest() throws InterruptedException {
//        Booking booking = new Booking();
//        booking.bookingSite();
//        booking.registerButton();
//        booking.emailInput();
//        booking.passwordInput();
//        booking.passwordConfirm();
//        booking.personalization();
//        ThreadLocalDriver.getWebDriver().close();
//        ThreadLocalDriver.setDriverNull();
//        Mail mail = new Mail();
//        mail.openMail();
//        mail.login();
//        mail.findMail();
//        mail.confirmLink();
//        ThreadLocalDriver.getWebDriver().close();
//        ThreadLocalDriver.setDriverNull();
//        booking.bookingSite();
//        booking.login();
//        booking.checkAcc();
//
//
//    }
//
//
//}
