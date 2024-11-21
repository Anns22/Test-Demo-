package com.automation.baseclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
    public static WebDriver driver; // Single WebDriver variable, can be used for both mobile and web.

    // Define the ChromeDriver path dynamically
    private static final String CHROME_DRIVER_PATH = System.getProperty("webdriver.chrome.driver.path", "drivers/chromedriver.exe");

    public static void openApplication() throws MalformedURLException {
        String platform = System.getProperty("platform", "mobile"); // Default to "mobile"
        System.out.println("Selected platform: " + platform);

        if (platform.equalsIgnoreCase("web")) {
            System.out.println("Opening Chrome browser...");
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://word.com");
        } else if (platform.equalsIgnoreCase("mobile")) {
            System.out.println("Launching mobile application...");
            UiAutomator2Options options = new UiAutomator2Options();
            options.setAutomationName("UiAutomator2");
            options.setPlatformName("Android");
            options.setPlatformVersion("13.0");
            options.setDeviceName("Pixel 6 Pro API 33");
            options.setAppPackage("com.petcaretechnologies.app");
            options.setAppActivity("com.petcaretechnologies.app.MainActivity");
            options.setNoReset(true);
            options.setFullReset(false);
         
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } else {
            throw new IllegalArgumentException("Invalid platform specified. Use 'web' or 'mobile'.");
        }
    }

    // Ensure ClickonElement method is using the correct driver
    public static void ClickonElement(WebElement element) {
        if (driver != null) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } else {
            System.out.println("Driver is not initialized properly.");
        }
    }

	public static void waitForElement(WebElement element) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // 120 seconds wait time
	    Thread.sleep(3000); // Sleep for 3 seconds
	    wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is clickable
	}
	public static void passInput(WebElement element, String input) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(element)); // Wait until the element is visible
		element.sendKeys(input);
	}
//	
//	public static void ClickonElement(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // 10 seconds wait time
//		wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is clickable
//		element.click();
//	}

	public static void passInputUsingActions(WebElement element, String input) throws InterruptedException {
		// 120 seconds wait time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until the element is visible
		Actions actions = new Actions(driver);
		actions.sendKeys(element, input).perform();
	}

}

