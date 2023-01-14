package com.NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SearchBoxWishPage {
	ExtentSparkReporter reporter; // Declaring variables globally for extent report
	ExtentReports extent;
	ExtentTest test;
	String actualName;
	String expectedName;
	WebDriver driver;
	By username = By.id("Email"); // Using by methods for storing the path of web elements
	By passWord = By.id("Password");
	By login = By.xpath("//button[text()='Log in']");
	By Searchboxkey = By.xpath("//*[@id=\"small-searchterms\"]");
	By searchbtn = By.xpath("//button[@type='submit']");
	By gift = By
			.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div[1]/a/img");
	By giftName = By.tagName("h1");
	By recipientName = By.id("giftcard_44_RecipientName");
	By senderName = By.id("giftcard_44_SenderName");
	By message = By.id("giftcard_44_Message");
	By AddWishlist = By.id("add-to-wishlist-button-44");
	By WishlistBtn = By.className("wishlist-label");
	By selectbox = By
			.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]/input");
	By addingcart = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[2]/button[2]");
	By verifyGiftName = By.xpath("//a[@class='product-name']");

	// Constructor used to initialize objects
	public SearchBoxWishPage(WebDriver driver) {
		// we assign the value of the method parameter (“driver”) to the class parameter
		this.driver = driver;
	}

//Method for search wish along with login parameters
	public void SearchWish(String Email, String password) {
		// create visually attractive reports for Selenium tests
		// setting the path for the extent reports
		reporter = new ExtentSparkReporter(".\\Datafiles\\Extent-Reports\\WishlistSearch.html");
		// Setting the Title of Page
		reporter.config().setDocumentTitle("Wishlist Search Page");
		// Setting the Report Name
		reporter.config().setReportName("Validating searchbox and Wishlist");

		// Object for the extent reports
		extent = new ExtentReports();
		// Setting the system info we wanted to be in the extent reports
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Tester", "Ganesh.R");
		extent.setSystemInfo("Environment", "Quality Assurance(QA)");
		extent.setSystemInfo("OS", "Windows");
		test = extent.createTest("Login Test", "This is test to validate the  searchbox and Wishlist Functionality");

		test.info("Test case");
		// Entering the Email
		driver.findElement(username).sendKeys(Email);
		test.pass("Email has been entered");
		// Entering the Password
		driver.findElement(passWord).sendKeys(password);
		test.pass("Password has been entered");
		// Clicking on Login
		driver.findElement(login).click();
		test.pass("Logged in successfully");
		// Sending the keys to the search box
		driver.findElement(Searchboxkey).sendKeys("gift");
		test.pass("Keys for search box has been entered");
		// Clicking on Search Button
		driver.findElement(searchbtn).click();
		test.pass("Clicked on search");
		// Clicking on Gift
		driver.findElement(gift).click();
		test.pass("Clicked on required gift");
		// Storing the Name of the gift
		actualName = driver.findElement(giftName).getText();
		System.out.println(actualName);
		// Entering the Name of reciever
		driver.findElement(recipientName).sendKeys("Ganesh");
		test.pass("Recipient Name has been entered");
		// Entering the Name of Senders
		driver.findElement(senderName).sendKeys(", Shaik Aavez");
		// Entering the message of Gift
		driver.findElement(message).sendKeys("Happy Birthday");
		test.pass("Message for reciver has been entered");
		// Clicking on adding to wish list
		driver.findElement(AddWishlist).click();
		test.pass("Gift added to wishlist");
		// Clicking on wish list button to view that
		driver.findElement(WishlistBtn).click();
		expectedName = driver.findElement(verifyGiftName).getText();
		// Using asserts to verify the product names
		Assert.assertEquals(actualName, expectedName);// Assertion
		// Clicking on the select option
		driver.findElement(selectbox).click();
		// Adding the Wish list to Cart
		driver.findElement(addingcart).click();
		test.pass("Item from wish is added to Cart");
		test.pass("Verified successfully");
		// Using if statements for verification
		if (actualName.equalsIgnoreCase(expectedName)) {
			System.out.println("Actual and Expected product names are matching: true");
		} else {
			System.out.println("Actual and Expected product names are matching: false");
		}
		test.info("Closing the Browser");
		// to erase any previous data on the report and create a new report.
		extent.flush();
	}
}
