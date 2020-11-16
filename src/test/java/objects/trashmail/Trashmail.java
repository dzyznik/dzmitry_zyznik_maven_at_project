package objects.trashmail;

import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class Trashmail {
    public void login() {
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

    public void addMail() {
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

    public void checkEnable() {
        try {

            WebElement enabled = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='  x-grid-row']/td[3]/div/span[@class='x-grid-checkcolumn x-grid-checkcolumn-checked']")));
        } catch (TimeoutException timeoutException) {
            WebElement disabled = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='  x-grid-row']/td[3]/div/span[@class='x-grid-checkcolumn']")));
            Actions actions = new Actions(ThreadLocalDriver.getWebDriver());
            actions.click(disabled)
                    .build()
                    .perform();
            WebElement remainingForwards = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='  x-grid-row']/td[8]/div")));
            actions.click(remainingForwards)
                    .keyDown(Keys.COMMAND)
                    .sendKeys("a")
                    .keyUp(Keys.COMMAND)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys("10")
                    .build()
                    .perform();
            WebElement save = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Save')]")));
            actions.click(save)
                    .build()
                    .perform();
        }
    }

    public void check() {
        try {

            WebElement mail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(.,'zyznikdzmitry') and @class='x-grid-cell-inner ']")));
            checkEnable();
            System.out.println("Mail already created");
            ThreadLocalDriver.getWebDriver().close();
            ThreadLocalDriver.setDriverNull();
        } catch (TimeoutException timeoutException) {
            addMail();
        }
    }


    public void openTrashMail() throws AWTException, InterruptedException {
        WebElement mail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(.,'zyznikdzmitry') and @class='x-grid-cell-inner ']")));
//        Robot robot = new Robot();
//        robot.mouseMove(95,282);
        WebElement logging = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//img[@data-qtip='Logging']"));
        Actions actions = new Actions(ThreadLocalDriver.getWebDriver());
        actions.moveToElement(logging);
        actions.perform();
        Thread.sleep(5000);
        logging.click();
        WebElement firstMail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fe-grid-logging-body']//table[1]")));
        actions.click(firstMail).build().perform();
        WebElement sendAgain = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Send again')]")));
        actions.click(sendAgain).build().perform();
        WebElement send = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog' and @data-componentid = 'fe-logging-send-mail']//a[contains(.,'Send')]")));
        actions.click(send).build().perform();
    }
}
