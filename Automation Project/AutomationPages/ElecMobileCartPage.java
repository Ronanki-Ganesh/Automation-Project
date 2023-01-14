package com.NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ElecMobileCartPage {
	ExtentSparkReporter reporter; // variables for extent reports were declared globally.
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	String actualName;
	String expectedName;
	By username = By.id("Email"); // Storing the web elements by using By methods
	By passWord = By.id("Password");
	By login = By.xpath("//button[text()='Log in']");
	By Electronics = By.xpath("//a[text()='Electronics ']");
	By Mobiles = By.xpath(" //a[text()=' Cell phones ']");
	By Product = By
			.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]/a/img");
	By ProductName = By.xpath("//h1[text()='HTC One Mini Blue']");
	By addCart = By.id("add-to-cart-button-19");
	By CartOption = By.xpath(" (//span[text()='Shopping cart'] )");
	By productverify = By.xpath("(//a[@class='product-name'])[2]");
	// Constructor used to initialize objects

	public ElecMobileCartPage(WebDriver driver) {
		// we assign the value of the method parameter (“driver”) to the class parameter
		this.driver = driver;
	}

	// method for mobile cart along with login data parameters
	public void MobileCart(String Email, String password) {

		// create visually attractive reports for Selenium tests
		// setting the path for the extent reports
		reporter = new ExtentSparkReporter(".\\Datafiles\\Extent-Reports\\Electronics.html");
		// setting the title of report page
		reporter.config().setDocumentTitle("Electronics Add Cart Page");
		// setting the report name
		reporter.config().setReportName("validate the Electronics Add Cart");
		// objection creation for the report
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		// setting system info which we wanted to be generated in the reports
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Tester", "Ganesh.R");
		extent.setSystemInfo("Environment", "Quality Assurance(QA)");
		extent.setSystemInfo("OS", "Windows");
		test = extent.createTest("Login Test", "This is test to validate the Electronics Add Cart  Functionality");

		test.info("Test case");
		// Entering the email
		driver.findElement(username).sendKeys(Email);
		test.pass("Email has been entered");
		// Entering the password
		driver.findElement(passWord).sendKeys(password);
		test.pass("Password has been entered");
		// Clicking on login
		driver.findElement(login).click();
		test.pass("Logged in Successfully");
		// Clicking on the electronics option
		driver.findElement(Electronics).click();
		test.pass("Clicked on electronics");
		// Clicking on mobile
		driver.findElement(Mobiles).click();
		test.pass("Clicked on mobile");
		// Clicking on mobile we wanted (Product)
		driver.findElement(Product).click();
		test.pass("Clicked on required mobile phone");
		// Storing the name of the mobile.
		actualName = driver.findElement(ProductName).getText();
		System.out.println(actualName);
		// Adding the mobile to cart
		driver.findElement(addCart).click();
		test.pass("Item added to cart");
		// Viewing the cart for verification
		driver.findElement(CartOption).click();
		test.pass("Item is displayed in the cart");
		// storing the name of product in cart
		expectedName = driver.findElement(productverify).getText();
		// Using asserts for validation
		Assert.assertEquals(actualName, expectedName);// Assertion
		test.pass("Verified successfully");
		// using If statements to verify the cases
		if (actualName.equalsIgnoreCase(expectedName)) {
			System.out.println("Actual and Expected product names are matching: true");
		} else {
			System.out.println("Actual and Expected product names are matching: false");
		}
		// to erase any previous data on the report and create a new report.
		extent.flush();
		test.info("Closing the browser");
	}
}
