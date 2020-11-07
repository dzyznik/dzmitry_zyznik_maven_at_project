package objects.trashmail;

import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Enable {
    public void checkEnable(){
        try {

            WebElement enabled = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='  x-grid-row']/td[3]/div/span[@class='x-grid-checkcolumn x-grid-checkcolumn-checked']")));
        }
        catch (TimeoutException timeoutException){
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
}
