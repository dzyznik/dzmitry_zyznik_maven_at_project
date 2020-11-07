package runners;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;

public class BookingTestNgXmlSuite {
    public static void main(String[] args) throws IOException {
        final TestNG testNG = new TestNG(true);
        final Parser parser = new Parser("/Users/Dzmitry_Zyznik/Desktop/Maven/src/test/resources/testng.xml");
        final List <XmlSuite> suites = parser.parseToList();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
