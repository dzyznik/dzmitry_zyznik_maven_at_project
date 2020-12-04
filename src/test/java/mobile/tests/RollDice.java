package mobile.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mobile.objects.boardKings.FirstScreen;
import mobile.objects.boardKings.Onboarding;
import mobile.objects.clock.NativeSettings;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RollDice {
    private static AndroidDriver<MobileElement> driver;
    private static final Logger LOGGER = Logger.getLogger(NativeSettings.class);

    Onboarding onboarding = new Onboarding();
    FirstScreen firstScreen = new FirstScreen();


    @BeforeClass
    public static void setUpClock() throws MalformedURLException {
        LOGGER.info("Test started");
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "My");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.jellybtn.boardkings");
        caps.setCapability("appActivity", ".BKAppboyUnityPlayerActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

    }

    @Test

    public void test() throws InterruptedException {
//        onboarding.guestLogin(driver);
        Thread.sleep(10000);
        firstScreen.tapAccept(driver);
        Thread.sleep(20000);
        firstScreen.tapContinue(driver);
        Thread.sleep(5000);
        firstScreen.tapWhiteArrow(driver);
        Thread.sleep(1000);
        firstScreen.tapBuild(driver);
        Thread.sleep(10000);
        firstScreen.tapContinue(driver);
        Thread.sleep(1000);
        firstScreen.tapContinue(driver);
        Thread.sleep(7000);
        firstScreen.tapDice(driver);
    }


}
