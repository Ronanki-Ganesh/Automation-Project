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

import com.NopCommerce.Pages.RegisterPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTests {

	WebDriver driver;
	RegisterPage RegisterPage;
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
		// Creating the object for register page
		RegisterPage = new RegisterPage(driver);
		// Opening the URL
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

	}

    //Using data provider method to pass the data
	@Test(dataProvider = "register_data")
	// Method with registration parameters
	public void RegisterNop(String firstName, String lastName, String Email, String Company, String Password, String ConfirmPassword) {
	    // Calling the registration method
		RegisterPage.Register(firstName, lastName, Email, Company, Password, ConfirmPassword);

	}

	// helps with data-driven test cases that carry the same methods but can be run
	// multiple times with different data sets
	@DataProvider

	public Object[][] register_data() {
		Object[][] obj = new Object[2][6];
		// Valid Data for registration
		obj[0][0] = "Ganesh";
		obj[0][1] = "Ronanki";
		obj[0][2] = "ganesh11@gmail.com";
		obj[0][3] = "Demo";
		obj[0][4] = "May 11 2004";
		obj[0][5] = "May 11 2004";

		// Invalid data for registration
		obj[1][0] = "Pavani";
		obj[1][1] = "Gujja";
		obj[1][2] = "12345@mail.com";
		obj[1][3] = "Demo";
		obj[1][4] = "pavani";
		obj[1][5] = "pavani123";

		return obj;

	}

	@AfterMethod
	public void tearDown() {
		// Closing the browser
		driver.close();
	}
}
