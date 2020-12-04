package mobile.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mobile.objects.clock.GoogleClockApp;
import mobile.objects.clock.NativeSettings;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;



public class SetTimeTest {


    private static AndroidDriver<MobileElement> driver;
    GoogleClockApp googleClockApp = new GoogleClockApp();
    NativeSettings nativeSettings = new NativeSettings();
    String h = "04";
    String m = "20";
    String expected = h + ":" + m;
    private static final Logger LOGGER = Logger.getLogger(NativeSettings.class);


    @BeforeClass
    public static void setUpClock() throws MalformedURLException {
        LOGGER.info("Test started");
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "My");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

    }

    @Test
    public void setTime() throws InterruptedException {

        googleClockApp.TapMoreOptions(driver);
        googleClockApp.TapSettings(driver);
        googleClockApp.OpenNativeSettings(driver);
        nativeSettings.autoToggle(driver);
        nativeSettings.setTime(driver,h,m);
        nativeSettings.tapBack(driver);
        googleClockApp.tapBack(driver);
        googleClockApp.checkTime(driver, expected);

    }

    @After
    public void closeApp(){
        LOGGER.info("Test finished");
        driver.quit();
    }
}
