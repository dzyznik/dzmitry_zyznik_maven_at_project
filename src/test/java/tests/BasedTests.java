package tests;

import driver.ThreadLocalDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BasedTests {
    @Before
    public void initDriver(){
        WebDriver driver = ThreadLocalDriver.getWebDriver();
    }

    @After
    public void closeDriver(){
        ThreadLocalDriver.setDriverNull();
    }
}
