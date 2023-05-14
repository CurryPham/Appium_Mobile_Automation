package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;
import utils.SwipeAction;

import java.time.Duration;

public class SwipeHorizontally {
    public static void main(String[] args) {
        // Set up the session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

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
