package com.ChildWelfare.PageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import com.ChildWelfare.BaseTest.TestBase;


public class LoginPage extends TestBase {
	

	public void loginToApplication() throws Exception{
		WebElement UserName = getWebElement("Login.UserName.input");
		Reporter.log("entering userName to the userName textbox");
		UserName.sendKeys(Repository.getProperty("userName"));
		WebElement Password = getWebElement("Login.Password.input");
		Reporter.log("entering password to the password textbox");
		Password.sendKeys(Repository.getProperty("passWord"));
		Reporter.log("clicking on login button");
		getWebElement("Login.Submit.button").click();

		if (driver.getPageSource().contains("Success Status") == true) {
			Reporter.log("Login Success");;
		} else {
			Reporter.log("Login Failed");
		}
	}

	public void disAllowlogin_EmptyPassword() throws Exception{
		WebElement UserName = getWebElement("Login.UserName.input");
		Reporter.log("entering Valid userName ");
		UserName.sendKeys(Repository.getProperty("userName"));
		WebElement Password = getWebElement("Login.Password.input");
		Reporter.log("entering Blank Password");
		Password.sendKeys("");
		Reporter.log("clicking on login button");
		
		if (driver.getPageSource().contains("the password is mandatory") == true) {
			Reporter.log("Login Failed with Empty Password");;
		} else {
			Reporter.log("Login Passed with Empty Password");
		}
	}
	
	public void disAllowlogin_EmptyUsername() throws Exception{
		WebElement UserName = getWebElement("Login.UserName.input");
		Reporter.log("entering Blank userName ");
		UserName.sendKeys("");
		WebElement Password = getWebElement("Login.Password.input");
		Reporter.log("entering Blank Password");
		Password.sendKeys(Repository.getProperty("passWord"));
		Reporter.log("clicking on login button");
		if (driver.getPageSource().contains("the username is mandatory") == true) {
			Reporter.log("Login Failed with Empty Username");;
		} else {
			Reporter.log("Login Passed with Empty Username");
		}
	}
	
	public void disAllowlogin_EmptyUsernamePassword() throws Exception{
		WebElement UserName = getWebElement("Login.UserName.input");
		Reporter.log("entering Blank userName ");
		UserName.sendKeys("");
		WebElement Password = getWebElement("Login.Password.input");
		Reporter.log("entering Blank Password");
		Password.sendKeys("");
		Reporter.log("clicking on login button");
		if (driver.getPageSource().contains("the username is mandatory") == true) {
			Reporter.log("Login Failed with Empty Username");;
		} else {
			Reporter.log("Login Passed with Empty Username");
		}
		
		if (driver.getPageSource().contains("the password is mandatory") == true) {
			Reporter.log("Login Failed with Empty Password");;
		} else {
			Reporter.log("Login Passed with Empty Password");
		}
		
	}
	
	public void disAllowlogin_NonRegisterUser() throws Exception{
		WebElement UserName = getWebElement("Login.UserName.input");
		Reporter.log("entering Blank userName ");
		UserName.sendKeys("invalid@cgi.com");
		WebElement Password = getWebElement("Login.Password.input");
		Reporter.log("entering Blank Password");
		Password.sendKeys(Repository.getProperty("passWord"));
		Reporter.log("clicking on login button");
		if (driver.getPageSource().contains("Error Status") == true) {
			Reporter.log("Login Failed with Non Register User");;
		} else {
			Reporter.log("Login Passed with Non Register User");
		}
	}
	
	
}
