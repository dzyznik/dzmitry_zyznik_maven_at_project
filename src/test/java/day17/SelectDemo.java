package day17;

import driver.Driver;
import driver.ThreadLocalDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {
    @Test
    public void testSelect() {
        WebDriver driver = ThreadLocalDriver.getWebDriver();
        driver.get("https://www.demoqa.com/select-menu");

        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
//        select.selectByValue("6");
        select.selectByVisibleText("Blue");
//        select.deselectAll();
//        select.getOptions();
        driver.close();
        ThreadLocalDriver.setDriverNull();

    }
}
