package com.automation.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.BaseClass;

public class LoginPageObject extends BaseClass {
    
    public LoginPageObject(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@hint='Continue with email']") 
    private WebElement ContinueWithEmail;

    @FindBy(xpath = "//android.view.View[@content-desc='Continue']") 
    private WebElement ContinueButton;

    @FindBy(xpath = "//android.widget.EditText") 
    private WebElement OTP;

    @FindBy(xpath = "//android.view.View[@content-desc='Enter or paste your security code']") 
    private WebElement EnterORPaste;

    public WebElement getContinueWithEmail() {
        return ContinueWithEmail;
    }

    public WebElement getContinueButton() {
        return ContinueButton;
    }

    public WebElement getOTP() {
        return OTP;
    }

    public WebElement getEnterORPaste() {
        return EnterORPaste;
    }
}
