package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage {

    private AppiumDriver<MobileElement> appiumDriver;
    private final By usernameSelById = MobileBy.AccessibilityId("input-email");
    private final By passwordSelById = MobileBy.AccessibilityId("input-password");
    private final By loginBtnSelById = MobileBy.AccessibilityId("input-LOGIN");

    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public void inputUserName(String userNameText) {
        this.username().sendKeys(userNameText);
    }

    public MobileElement username() {
        return appiumDriver.findElement(usernameSelById);
    }
    public MobileElement password() {
        return appiumDriver.findElement(passwordSelById);
    }

    public void inputPassWord(String passwordText) {
        this.password().sendKeys(passwordText);
    }

    public MobileElement loginBtn() {
        return appiumDriver.findElement(loginBtnSelById);
    }

    public void clickOnLoginBtn() {
        this.loginBtn().click();
    }
}
