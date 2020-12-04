package mobile.objects.boardKings;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import mobile.objects.clock.NativeSettings;
import org.apache.log4j.Logger;

public class FirstScreen {

    private static final Logger LOGGER = Logger.getLogger(NativeSettings.class);

    public void tapAccept(AndroidDriver driver){
        LOGGER.debug("Tap Accept");

        TouchAction a2 = new TouchAction(driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(720,2270);
        a2.tap(pointOption).perform();
    }


    public void tapContinue(AndroidDriver driver){
        LOGGER.debug("Tap Continue");

        TouchAction a2 = new TouchAction(driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(1001,2203);
        a2.tap(pointOption).perform();
    }

    public void tapWhiteArrow(AndroidDriver driver){
        LOGGER.debug("Tap White Arrow");

        TouchAction a2 = new TouchAction(driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(836,1141);
        a2.tap(pointOption).perform();
    }

    public void tapBuild(AndroidDriver driver){
        LOGGER.debug("Tap Build");

        TouchAction a2 = new TouchAction(driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(836,1123);
        a2.tap(pointOption).perform();
    }

    public void tapDice(AndroidDriver driver){
        LOGGER.debug("Tap Dice");

        TouchAction a2 = new TouchAction(driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(726,2500);
        a2.tap(pointOption).perform();
    }







}
