package com.NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DataProv_ExcelPages {
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	By username = By.id("Email"); // using By method to store the elements path.
	By Password = By.id("Password");
	By submit = By.xpath("//button[@class='button-1 login-button']"); 
	// Constructor used to initialize objects
	public DataProv_ExcelPages(WebDriver driver) { 
		 // we assign the value of the method parameter (“driver”) to the class parameter
		this.driver = driver;
	}
	// method with parameters strings
	public void Login(String Email, String password) throws Exception { 
		try {

			// create visually attractive reports for Selenium tests
			// Path for the extent report file
			reporter = new ExtentSparkReporter(".\\Datafiles\\Extent-Reports\\Login.html"); 
			// Title for the page
			reporter.config().setDocumentTitle("Login Page"); 
			// Setting report name
			reporter.config().setReportName("Login Valid and Invalid details"); 
			 // Object for the extent reports
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			// setting the system info that we wanted to be in the reports generated
			extent.setSystemInfo("Host Name", "Local Host"); 
			extent.setSystemInfo("Tester", "Ganesh.R");
			extent.setSystemInfo("Environment", "Quality Assurance(QA)");
			extent.setSystemInfo("OS", "Windows");
			// Creating a test
			test = extent.createTest("Login Test", "This is test to validate the Login Functionality"); 

			test.info("Test case");
			// entering the email
			driver.findElement(username).sendKeys(Email); 
			test.pass("Email has been entered");
			// entering password
			driver.findElement(Password).sendKeys(password); 
			test.pass("Password for login has been entered");
			// clicking on login
			driver.findElement(submit).click(); 
			test.pass("Login button is clicked");
			Thread.sleep(3000);         
			test.info("Closing the browser");
			 //to erase any previous data on the report and create a new report.
			extent.flush();  
		} catch (Exception e) {

		}
	}

}
