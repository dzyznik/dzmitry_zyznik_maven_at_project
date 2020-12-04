package toolsQA.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextForm {

    private static final Logger LOGGER = Logger.getLogger(TestSteps.class);
    private static WebDriver driver = ThreadLocalDriver.getWebDriver();

    @Given("I go to Text Box")
    public void clickTextBox() {
        LOGGER.debug("Click on Text Box section");
        driver.findElement(By.xpath("//li[contains(.,'Text Box')]")).click();
    }

    @When("I provide Full Name")
    public void inputName() {
        LOGGER.debug("Send name to username field");
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Dzmitry Zyznik");
    }

    @When("I provide Email")
    public void inputEmail() {
        LOGGER.debug("Send email to userEmail field");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("dzmitryzyznik@spam4.me");
    }

    @When("I provide Current Address")
    public void inputCurrentAddress() {
        LOGGER.debug("Send address to Current Address field");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']"))
                .sendKeys("Minsk, Nemiha 40, 123");
    }

    @When("I provide Permanent Address")
    public void inputPermanentAddress() {
        LOGGER.debug("Send address to Permanent Address field");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']"))
                .sendKeys("Boston, Celtics 18, 5");

    }

    @When("I click Submit button")
    public void clickSubmit() throws InterruptedException {
        LOGGER.debug("Click submit button");

        WebElement element = driver.findElement(By.xpath("//div[@class = 'text-right col-md-2 col-sm-12' and contains(., 'Submit')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).clickAndHold().perform();
    }

    @Then("I verify that it submitted")
    public void verifySubmitted() {
        LOGGER.debug("Verifying that form submitted");

        WebDriverWait wait = new WebDriverWait(driver, 2);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='name']")));
        } catch (TimeoutException timeoutException) {

            try {
                boolean displayed = driver.findElement(By.xpath("//p[@id='name']")).isDisplayed();
                Assert.assertTrue(displayed);
            } catch (NoSuchElementException noSuchElementException) {
                Assert.fail();
            }
        }
    }
}
