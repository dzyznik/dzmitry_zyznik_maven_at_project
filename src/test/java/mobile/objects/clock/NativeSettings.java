package mobile.objects.clock;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

public class NativeSettings {

    private static final Logger LOGGER = Logger.getLogger(NativeSettings.class);

    public void autoToggle(AndroidDriver driver) throws InterruptedException {
        LOGGER.debug("Switch toggle");
        Thread.sleep(1000);
        driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]//android.widget.Switch")
                .click();
    }

    public void setTime(AndroidDriver driver, String h, String m) throws InterruptedException {

        LOGGER.debug("Set time");
        try {
            driver.findElementByXPath("//*[@text='Set time']").click();
        } catch (NoSuchElementException noSuchElementException) {
            autoToggle(driver);
            driver.findElementByXPath("//*[@text='Set time']").click();
        }


        Thread.sleep(2000);
        driver.findElementById("android:id/numberpicker_input").click();
        driver.findElementById("android:id/numberpicker_input").sendKeys(h);
        driver.findElementByXPath("//*[contains(@text, 'Minute')]").sendKeys(m);
        Thread.sleep(1000);
        driver.findElementById("android:id/button1").click();
    }

    public void tapBack(AndroidDriver driver) throws InterruptedException {
        LOGGER.debug("Tap back button");
        driver.findElementByAccessibilityId("Navigate up").click();
        Thread.sleep(1000);
    }


}
