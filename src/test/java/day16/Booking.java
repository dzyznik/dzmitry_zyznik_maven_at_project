package day16;

import driver.Driver;
import driver.ThreadLocalDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BasedTests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Booking {
    @Test
    public  void bookingTest() {
        ThreadLocalDriver.getWebDriver().get("https://www.booking.com");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//input[@type='search']")).sendKeys("Paris");
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@data-mode='checkin']")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//span[@aria-label = '1 November 2020']")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//span[@aria-label = '8 November 2020']")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//span[@class = 'xp__guests__count']")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class='sb-group__field sb-group__field-adults']/div/div[2]/button[2]")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class='sb-group__field sb-group__field-adults']/div/div[2]/button[2]")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class='sb-group__field sb-group__field-rooms']/div/div[2]/button[2]")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//li[@class = ' sort_category   sort_price ']")).click();
        WebElement firstResult = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3000)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-id = 'pri-5']/label")));
        String priceMax = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//a[@data-id = 'pri-5']/label")).getText();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//a[@data-id = 'pri-5']/label")).click();
        WebElement secondResult = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3000)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotellist_inner']/div[contains(., data-et-view)][1]//span[contains(.,'Price')]")));
        String priceHotel = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@id='hotellist_inner']/div[contains(., data-et-view)][1]//span[contains(.,'Price')]")).getText();
        String[] str = priceHotel.split("\\D");
        String prH = "";
        for (String s : str) {
            if (s.length() > 0) {
                prH = prH.concat(s);
            }
        }
        int priceH = Integer.parseInt(prH);


        List <String> strMax = Arrays.stream(priceMax.split("\\D")).filter(s -> s.length() > 0).collect(Collectors.toList());
        String prMax = "";
        for (int i = 0; i < 2; i++) {
            prMax = prMax.concat(strMax.get(i));
        }

        int priceM = Integer.parseInt(prMax);

        if (priceH/7 >= priceM){
            System.out.println("Test passed");
        }
        else System.out.println("Test failed");

        ThreadLocalDriver.getWebDriver().close();


//


    }
}
