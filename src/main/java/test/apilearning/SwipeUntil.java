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

import java.time.Duration;

public class SwipeUntil {
    public static void main(String[] args) {
        // Set up the session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // Go to Forms
        appiumDriver.findElementByAccessibilityId("Swipe").click();

        // Make sure I'm on the targer screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//*[@text='Swipe horizontal']")));

        // Get the mobile screen sizes
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        // Perform the touch action
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(appiumDriver);

        // Swipe from right to left until i see the 'EXTENDABLE' card and the swipe time is less than 6
        int swipeTime = 0;
        boolean notSeeingTheTargetCard = true;
        while (notSeeingTheTargetCard && swipeTime < 5){
            try {
                boolean isTargetCardDisplayed = appiumDriver.findElementByXPath("//*[@text='EXTENDABLE']").isDisplayed();
                if(isTargetCardDisplayed)
                    notSeeingTheTargetCard = false;
            }catch (Exception e) {
                //Swipe from right to left direction
                touchAction.press(startPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }

            swipeTime++;
        }

        appiumDriver.quit();
    }
}
