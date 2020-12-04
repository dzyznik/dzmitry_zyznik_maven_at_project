package toolsQA.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {

    private static final Logger LOGGER = Logger.getLogger(BaseSteps.class);

    @Before
    public void doBefore(){
        LOGGER.info("Test started");
        ThreadLocalDriver.getWebDriver().get("https://demoqa.com/");

        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='category-cards']/div[1]")));
        LOGGER.debug("Click on Elements section");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class='category-cards']/div[1]")).click();
    }

    @After
    public void doAfter() {
        LOGGER.info("Test finished");
        ThreadLocalDriver.getWebDriver().close();
        ThreadLocalDriver.setDriverNull();
    }
}
