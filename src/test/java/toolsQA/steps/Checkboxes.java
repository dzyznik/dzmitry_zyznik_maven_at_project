package toolsQA.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkboxes {
    private static final Logger LOGGER = Logger.getLogger(TestSteps.class);
    private static WebDriver driver = ThreadLocalDriver.getWebDriver();

    @Given("I go to Checkbox")
    public void clickCheckBox() {
        LOGGER.debug("Click on Check Box section");
        driver.findElement(By.xpath("//li[contains(.,'Check Box')]")).click();
    }

    @When("I expand all folders")
    public void expandAll(){
        LOGGER.debug("Collapse all folders");
        driver.findElement(By.xpath("//button[@title='Expand all']")).click();
    }

    @Then("I check 2 flags")
    public void checkFlags(){
        LOGGER.debug("Check 2 flags from different levels");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='tree-node-react']/span[@class='rct-checkbox']")));
        driver.findElement(By.xpath("//label[@for='tree-node-react']/span[@class='rct-checkbox']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='tree-node-notes']/span[@class='rct-checkbox']")));
        driver.findElement(By.xpath("//label[@for='tree-node-notes']/span[@class='rct-checkbox']")).click();
    }

    @Then("I verify marked checkboxes")
    public void verifyFlags(){
        LOGGER.debug("Verify 2 flags from different levels");
        Boolean firstFlag = driver
                .findElement(By.xpath("//label[@for='tree-node-react']/span[@class='rct-checkbox']/*[name()='svg' and @class='rct-icon rct-icon-check']"))
                .isDisplayed();
        Boolean secondFlag = driver
                .findElement(By.xpath("//label[@for='tree-node-notes']/span[@class='rct-checkbox']/*[name()='svg' and @class='rct-icon rct-icon-check']"))
                .isDisplayed();
        Assert.assertTrue(firstFlag);
        Assert.assertTrue(secondFlag);
    }

}
