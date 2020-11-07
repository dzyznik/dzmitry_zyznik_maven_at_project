package driver;

import org.openqa.selenium.WebDriver;

public class ThreadLocalDriver {

    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            webDriver.set(DriverManager.getDriver(Config.CHROME));
        }
        return webDriver.get();
    }

    public static void setDriverNull (){
        webDriver.set(null);
    }
}
