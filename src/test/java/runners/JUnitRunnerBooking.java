package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BookingMadrid;
import tests.BookingRegister;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingRegister.class, BookingMadrid.class})
public class JUnitRunnerBooking {

}
