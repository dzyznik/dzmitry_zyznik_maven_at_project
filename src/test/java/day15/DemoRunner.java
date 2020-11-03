package day15;

import driver.Driver;
import driver.ThreadLocalDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DemoRunner {
    @Test
    public void weatherTest() {

//        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        ThreadLocalDriver.getWebDriver().get("https://www.google.com");
        ThreadLocalDriver.getWebDriver().findElement(By.name("q")).sendKeys("погода Минск");
        ThreadLocalDriver.getWebDriver().findElement(By.name("q")).submit();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//a[@href='https://www.gismeteo.by/weather-minsk-4248/']")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//a[@title = 'Погода в Минске на завтра']")).click();
        WebElement firstResult = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 10000)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='chart chart__temperature']/div/div[5]")));
        String temperature = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class='chart chart__temperature']/div/div[5]")).getText();
        System.out.println(temperature);
        ThreadLocalDriver.getWebDriver().close();
        Driver.setWebDriver(null);

    }
}
