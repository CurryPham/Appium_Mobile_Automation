package test.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import utils.AppiumDriverEx;

public class setValuesByPOMMainInteractionMethod {

    public static void main(String[] args) {
        // 1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // 2. Click on Login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Enter username and password
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.inputUserName("auto@gmail.com");
        loginPage.inputPassWord("password");

        // 4. Click on Login Button
        loginPage.clickOnLoginBtn();
    }
}
