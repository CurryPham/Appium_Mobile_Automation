package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;
import utils.SwipeAction;

public class SwipeHorizontally {
    public static void main(String[] args) {
        // Set up the session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // Go to Forms
        appiumDriver.findElementByAccessibilityId("Swipe").click();

        // Make sure I'm on the targer screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//*[@text='Swipe horizontal']")));

        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        swipeAction.swipeFromRightToLeft();
        swipeAction.swipeFromLeftToRight();

        swipeAction.swipeFromRightToLeft(5);

    }
}
