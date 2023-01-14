package com.NopCommerce.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.NopCommerce.Pages.ComputerAddCart;
import com.NopCommerce.Pages.SaveUpdateLogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaveUpdateLogoutTests {

	WebDriver driver;
	SaveUpdateLogoutPage SaveUpdateLogoutPage;
	static String browser = "Chrome";

	@Parameters("browser")

	@BeforeMethod
	public void setUp() {
		// cross browser testing
		if (browser.equalsIgnoreCase("Chrome")) {
			// WebDriverManager makes it easy and convert the manual stuff into automation
			WebDriverManager.chromedriver().setup();
			// Instantiation of chrome browser

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Opera")) {
			WebDriverManager.operadriver().setup();
			// Instantiation of firefox browser
			driver = new OperaDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			// Instantiation of edge browser
			driver = new EdgeDriver();

		}
		// object Creation for the Save update and logout page
		SaveUpdateLogoutPage = new SaveUpdateLogoutPage(driver);
		// Opening the URL
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.manage().window().maximize();

	}

	//Using data provider method to pass the data
	@Test(dataProvider = "App_Data")
	public void Save(String Email, String password) {
		SaveUpdateLogoutPage.SaveAddress(Email, password);
	}
	//Using data provider method to pass the data
	@Test(dataProvider = "App_Data")//, enabled = false)
	public void Update(String Email, String password) {
		SaveUpdateLogoutPage.UpdateAdress(Email, password);
	}
	// helps with data-driven test cases that carry the same methods but can be run multiple times with different data sets
	@DataProvider
	public Object[][] App_Data() {
		Object[][] obj = new Object[1][2];
		//Credentials for login
		obj[0][0] = "ganesh11@gmail.com";
		obj[0][1] = "May 11 2004";

		return obj;
	}

	@AfterMethod
	public void tearDown() {
		//Closing the Browser
		driver.close();
	}
}
