package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static WebDriver webDriver;

    public static WebDriver getDriver(Config config) {
        if (config == null){
            webDriver = new ChromeDriver();
        }

        if (config == Config.CHROME) {
            webDriver = new ChromeDriver();
        }

        if (config == Config.FIREFOX) {
            webDriver = new FirefoxDriver();
        }

        if (config == Config.SAFARI) {
            webDriver = new SafariDriver();
        }


        if (config == Config.OPERA) {
            webDriver = new OperaDriver();
        }


        if (config == Config.EDGE) {
            webDriver = new EdgeDriver();
        }
        return webDriver;

    }
    //переписать со switch
    // и написать методы которые сетают драйверы
}
