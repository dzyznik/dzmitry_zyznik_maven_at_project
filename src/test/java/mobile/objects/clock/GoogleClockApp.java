package mobile.objects.clock;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;


import static org.junit.Assert.assertEquals;

public class GoogleClockApp {

    private static final Logger LOGGER = Logger.getLogger(GoogleClockApp.class);

    public void TapMoreOptions(AndroidDriver driver){
        LOGGER.debug("Tap more options");
        driver.findElementByAccessibilityId("More options").click();
    }

    public void TapSettings(AndroidDriver driver){
        LOGGER.debug("Tap settings");
        driver.findElementByXPath("//*[@text='Settings']").click();
    }

    public void OpenNativeSettings(AndroidDriver driver){
        LOGGER.debug("Tap Change date & time");
        driver.findElementByXPath("//*[contains(@text, 'Change date & time')]").click();
    }

    public void tapBack(AndroidDriver driver) throws InterruptedException {
        LOGGER.debug("Tap back button");
        driver.findElementByAccessibilityId("Navigate up").click();
        Thread.sleep(1000);
    }

    public void checkTime(AndroidDriver driver,String expected){
        String result = driver.findElementById("com.google.android.deskclock:id/digital_clock").getText();
        assertEquals(expected, result);
    }




}
