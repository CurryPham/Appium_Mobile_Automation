package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.util.List;

public class HandleMultipleMatchedElements {

    public static void main(String[] args) throws InterruptedException {

        // Start the appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // Click on Login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // Find elements those are matched  //*[@test="Login"]
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.xpath("//*[@test='Login']"), 2));


        List<MobileElement> loginElements = appiumDriver.findElementsByXPath("//*[@test='Login']");
        final int LOGIN_TEXT_FORM_INDEX = 0;
        final int LOGIN_MENU_FORM_INDEX = 1;

        loginElements.get(LOGIN_TEXT_FORM_INDEX).click();
        loginElements.get(LOGIN_MENU_FORM_INDEX).getText();
    }
}
