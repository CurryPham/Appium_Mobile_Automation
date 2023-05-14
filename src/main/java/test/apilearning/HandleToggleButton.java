package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

public class HandleToggleButton {
    public static void main(String[] args) {

        // Launch an appium sesstion
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // Click on the [Forms] label
        MobileElement formsLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formsLabel.click();

        // Get the toggle label value before interacting with the switch
        MobileElement switchTextElement = appiumDriver.findElementByAccessibilityId("switch-text");
        System.out.println("Label Text BEFORE interacting with Toggle button" + switchTextElement.getText());

        // Click on the Toggle button
        MobileElement toggleButton = appiumDriver.findElementByAccessibilityId("switch");
        toggleButton.click();

        // Get the toggle label value after interacting with the switch
        System.out.println("Label Text AFTER interacting with Toggle button" + switchTextElement.getText());
    }
}
