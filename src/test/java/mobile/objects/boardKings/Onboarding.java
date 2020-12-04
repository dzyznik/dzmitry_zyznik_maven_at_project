package mobile.objects.boardKings;

import driver.ThreadLocalDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Onboarding {

    public void guestLogin(AndroidDriver driver) throws InterruptedException {

        AndroidElement onboarding = (AndroidElement) new WebDriverWait(driver, 3)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")));

        Thread.sleep(5000);

        TouchAction a2 = new TouchAction(driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(720,2758);
        a2.tap(pointOption).perform();
    }
}
