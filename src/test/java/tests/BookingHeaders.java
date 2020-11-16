package tests;

import objects.booking.Booking;
import org.junit.Test;

public class BookingHeaders {
    @Test
    public void bookingHeadersTest() {
        Booking booking = new Booking();
        booking.bookingSite();
        booking.login();
        booking.findH1();
//        booking.findH2();

    }
}
