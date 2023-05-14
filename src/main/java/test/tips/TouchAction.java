package test.tips;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.time.Duration;

public class TouchAction {

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
        androidDriver.runAppInBackground(Duration.ofSeconds(-1));

        // Open the Settings APlication -com.android.settings
        androidDriver.activateApp("com.android.settings");

        // Go to wifi
        androidDriver.findElementByXPath("//*[@text='Network & internet']").click();

        // Turn the wifi ON of it's off and try to turn off then on if it's already ON
        try {
            By wifiToggleButtonSelector = MobileBy.id("com.android.settings:id/switchWidget");
            MobileElement wifiToggleElement;

            wifiToggleElement = androidDriver.findElement(wifiToggleButtonSelector);
            boolean isWifiOn = wifiToggleElement.getText().equals("ON");
            if (isWifiOn) {
                // Toggle the wifi off
                wifiToggleElement.click();

                // Toggle it ON again
                WebDriverWait wait = new WebDriverWait(androidDriver, 5);
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@text='Off']"), "Off"));
                wifiToggleElement.click();
            } else {
                wifiToggleElement.click();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
//
//        // RE-LAUNCH the testing app again
//        androidDriver.activateApp("Appium");
//
//        // Continue to interact with other elements on the app
//        androidDriver.findElementByXPath("//*[@test='OK']").click();
    }
}
