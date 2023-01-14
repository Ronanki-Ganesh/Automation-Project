package com.NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SaveUpdateLogoutPage {
	ExtentSparkReporter reporter;// Declaring variables globally for extent report
	ExtentReports extent;
	ExtentTest test;
	String message;

	WebDriver driver;
	By username = By.id("Email"); // Using by methods for storing the path of web elements
	By passWord = By.id("Password");
	By login = By.xpath("//button[text()='Log in']");
	By CartOption = By.xpath("//span[text()='Shopping cart']");
	By TermsBox = By.id("termsofservice");
	By checkout = By.id("checkout");
	By country = By.xpath(
			"/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[5]/select/option[101]");
	By city = By.id("BillingNewAddress_City");
	By street = By.id("BillingNewAddress_Address1");
	By pincode = By.id("BillingNewAddress_ZipPostalCode");
	By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
	By FaxNumber = By.id("BillingNewAddress_FaxNumber");
	By SaveAddress = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");

	By account = By.xpath("(//a[text()='My account'])[1]");
	By companyname = By.id("Company");
	By saveadd = By.id("save-info-button");
	By updatedMessage = By.xpath("//p[text()='The customer info has been updated successfully.']");
	By crossmark = By.xpath("//*[@id=\"bar-notification\"]/div/span");
	By adressdata = By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[2]/a");
	By addressview = By.xpath("//ul[@class='info']");
	By Logo = By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img");
	By Logout = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
	By elementverify = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");

	// Constructor used to initialize objects
	public SaveUpdateLogoutPage(WebDriver driver) {
		// we assign the value of the method parameter (“driver”) to the class parameter
		this.driver = driver;

	}

	// method for saving address with login parameters
	public void SaveAddress(String Email, String password) {
		// create visually attractive reports for Selenium tests
		// setting the path for the extent reports
		reporter = new ExtentSparkReporter(".\\Datafiles\\Extent-Reports\\Register1.html");
		// Setting the title of page
		reporter.config().setDocumentTitle("Registration Page");
		// setting the report name
		reporter.config().setReportName("Registration Valid and Invalid details");
		// Object for extent reports
		extent = new ExtentReports();
		// Setting the system info we wanted to be in the extent reports
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Tester", "Ganesh.R");
		extent.setSystemInfo("Environment", "Quality Assurance(QA)");
		extent.setSystemInfo("OS", "Windows");
		test = extent.createTest("Login Test", "This is test to validate the Register Functionality");

		test.info("Test case");
		// Entering the Email
		driver.findElement(username).sendKeys(Email);
		test.pass("Email has been entered");
		// Entering the password
		driver.findElement(passWord).sendKeys(password);
		test.pass("Password has been been entered");
		// Clicking on login
		driver.findElement(login).click();
		test.pass("Login successfully");
		// Opening the Cart
		driver.findElement(CartOption).click();
		test.pass("Opened add cart feature");
		// checking the Terms check box
		driver.findElement(TermsBox).click();
		test.pass("Terms are accepted");
		// clicking on checking out
		driver.findElement(checkout).click();
		test.pass("Clicked on checkout");
		// Selecting the Country
		driver.findElement(country).click();
		// Entering the address
		driver.findElement(city).sendKeys("Rajahmundry");
		driver.findElement(street).sendKeys("Lalitha Nagar");
		driver.findElement(pincode).sendKeys("533101");
		driver.findElement(phoneNumber).sendKeys("8522098100");
		driver.findElement(FaxNumber).sendKeys("FAX0122");
		test.pass("Address has been entered");
		// Clicking on Save Address
		driver.findElement(SaveAddress).click();
		System.out.println("Address has been saved");
		test.pass("Address has been Saved");

	}

//Method for updating address along with login parameters
	public void UpdateAdress(String Email, String password) {
		// create visually attractive reports for Selenium tests
		// setting the path for the extent reports
		reporter = new ExtentSparkReporter(".\\Datafiles\\Extent-Reports\\Save&Update.html");
		// Setting the Title of the Page
		reporter.config().setDocumentTitle("Save and Update Page");
		// Setting the report Name
		reporter.config().setReportName("validate the Update and Logout");

		extent = new ExtentReports();
		// Setting the system info we wanted to be in the extent reports
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Tester", "Ganesh.R");
		extent.setSystemInfo("Environment", "Quality Assurance(QA)");
		extent.setSystemInfo("OS", "Windows");
		test = extent.createTest("Login Test", "This is test to validate the Update and Logout Functionality");

		test.info("Test case");
		// Entering the Email
		driver.findElement(username).sendKeys(Email);
		test.pass("Email is entered");
		// Entering the Password
		driver.findElement(passWord).sendKeys(password);
		test.pass("Password is enetered");
		// Clicking on Login
		driver.findElement(login).click();
		test.pass("Login is successfully");
		// Clicking on My accounts
		driver.findElement(account).click();
		test.pass("Clicked on account options");
		// Updating the Company Name
		driver.findElement(companyname).clear();
		driver.findElement(companyname).sendKeys("Software Technologies");
		test.pass("Company name is updated");
		// Saving the updated details
		driver.findElement(saveadd).click();
		test.pass("Updated address has been saved");
		// Getting the Text of Message
		message = driver.findElement(updatedMessage).getText();
		System.out.println(message);
		// Clicking on cross mark
		driver.findElement(crossmark).click();
		// Clicking on address to verify
		driver.findElement(adressdata).click();
		test.pass("Address has been clicked");
		// Storing the address in the and printing text
		System.out.println(driver.findElement(addressview).getText());
		test.pass("Address has been stored and retrived");
		// Clicking on Logo
		driver.findElement(Logo).click();
		test.pass("Logo is indentified and cliked");
		// Clicking on Logout
		driver.findElement(Logout).click();
		test.pass("Logout Successfull");
		// Verifying the logout
		driver.findElement(elementverify).isDisplayed();
		test.pass("Verification Done");
		test.pass("Closing the browser");
		// to erase any previous data on the report and create a new report.
		extent.flush();

	}
}
