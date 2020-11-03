package day16;

import driver.Driver;
import driver.ThreadLocalDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingMoscow {
    @Test
    public void moscowTest() {
        ThreadLocalDriver.getWebDriver().get("https://www.booking.com");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//input[@type='search']")).sendKeys("Москва");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();
        WebElement firstResult = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3000)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotellist_inner']/div[10]")));
        WebElement Element = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@id='hotellist_inner']/div[10]"));
        JavascriptExecutor js = (JavascriptExecutor) ThreadLocalDriver.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", Element);
        js.executeScript("arguments[0].style.backgroundColor='green'",Element);
        js.executeScript("arguments[0].style.color='red'",Element);

        String style = Element.getAttribute("Style");
        if (style.equals("background-color: green; color: red;")){
            System.out.println("Test passed");
        }
        else System.out.println("Test failed");
        System.out.println(style);
        ThreadLocalDriver.getWebDriver().close();
        ThreadLocalDriver.setDriverNull();




    }
}
