package day16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo {
    public void main(String[] args) throws MalformedURLException {
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingPort(9515)
//                .build();
//        service.start();

//        WebDriver driver = new ChromeDriver();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());
        driver.get("https://tut.by");
        driver.close();
//        service.stop();
    }
}
