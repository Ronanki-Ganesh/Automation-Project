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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComputerAddCartTests {
	WebDriver driver;
	ComputerAddCart ComputerAddCart; // declaring the varibles globally
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
		// Object creation for the Computer add cart
		ComputerAddCart = new ComputerAddCart(driver);
		// opening the link
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.manage().window().maximize();

	}

	// Data provider
	@Test(dataProvider = "App_Data")
	// passing the parameters
	public void AddComputer(String Email, String password) {
		// Calling the Computer add cart method
		ComputerAddCart.ComputerCart(Email, password);
	}

	@DataProvider
	// helps with data-driven test cases that carry the same methods but can be run
	// multiple times with different data sets
	public Object[][] App_Data() {
		Object[][] obj = new Object[1][2];
		// Credentails for login
		obj[0][0] = "ganesh11@gmail.com";
		obj[0][1] = "May 11 2004";

		return obj;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		// closing the browser
	}
}
