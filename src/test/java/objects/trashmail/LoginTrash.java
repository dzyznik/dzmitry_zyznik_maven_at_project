package objects.trashmail;

import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTrash {
    public void login(){
        ThreadLocalDriver.getWebDriver().get("https://trashmail.com/");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//ul[@id='tab-mob-create']/li[contains(.,'Address Manager')]")).click();
        WebElement username = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='ng-pristine ng-valid']/div[@class='form-group']/input[@type='text']")));
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//form[@class='ng-pristine ng-valid']/div[@class='form-group']/input[@type='text']"))
                .sendKeys("zyznikdzmitry");
        WebElement password = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tab-mob-manager']/form/div[contains(.,'Password')]/input")));
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@id='tab-mob-manager']/form/div[contains(.,'Password')]/input"))
                .sendKeys("Qq12345678");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@id='tab-mob-manager']/form/div[contains(.,'Sign in')]/button"))
                .click();
    }
}
