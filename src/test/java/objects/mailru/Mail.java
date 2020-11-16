package objects.mailru;

import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mail {

    public void openMail(){
        ThreadLocalDriver.getWebDriver().get("https://mail.ru/");
    }
    public void login() {
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//input[@id='mailbox:login-input']")).sendKeys("m.z1995");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//input[@type='submit']")).click();
        WebElement password = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='mailbox:password-input']")));
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//input[@id='mailbox:password-input']")).sendKeys("bostonceltics");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//input[@type='submit']")).click();
    }

    public void findMail(){
        WebElement Result = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dataset__items']/a[1]")));
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class='dataset__items']/a[1]")).click();
    }

    public void confirmLink(){
        WebElement confirmButton = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='button-inner_mr_css_attr']")));
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//td[@class='button-inner_mr_css_attr']")).click();
    }
}
