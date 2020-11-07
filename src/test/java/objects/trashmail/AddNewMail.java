package objects.trashmail;

import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewMail {
    public void addMail (){
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//a[@id='fe-add']/span"))
                .click();
        WebElement mail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-columnid='fe-col-disposable-name']/div[@class='x-grid-cell-inner ']")));
        Actions actions = new Actions(ThreadLocalDriver.getWebDriver());
        actions.click(mail)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("zyznikdzmitry")
                .build()
                .perform();
        WebElement host = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@role='row']/td[5]/div")));
        actions.click(host)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("trashmail.com")
                .build()
                .perform();
        WebElement save = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Save')]")));
        actions.click(save)
                .build()
                .perform();
        System.out.println("Mail was created");
        ThreadLocalDriver.getWebDriver().close();
        ThreadLocalDriver.setDriverNull();
    }
}
