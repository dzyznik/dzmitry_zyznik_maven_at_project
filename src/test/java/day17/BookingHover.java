package day17;

import driver.Driver;
import driver.ThreadLocalDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingHover {
    @Test
    public void testHover() {
        WebDriver driver = ThreadLocalDriver.getWebDriver();
        driver.get("https://www.booking.com");
        WebElement firstResult = new WebDriverWait(driver, 3000)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@*[contains(., 'Choose your currency')]]/..")));
        WebElement element = driver.findElement(By.xpath("//*[@*[contains(., 'Choose your currency')]]/.."));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        String currency = driver.findElement(By.xpath("//div[@class[contains(., 'content')] and contains(., 'Choose your currency')]")).getText();
        if (currency.length() < 1){
            currency = driver.findElement(By.xpath("//div[@class[contains(., 'content')] and contains(., 'Choose your currency')]/div")).getText();
            System.out.println(currency);
        }
        else System.out.println(currency);

        if (currency.equals("Choose your currency")){
            System.out.println("Test passed");
        }
        else System.out.println("Test failed");

        driver.close();
        ThreadLocalDriver.setDriverNull();

    }
}
