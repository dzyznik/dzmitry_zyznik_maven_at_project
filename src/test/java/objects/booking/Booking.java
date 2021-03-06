package objects.booking;

import driver.ThreadLocalDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    Actions actions = new Actions(ThreadLocalDriver.getWebDriver());

    @Given("I go to Booking")
    public void bookingSite() {
        ThreadLocalDriver.getWebDriver().get("https://www.booking.com");
    }

    public void registerButton() {
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class = 'sign_in_wrapper']/span[contains(.,'Register')]")).click();
    }

    public void emailInput() {
        WebElement inputEmail = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        actions.click(inputEmail)
                .sendKeys("zyznikdzmitry@trashmail.com")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void passwordInput() {
        WebElement inputPass = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        actions.click(inputPass)
                .sendKeys("Qq12345678")
                .build()
                .perform();
    }

    public void passwordConfirm() {
        WebElement inputConfPass = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmed_password']")));
        actions.click(inputConfPass)
                .sendKeys("Qq12345678")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void personalization() {
        WebElement inputFirstName = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='First name']")));
        actions.click(inputFirstName)
                .sendKeys("Mitya")
                .build()
                .perform();

        WebElement inputLastName = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Last Name']")));
        actions.click(inputLastName)
                .sendKeys("Test")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        WebElement skip = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label = 'dialog']//a[contains(.,'Skip')]")));
        actions.click(skip)
                .build()
                .perform();

        WebElement ok = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label = 'dialog']//a[contains(.,'Ok')]")));
        actions.click(ok)
                .build()
                .perform();
    }

    public void checkAcc() {
//        Thread.sleep(5000);
//        WebElement signIn = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//span[contains(.,'Sign in')]"));
//        signIn.click();
//        emailInput();
//        passwordInput();
        WebElement notification = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-id='notifications']")));
        actions.click(notification)
                .build()
                .perform();
        try {
            WebElement confirm = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Would you like us to resend the activation email?')]")));
            System.out.println("Account wasn't confirmed");
            ThreadLocalDriver.getWebDriver().close();
            ThreadLocalDriver.setDriverNull();
        } catch (TimeoutException timeoutException) {
            System.out.println("Account was confirmed");
            ThreadLocalDriver.getWebDriver().close();
            ThreadLocalDriver.setDriverNull();
        }


    }

    public void login() {
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class = 'sign_in_wrapper']/span[contains(.,'Sign in')]")).click();
        WebElement username = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        actions.click(username).sendKeys("zyznikdzmitry@trashmail.com").build().perform();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//button[@type='submit']")).click();
        WebElement password = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        actions.click(password).sendKeys("Qq12345678").build().perform();
        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//button[@type='submit']")).click();
        WebElement userName = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='user_name_block']")));

    }

    public void searchMadrid() {
        WebElement checkField = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='checkin']")));

        actions.click(checkField).build().perform();


        WebElement inDate = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label = '7 December 2020']")));
        actions.click(inDate).build().perform();

        WebElement outDate = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label = '12 December 2020']")));
        actions.click(outDate).build().perform();

        WebElement searchField = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
        actions.doubleClick(searchField).sendKeys(Keys.BACK_SPACE).sendKeys("Madrid").build().perform();

        WebElement searchMadrid = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@aria-label='List of suggested destinations ']/li[1]")));
        actions.click(searchMadrid).build().perform();


        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();
    }

    public void likeHotels() {
        WebElement heartFirst = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotellist_inner']/div[contains(., data-et-view)][1]/div/div[1]/button")));
        actions.click(heartFirst).build().perform();

        WebElement heartLast = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotellist_inner']/div[contains(., data-et-view)][50]/div/div[1]/button")));
        actions.moveToElement(heartLast).click(heartLast).build().perform();
    }


    public void checkWishList() {
        WebElement profilePic = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Profile Picture']")));
        actions.moveToElement(profilePic).click(profilePic).build().perform();

        WebElement wishList = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='profile-menu__item profile_menu__item--wishlists']")));
        actions.moveToElement(wishList).click(wishList).build().perform();

        WebElement firstItem = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='bui-carousel__inner']/li[1]")));
        boolean displayedFirst = firstItem.isDisplayed();

        WebElement secondItem = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='bui-carousel__inner']/li[2]")));
        boolean displayedSecond = secondItem.isDisplayed();


        if (displayedFirst && displayedSecond) {
            System.out.println("Test passed");
        } else System.out.println("Test failed");
    }


    public void findH1() {
        try {
            WebElement h1 = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//h1"));
            System.out.println("h1 element is present:" + h1.getText());
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("No h1 elements");
        }
    }

//
//    public void findH2() {
//        WebElement h2 = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//h2"));
//        h2.
//        String oneClass = "Recent searches";
//        String twoClass = "Recommended destinations";
//        String threeClass = "Browse by property type";
//        String fourClass = "Get inspiration for your next trip";
//        String fiveClass = "Homes guests love";
//        String sixClass = "Destinations we loves";
//        String sevenClass = "Discover";
//        String eightClass = "Save time, save money!";
//        String nineClass = "Verified reviews from real guests.";
//        String tenClass = "Verified  How does it work?";
//
//       String gg = String.format("//h2[@class='%s'", oneClass);
//        System.out.println(gg);
//
//        WebElement h1 = ThreadLocalDriver.getWebDriver().findElement(By.xpath("//h2[@class='|%s|'", oneClass));


}




