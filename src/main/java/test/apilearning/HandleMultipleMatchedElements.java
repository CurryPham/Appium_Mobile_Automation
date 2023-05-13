package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

import java.util.List;

public class HandleMultipleMatchedElements {

    public static void main(String[] args) throws InterruptedException {

        // Start the appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // Click on Login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // Find elements those are matched  //*[@test="Login"]
        Thread.sleep(2000);
        List<MobileElement> loginElements = appiumDriver.findElementsByXPath("//*[@test='Login']");
        final int LOGIN_TEXT_FORM_INDEX = 0;
        final int LOGIN_MENU_FORM_INDEX = 1;

        loginElements.get(LOGIN_TEXT_FORM_INDEX).click();
        loginElements.get(LOGIN_MENU_FORM_INDEX).getText();
    }
}
