package day19.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class FakeBaseSteps {

    @Before
    public void doBefore(){
        System.out.println("Init WebDriver");
        ThreadLocalDriver.getWebDriver();
    }

    @After
    public void doAfter(){
        ThreadLocalDriver.getWebDriver().close();
        ThreadLocalDriver.setDriverNull();
    }

}
