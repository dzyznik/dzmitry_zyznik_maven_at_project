package objects.trashmail;

import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExistMail {
    public void check(){
        try {

            WebElement mail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(.,'zyznikdzmitry') and @class='x-grid-cell-inner ']")));
            Enable enable = new Enable();
            enable.checkEnable();
            System.out.println("Mail already created");
            ThreadLocalDriver.getWebDriver().close();
            ThreadLocalDriver.setDriverNull();
        }
        catch (TimeoutException timeoutException){
            AddNewMail addNewMail = new AddNewMail();
            addNewMail.addMail();
        }
    }

}
