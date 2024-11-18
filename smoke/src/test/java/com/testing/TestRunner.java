package com.testing;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.WE.WE_Info;
import com.api.Api;
import com.baseClass.Base;
import com.frontend.Admin_Services;
import com.frontend.Admin_User;
import com.frontend.Customer_Bookingflow;
import com.frontend.Customer_Settings;
import com.frontend.Info;
import com.frontend.Login_Details;


public class TestRunner extends Base {

	@BeforeTest()
	public  void load_Properties() throws IOException {
		method1("First");
	}

	@BeforeTest(dependsOnMethods = { "load_Properties" })
	public void ApiRunner() throws InterruptedException {
		Api.signInAdmin(getProperty("PREDEFINED_ADMIN_EMAIL"));
		Api.verifyOtp(getProperty("PREDEFINED_ADMIN_OTP"));
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
		Api.ServiceSlotTimeCount();
		Api.OverallSlotList();
	}

	public  void DownloadApk() {

	}
	
//	@Test(priority = 1)
//	public void signupCustomer() throws Exception {
//
//		WE_Info info = new WE_Info(driver);
//		OpenApplication();
//		Login_Details.signupCustomer();
//		Info.User_Data();
//		Thread.sleep(2000);
//		Info.Pet_Data();
//		info.getcloseApp();
//
//	}
//
//	@Test(priority = 2)
//	public void Clear_Cache() throws IOException {
//
//		clearCache();
//		OpenApplication();
//		Runtime.getRuntime().exec("adb shell pm clear com.petcaretechnologies.app");
//
//	}

	@Test(priority = 3)
	public void AdminLogin() throws Exception {

		Login_Details.login_Admin();
		Thread.sleep(3000);
		System.out.println("completed");

	}

	@Test(priority = 4)
	public  void NewUserApproval() throws Exception {

		Admin_User.approveUserUsingSearch();
		Thread.sleep(4000);
		System.out.println("completed");

	}

	@Test(priority = 5)
	public  void CreateAdmin() throws InterruptedException {

		Admin_User.Create_Admin();
		Thread.sleep(4000);
		System.out.println("completed");

	}

	@Test(priority = 6)
	public  void CreateStaff() throws InterruptedException {

		Admin_User.Create_Staff();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 7)
	public  void CreateTag() throws Exception {

		Admin_User.CreateTag();
		Thread.sleep(4000);
		System.out.println("completed");

	}

	@Test(priority = 8)
	public  void CreateSlot() throws Exception {
		Admin_Services.slot_creation();
		Thread.sleep(4000);
		System.out.println("completed");

	}

	@Test(priority = 9)
	public  void ServiceCreation() throws Exception {
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
		Api.OverallSlotList();
		Admin_Services.ServiceCreation();
		Thread.sleep(4000);
		System.out.println("completed");
	}

	@Test(priority = 10)
	public  void Logout_Admin() {
		Login_Details.Logout_Admin();

	}

	@Test(priority = 11)
	public  void Login_PredefinedCustomer() throws InterruptedException {
		Login_Details.Predefined_login_Customer();

	}

	@Test(priority = 12)
	public  void BookingFlowCustomer() throws Exception {
		Api.refreshAdminToken(Api.VerifiedRefreshToken);
		Api.ServiceSlotTimeCount();
		Customer_Bookingflow.booking();
		Customer_Bookingflow.BookingSuccessfullPage();
		Customer_Settings.MyBookings();
		Customer_Settings.Invoices();
		Customer_Settings.statement();
	}

	public  void main(String[] args) throws Exception {
		WE_Info info = new WE_Info(driver);
		Login_Details.login_Admin();
	}

}
