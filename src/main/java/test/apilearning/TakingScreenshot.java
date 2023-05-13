package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AppiumDriverEx;

import java.io.File;

public class TakingScreenshot {
    public static void main(String[] args) {

        // Set up the session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        // Go to Forms
        MobileElement formLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formLabel.click();

        // Click on the Toggle button IF it's OFF
        MobileElement switchTextElement = appiumDriver.findElementByAccessibilityId("switch-text");
        final boolean isSwitchOn = switchTextElement.getText().equals("Click to turn the switch OFF");

        if(!isSwitchOn) {
            switchTextElement.click();
        }

        // Click on the Dropdown element
        MobileElement dropdownElement = appiumDriver.findElementByAccessibilityId("select-Dropdown");
        dropdownElement.click();

        // Click on the Dropdown Option
        MobileElement dropdownOption = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        dropdownOption.click();

        // Taking a screenshot
        File formScreenBase64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshot/" + "formScreen.png";

        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
