package day16;

import driver.Driver;
import driver.ThreadLocalDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class W3Schools {
    @Test
    public void w3Test() {

        ThreadLocalDriver.getWebDriver().get("https://www.w3schools.com/java/");
        Actions actions = new Actions(ThreadLocalDriver.getWebDriver());
        WebElement tittleLocator = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//h1/span"));
        actions.doubleClick(tittleLocator)
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .build()
                .perform();
//        actions.doubleClick(tittleLocator)
//                .contextClick()
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ENTER)
//                .perform();
        ThreadLocalDriver.getWebDriver().get("https://www.google.com/");
        WebElement searchLocator = ThreadLocalDriver.getWebDriver().findElement(By.name("q"));
        actions.click(searchLocator)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
//        actions.click(searchLocator)
//                .contextClick()
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ARROW_DOWN)
//                .sendKeys(Keys.ENTER)
//                .sendKeys(Keys.ENTER)
//                .perform();


        //div[@class='g' and contains(.,'Tutorial')]
        ThreadLocalDriver.getWebDriver().close();
        ThreadLocalDriver.setDriverNull();

    }
}
