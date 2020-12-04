package mobile.driver;

import driver.Config;
import driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {

    public static AndroidDriver<MobileElement> driver;

    public static AndroidDriver getWebDriver(DesiredCapabilities caps) throws MalformedURLException {
        if (driver == null) {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);;
        }
        return driver;
    }

    public static void quitDriver (){
        driver.quit();
    }
}
