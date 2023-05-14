package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverEx {

    public static AndroidDriver<MobileElement> getAndroidDriver() {
        // Driver instance
        AndroidDriver<MobileElement> androidDriver = null;
        try {
            // Set DesiredCapabilities to send to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\App\\Android.apk");

            // Set up the Appium server URL to connect to
            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");

            androidDriver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
            androidDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            MobileElement loginLabel = androidDriver.findElementByAccessibilityId("Login");
            loginLabel.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return androidDriver;
    }
}
