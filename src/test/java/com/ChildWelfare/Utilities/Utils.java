package com.ChildWelfare.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Utils {
	
	public static WebDriver driver;
	
	/**
	 * This method initialize browser object
	 * @param browser
	 * @return browser driver
	 */
	public static WebDriver selectBrowser(String browser){
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "\\Browser\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "\\Browser\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else if (browser.equals("safari") || browser.equals("SAFARI")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "\\Browser\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}
	
	/**
	 * 
	 * @param timeInsec
	 */
	public void impliciteWait(int timeInsec){
		Reporter.log("waiting for page to load...");
		try{
		driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
		Reporter.log("Page is loaded");
		}
		catch(Throwable error){
			Reporter.log("Timeout for Page Load Request to complete after "+ timeInsec + " seconds");
			Assert.assertTrue(false, "Timeout for page load request after "+timeInsec+" second");
		}
	}
	
}