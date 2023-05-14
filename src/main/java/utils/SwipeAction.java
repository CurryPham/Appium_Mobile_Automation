package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeAction {

    public AppiumDriver<MobileElement> appiumDriver;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;
    public SwipeAction(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
        touchAction = new TouchAction(appiumDriver);

        // Get the mobile screen sizes
        Dimension windowSize = this.appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        // Perform the touch action
        this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        this.endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
    }


    public void swipeFromLeftToRight(int times){
        for (int i = 0; i < times; i++){
            this.swipeFromLeftToRight();
        }
    }

    public void swipeFromRightToLeft(int times){
        for (int i = 0; i < times; i++){
            this.swipeFromRightToLeft();
        }
    }

    public void swipeFromLeftToRight(){


        touchAction.press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(startPoint)
                .release()
                .perform();
    }

    public void swipeFromRightToLeft(){
        touchAction.press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint)
                .release()
                .perform();
    }

}
