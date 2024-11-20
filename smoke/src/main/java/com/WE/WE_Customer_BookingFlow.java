package com.WE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.Base;

import io.appium.java_client.android.AndroidDriver;

public class WE_Customer_BookingFlow extends Base{
	public WE_Customer_BookingFlow(AndroidDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Show all\"]")
	private WebElement   ServiceShowAll ;
	public WebElement getServiceShowAll() {
		return    ServiceShowAll ;
	}
	
	public static By ServiceBooking = By.xpath(String.format("//android.view.View[@content-desc=\"%s\"]", getProperty("SERVICE_FOR_BOOKING")));

	@FindBy (xpath ="//android.widget.ScrollView")
	private WebElement  ScrollView  ;
	public WebElement getScrollView() {
		return   ScrollView  ;
	}
	
	@FindBy (xpath ="//*[starts-with(@hint,'Search')]")
	private WebElement   SearchServices ;
	public WebElement getSearchServices() {
		return    SearchServices ;
	}
	
	private WebElement SelectService;
	public WebElement getSelectService() {
	    String dynamicXPath = String.format("//android.view.View[@content-desc='%s']", getProperty("SERVICE_NAME"));
	    SelectService = driver.findElement(By.xpath(dynamicXPath));
	    return SelectService;
	}
//	
	@FindBy (xpath ="//android.widget.SeekBar")
	private WebElement   seekbar ;
	public   WebElement getseekbar() {
		return    seekbar ;
	}
//	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Request Booking\"]")
	private WebElement  RequestBooking  ;
	public WebElement getRequestBooking() {
		return    RequestBooking ;
	}
//	[//*[starts-with(@content-desc,'invoice_number')]and .//android.view.View[contains(@content-desc, 'Nov 07 2024')]and .//android.view.View[contains(@content-desc, '£ 0.00')]]
	@FindBy (xpath ="//android.view.View[@content-desc=\"Available\"]/following-sibling::android.view.View/android.view.View")
	private WebElement   serviceName ;
	public WebElement getserviceName() {
		return   serviceName  ;
	}
//	
	@FindBy (xpath ="//android.widget.Button[@content-desc=\"Proceed\"]")
	private WebElement   proceed ;
	public WebElement getproceed() {
		return   proceed  ;
	}
	
	@FindBy (xpath ="//android.widget.CheckBox")
	private WebElement  CheckBox  ;
	public WebElement getCheckBox() {
		return  CheckBox   ;
	}
	
	@FindBy (xpath ="//*[starts-with(@content-desc,'Confirm and Pay')]")
	private WebElement  ConfirmANDPay  ;
	public WebElement getConfirmANDPay() {
		return   ConfirmANDPay  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Booking Request Successful!\"]")
	private WebElement  SuccessfullpageNavigation  ;
	public WebElement getSuccessfullpageNavigation() {
		return   SuccessfullpageNavigation  ;
	}
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Amount\"]/parent::android.view.View[1]/following-sibling::android.view.View[1]/android.view.View[1]")
	private WebElement  Sucessfullpage_Amount  ;
	public WebElement getSucessfullpage_Amount() {
		return   Sucessfullpage_Amount  ;
	}
	
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"Payment Time\"]/parent::android.view.View[1]/following-sibling::android.view.View[1]/android.view.View[1]")
	private WebElement  Sucessfullpage_PaymentTime ;
	public WebElement getSucessfullpage_PaymentTime() {
		return   Sucessfullpage_PaymentTime  ;
	}
	
	@FindBy (xpath ="//android.view.View[@content-desc=\"New Booking\"]")
	private WebElement  Sucessfullpage_Newbooking ;
	public WebElement getSucessfullpage_Newbooking() {
		return   Sucessfullpage_Newbooking  ;
	}
	
	
	
	public static By ServiceViewable = By.xpath(String.format("//android.view.View[contains(@content-desc,\"%s\")]", getProperty("SERVICE_NAME")));
	//android.view.View[contains(@content-desc, "Hello")]
	
	
}
