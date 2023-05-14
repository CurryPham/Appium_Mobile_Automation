package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

public class HandleDropdown {
    public static void main(String[] args) {

        // Set up the session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // Go to Forms
        MobileElement formLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formLabel.click();

        // Click on the Dropdown element
        MobileElement dropdownElement = appiumDriver.findElementByAccessibilityId("select-Dropdown");
        dropdownElement.click();

        // Click on the Dropdown Option
        MobileElement dropdownOption = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        dropdownOption.click();
    }
}
