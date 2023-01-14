package com.NopCommerce.Tests;

import java.io.IOException;

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

import com.NopCommerce.Pages.DataProv_ExcelPages;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

//import Utility.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvExcelReadTests {
	static ExcelReader excel; // Declaring the variables globally
	WebDriver driver;
	private String filePath = ".\\DataFiles\\testdata.xlsx"; // Storing the file path
	private String sheetName = "Sheet1"; // Storing the Sheet name
	DataProv_ExcelPages DataProv_ExcelPages;
	static String browser = "Chrome";

	// Parameter 'browser' is required by @Configuration on method setUp
	@Parameters("browser")

	@BeforeMethod
	public void setUp() throws NullPointerException {
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
		DataProv_ExcelPages = new DataProv_ExcelPages(driver);
		// opening the link.
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.manage().window().maximize();

	}

	// giving method name to read data from that method using data provider
	@Test(dataProvider = "readExcel")

	public void read(String type, String username, String password) throws Exception {
		// calling the login method
		DataProv_ExcelPages.Login(username, password);
		// printing the username and password from excel sheet
		System.out.println(username + ":" + password);
	}

	// helps with data-driven test cases that carry the same methods but can be run
	// multiple times with different data sets
	@DataProvider
	// object for data provider
	public Object[][] readExcel() throws Exception, NullPointerException {
		return ExcelReader.readExcel(filePath, sheetName);
	}

	@AfterMethod
	public void tearUp() {
		driver.close();// closing the browser
	}

}
