package test.apilearning;

import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import utils.AppiumDriverEx;

public class clickOnElement {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();
    }
}
