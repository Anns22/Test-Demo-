package com.automation.testscripts;

import com.automation.objects.LoginPageObject;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.baseclass.BaseClass;

public class LoginTest extends BaseClass {

    @BeforeMethod
    public void setUp() throws InterruptedException, MalformedURLException {
        // Ensure driver is initialized before running the test
        openApplication();  // Call the method to initialize driver
    }

    @Test
    public void login_Admin() throws InterruptedException {
        // Initialize LoginPageObject
        LoginPageObject login = new LoginPageObject(driver);

        // Continue with Email
        ClickonElement(login.getContinueWithEmail());
        passInput(login.getContinueWithEmail(), "petcarea54@gmail.com");

        // Move back after entering email (ensure the page is ready)
        driver.navigate().back();

        // Continue Button
        ClickonElement(login.getContinueButton());

        // Wait for OTP field to be ready
        waitForElement(login.getEnterORPaste());

        // Enter OTP
        passInputUsingActions(login.getOTP(), "345765");

        // Navigate back
        driver.navigate().back();
    }
}
