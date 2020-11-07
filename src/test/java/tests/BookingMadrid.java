package tests;

import objects.booking.Booking;
import org.testng.annotations.Test;


public class BookingMadrid {
    @Test
    public void bookMadridTest(){
        Booking booking = new Booking();
        booking.bookingSite();
        booking.login();
        booking.searchMadrid();
        booking.likeHotels();
        booking.checkWishList();








    }

}
