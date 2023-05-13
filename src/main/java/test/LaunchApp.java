package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LaunchApp {
    public static void main(String[] args) {

        try {
            // Driver instance
            AppiumDriver<MobileElement> appiumDriver;

            // Set DesiredCapabilities to send to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\App\\Android.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);


            // Set up the Appium server URL to connect to
            URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
            appiumDriver = new AppiumDriver<>(appiumServerURL, desiredCapabilities);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
