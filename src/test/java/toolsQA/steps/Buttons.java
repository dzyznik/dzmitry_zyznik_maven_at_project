package toolsQA.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Buttons {
    private static final Logger LOGGER = Logger.getLogger(TestSteps.class);
    private static WebDriver driver = ThreadLocalDriver.getWebDriver();
    Actions actions = new Actions(driver);


    @Given("I go to Buttons")
    public void clickButtons() {
        LOGGER.debug("Click on Buttons section");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//li[contains(.,'Buttons')]")).click();
    }

    @When("I double click button")
    public void doubleClickButton() throws InterruptedException {
        LOGGER.debug("Double click button");
        Thread.sleep(1000);
        WebElement doubleButton = driver.findElement(By.xpath("//div/button[@id='doubleClickBtn']"));
        actions.moveToElement(doubleButton).doubleClick(doubleButton).build().perform();
//        actions.doubleClick().build().perform();
    }

    @When("I right click button")
    public void rightClickButton() {
        LOGGER.debug("Right click button");
        WebElement rightButton = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));

        actions.contextClick(rightButton).build().perform();
    }

    @When("I just click button")
    public void justClickButton() {
        LOGGER.debug("Just click button");
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
    }

    @Then("I verify all buttons were clicked")
    public void verifyButtonsClicked() {
        LOGGER.debug("Verify buttons were clicked");

        Boolean doubleButton = driver
                .findElement(By.xpath("//p[contains(.,'You have done a double click')]")).isDisplayed();

        Boolean rightButton = driver
                .findElement(By.xpath("//p[contains(.,'You have done a right click')]")).isDisplayed();

        Boolean justButton = driver
                .findElement(By.xpath("//p[contains(.,'You have done a dynamic click')]")).isDisplayed();

        Assert.assertTrue(doubleButton);
        Assert.assertTrue(rightButton);
        Assert.assertTrue(justButton);
    }

}
