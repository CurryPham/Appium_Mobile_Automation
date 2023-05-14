package test.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPageMethodChaining;
import models.pages.LoginPageWithComponents;
import utils.AppiumDriverEx;

public class setValuesByPOMComponents {

    public static void main(String[] args) {
        // 1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // 2. Click on Login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 3. Enter username and password
        LoginPageWithComponents loginPage = new LoginPageWithComponents(appiumDriver);
        loginPage.credentialForm().inputUserName("auto@gmail.com");

        loginPage.credentialForm().inputPassWord("password");

        loginPage.clickOnLoginBtn();
    }
}
