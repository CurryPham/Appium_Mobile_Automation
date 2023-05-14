package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import utils.AppiumDriverEx;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class RecordVideo {
    public static void main(String[] args) {
        // Init session with appium server
        AndroidDriver<MobileElement> appiumDriver = AppiumDriverEx.getAndroidDriver();

        // Start recording
        ((CanRecordScreen) appiumDriver).startRecordingScreen();

        // 1. Click on Login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        // 2. Enter username and password
        MobileElement emailTxtBx = appiumDriver.findElementByAccessibilityId("input-email");
        emailTxtBx.sendKeys("auto@gmail.com");
        MobileElement passwordTxtBx = appiumDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("password");

        // 3. Click on Login Button
        MobileElement loginButton = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();

        // Stop Recording
        String video = ((CanRecordScreen) appiumDriver).stopRecordingScreen();

        // Save the recorded data to system
        byte[] decodedVideo = Base64.getMimeDecoder().decode(video);
        try {
            Path testVideoDir = Paths.get(System.getProperty("user.dir") + "/videos");
            Files.createDirectories(testVideoDir);
            // test-data.mp4
            Path testVideoFileLocation =
                    Paths.get(testVideoDir.toString(), String.format("%s-%d.%s", "test", System.currentTimeMillis(), "mp4"));
            Files.write(testVideoFileLocation, decodedVideo);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
