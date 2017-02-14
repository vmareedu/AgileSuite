package com.ChildWelfare.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ChildWelfare.Utilities.Utils;
import com.relevantcodes.extentreports.ExtentReports;



public class TestBase extends Utils {

	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public  String className;
	public  ExtentReports report;
	public void init() throws IOException {
		className = this.getClass().getSimpleName();
		report = new ExtentReports("./Reports/" + className + ".html", true);
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		impliciteWait(30);
		driver.get(Repository.getProperty("url"));
	}

	public void loadPropertiesFile() throws IOException {
		f = new File(System.getProperty("user.dir") + "\\ObjectRepository\\LoginPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);

		f = new File(System.getProperty("user.dir") + "\\ObjectRepository\\UserProfile.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);

	}

	public static WebElement getLocator(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public static List<WebElement> getLocators(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public WebElement getWebElement(String locator) throws Exception {
		return getLocator(Repository.getProperty(locator));
	}

	public List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(Repository.getProperty(locator));
	}

	public void closeBrowser() {
		driver.quit();
	}
}
