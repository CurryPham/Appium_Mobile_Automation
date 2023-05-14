package test.testng;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import utils.AppiumDriverEx;

public class Login_01 {
@Test
    public void loginWithCorrectCreds() {
        // 1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // 2. Click on Login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Enter username and password
        MobileElement emailTxtBx = appiumDriver.findElementByAccessibilityId("input-email");
        emailTxtBx.sendKeys("auto@gmail.com");
        MobileElement passwordTxtBx = appiumDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("password");

        // 4. Click on Login Button
        MobileElement loginButton = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
    }
}
