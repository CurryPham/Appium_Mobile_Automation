package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.AppiumDriverEx;

import java.time.Duration;

public class PutAppInBackground {

    public static void main(String[] args) {
        // 1. Launch the target app
        AndroidDriver<MobileElement> androidDriver = AppiumDriverEx.getAndroidDriver();

        // 2. Click on Login Label
        MobileElement loginLabel = androidDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Enter username and password
        MobileElement emailTxtBx = androidDriver.findElementByAccessibilityId("input-email");
        emailTxtBx.sendKeys("auto@gmail.com");
        MobileElement passwordTxtBx = androidDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("password");

        // 4. Click on Login Button
        MobileElement loginButton = androidDriver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();

        // Put the app in baclground (simulate the way user press HOME button on Phone) for 3 seconds
        androidDriver.runAppInBackground(Duration.ofSeconds(3));
    }
}
