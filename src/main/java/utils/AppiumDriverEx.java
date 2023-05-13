package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverEx {

    public static AppiumDriver<MobileElement> getAppiumDriver() {
        // Driver instance
        AppiumDriver<MobileElement> appiumDriver = null;
        try {
            // Set DesiredCapabilities to send to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\App\\Android.apk");

            // Set up the Appium server URL to connect to
            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");

            appiumDriver = new AppiumDriver<>(appiumServerURL, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return appiumDriver;
    }
}
