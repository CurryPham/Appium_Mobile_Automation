package models.components.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CredentialForm {

    private AppiumDriver<MobileElement> appiumDriver;
    private final By usernameSelById = MobileBy.AccessibilityId("input-email");
    private final By passwordSelById = MobileBy.AccessibilityId("input-password");

    public CredentialForm(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public CredentialForm inputUserName(String userNameText) {
        this.username().sendKeys(userNameText);
        return this;
    }

    public MobileElement username() {
        return appiumDriver.findElement(usernameSelById);
    }
    public MobileElement password() {
        return appiumDriver.findElement(passwordSelById);
    }

    public CredentialForm inputPassWord(String passwordText) {
        this.password().sendKeys(passwordText);
        return this;
    }

}
