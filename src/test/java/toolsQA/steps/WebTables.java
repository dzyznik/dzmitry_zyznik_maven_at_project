package toolsQA.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class WebTables {

    private static final Logger LOGGER = Logger.getLogger(TestSteps.class);
    private static WebDriver driver = ThreadLocalDriver.getWebDriver();

    String firstName = "Dzmitry";
    String lastName = "Zyznik";
    String email = "blbl@mail.ru";
    String age = "25";
    String salary = "123000";
    String department = "QA";


    @Given("I go to Web table")
    public void clickWebTables() {
        LOGGER.debug("Click on Web Tables section");
        driver.findElement(By.xpath("//li[contains(.,'Web Tables')]")).click();
    }

    @When("I click edit button")
    public void clickEdit() {
        LOGGER.debug("Click on Edit icon");
        driver.findElement(By.xpath("//div[@role = 'rowgroup' and contains(.,'Alden')]//span[@title='Edit']"))
                .click();

    }

    @When("I edit First Name")
    public void editFirstName() {
        LOGGER.debug("Edit first name");

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
    }

    @When("I edit Last Name")
    public void editLastName() {
        LOGGER.debug("Edit last name");

        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
    }

    @When("I edit Email")
    public void editEmail() {
        LOGGER.debug("Edit email");

        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys(email);
    }

    @When("I edit Age")
    public void editAge() {
        LOGGER.debug("Edit age");

        driver.findElement(By.xpath("//input[@placeholder='Age']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys(age);
    }

    @When("I edit Salary")
    public void editSalary() {
        LOGGER.debug("Edit salary");

        driver.findElement(By.xpath("//input[@placeholder='Salary']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Salary']")).sendKeys(salary);
    }

    @When("I edit Department")
    public void editDepartment() {
        LOGGER.debug("Edit department");

        driver.findElement(By.xpath("//input[@placeholder='Department']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Department']")).sendKeys(department);
        driver.findElement(By.xpath("//input[@placeholder='Department']")).submit();
    }

    @Then("I verify changes")
    public void verifyChanges(){
        LOGGER.debug("Verify changes");

        String actualFirstName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[1]")).getText();
        String actualLastName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[2]")).getText();
        String actualAge = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[3]")).getText();
        String actualEmail = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[4]")).getText();
        String actualSalary = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[5]")).getText();
        String actualDepartment = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[6]")).getText();

        Assert.assertEquals(actualFirstName,firstName);
        Assert.assertEquals(actualLastName,lastName);
        Assert.assertEquals(actualAge,age);
        Assert.assertEquals(actualEmail,email);
        Assert.assertEquals(actualSalary,salary);
        Assert.assertEquals(actualDepartment,department);

    }









}
