package runner;

import day15.DemoRunner;
import day16.Booking;
import day16.BookingMoscow;
import day16.Screenshot;
import day16.W3Schools;
import day17.BookingDemo;
import day17.BookingHover;
import day17.SelectDemo;
import driver.ThreadLocalDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({BookingDemo.class})
public class JUnitRunner {
static {
    globalBefore();
}

public static void globalBefore() {
    ThreadLocalDriver.getWebDriver().get("https://booking.com");
}

}
