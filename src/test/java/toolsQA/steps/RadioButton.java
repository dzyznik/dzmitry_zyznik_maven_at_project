package toolsQA.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {
    private static final Logger LOGGER = Logger.getLogger(TestSteps.class);
    private static WebDriver driver = ThreadLocalDriver.getWebDriver();

    @Given("I go to Radio Buttons")
    public void clickRadioButton() {
        LOGGER.debug("Click on Radio Button section");
        driver.findElement(By.xpath("//li[contains(.,'Radio Button')]")).click();
    }

    @When("I select yes Radio Button")
    public void clickYesRadioButton() {
        LOGGER.debug("Click on Yes Radio Button");
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
    }

    @Then("I verify selected Radio Button")
    public void verifySelected() {
        LOGGER.debug("Verify selected button");
        Boolean selected = driver.findElement(By.xpath("//p[contains(.,'You have selected')]")).isDisplayed();

        Assert.assertTrue(selected);
    }





}
