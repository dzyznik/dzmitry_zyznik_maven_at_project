package day19.steps;

import driver.ThreadLocalDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FakeGuiSteps {


    @Given("I go to TUT.BY")
    public void goToUrlStep() {
//        ThreadLocalDriver.getWebDriver().get("https://tut.by");
    }

    @When("I start waiting")
    public void iWaitStep() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Then("I just passed")
    public void justPassStep(){
        Assert.assertTrue(true);
    }

    @Then("I just failed")
    public void justFailedStep(){
        Assert.fail();
    }
}
