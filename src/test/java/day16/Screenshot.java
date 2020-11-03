package day16;

import driver.Driver;
import driver.ThreadLocalDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Screenshot {
    @Test
    public void screenshotTest() throws IOException {
        WebDriver driver = ThreadLocalDriver.getWebDriver();
        driver.get("https://www.tut.by");

        driver.findElement(By.xpath("//input[@id='myid']")).isDisplayed();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path original = scrFile.toPath();
        File copy = new File("/Users/Dzmitry_Zyznik/Desktop/www/screenshot.png");
        Path copied = copy.toPath();
        Files.copy(original, copied, StandardCopyOption.REPLACE_EXISTING);
        driver.close();
        ThreadLocalDriver.setDriverNull();
    }


}
