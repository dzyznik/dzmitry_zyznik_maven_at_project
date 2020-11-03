package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver webDriver;
    private static Config config;

    public void setConfig(Config config){
        Driver.config = config;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(Driver.config);
        }
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Driver.webDriver = webDriver;
    }





}
