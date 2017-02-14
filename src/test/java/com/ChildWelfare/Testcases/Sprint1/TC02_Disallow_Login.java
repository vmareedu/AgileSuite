package com.ChildWelfare.Testcases.Sprint1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChildWelfare.BaseTest.TestBase;
import com.ChildWelfare.PageObjects.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


	public class TC02_Disallow_Login extends TestBase {
		
		
		@BeforeMethod
		public void setUp() throws IOException {
			init();
		}

		@Test
		public void DisallowLogin_UnregisterUser() throws Exception {

			
			ExtentTest logger = report.startTest("DisAllowLogin_1_NonRegisterUser");
			logger.log(LogStatus.INFO, "Browser is up and running");
			LoginPage login = new LoginPage();
			login.disAllowlogin_NonRegisterUser();
			logger.log(LogStatus.INFO, "Login Failed with Unregister User");
			report.endTest(logger);
			report.flush();
		}
		
		@Test
		public void DisallowLogin_EmptyUsername() throws Exception {

			//ExtentReports report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\LoginTest.html");
			ExtentTest logger = report.startTest("DisallowLogin_EmptyUsername");
			logger.log(LogStatus.INFO, "Browser is up and running");
			LoginPage login = new LoginPage();
			login.disAllowlogin_EmptyUsername();
			logger.log(LogStatus.INFO, "Login Failed with Blank Username ");
			report.endTest(logger);
			report.flush();
		}
		
		@Test
		public void DisallowLogin_EmptyPassword() throws Exception {

			//ExtentReports report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\LoginTest.html");
			ExtentTest logger = report.startTest("DisallowLogin_EmptyPassword");
			logger.log(LogStatus.INFO, "Browser is up and running");
			LoginPage login = new LoginPage();
			login.disAllowlogin_EmptyPassword();
			logger.log(LogStatus.INFO, "Login Failed with Blank Password ");
			report.endTest(logger);
			report.flush();
		}
		
		@Test
		public void DisallowLogin_EmptyUserNamePassword() throws Exception {

			//ExtentReports report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\LoginTest.html");
			ExtentTest logger = report.startTest("DisallowLogin_EmptyUserNamePassword");
			logger.log(LogStatus.INFO, "Browser is up and running");
			LoginPage login = new LoginPage();
			login.disAllowlogin_EmptyUsernamePassword();
			logger.log(LogStatus.INFO, "Login Failed with Blank UserName Password ");
			report.endTest(logger);
			report.flush();
		}


		@AfterMethod
		public void testDown() {
			closeBrowser();
		}

	}


