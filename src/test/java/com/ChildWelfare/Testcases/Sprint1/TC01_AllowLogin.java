package com.ChildWelfare.Testcases.Sprint1;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ChildWelfare.BaseTest.TestBase;
import com.ChildWelfare.PageObjects.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC01_AllowLogin extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	@Test
	public void AllowsLogin_Sucess() throws Exception {

		ExtentReports report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\AllowLogin.html");
		ExtentTest logger = report.startTest("TC_01 Allow Login");
		logger.log(LogStatus.INFO, "Browser is up and running");
		LoginPage login = new LoginPage();
		login.loginToApplication();
		logger.log(LogStatus.INFO, "Login Success with Valid Credentials");
		report.endTest(logger);
		report.flush();
	}

	@AfterClass
	public void testDown() {
		closeBrowser();
	}

}
