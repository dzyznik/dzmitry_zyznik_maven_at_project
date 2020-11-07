package objects.trashmail;

import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class OpenMail {
    public void openTrashMail() throws AWTException {
        WebElement mail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(.,'zyznikdzmitry') and @class='x-grid-cell-inner ']")));
        Robot robot = new Robot();
        robot.mouseMove(95,282);
        WebElement logging = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@data-qtip='Logging']")));
        Actions actions = new Actions(ThreadLocalDriver.getWebDriver());
        actions.moveToElement(logging).build().perform();
        actions.click(logging).build().perform();
        WebElement firstMail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fe-grid-logging-body']//table[1]")));
        actions.click(firstMail).build().perform();
        WebElement sendAgain = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Send again')]")));
        actions.click(sendAgain).build().perform();
        WebElement send = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='button-1083']")));
        actions.click(send).build().perform();





    }
}
