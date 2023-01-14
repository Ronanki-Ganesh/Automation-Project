package com.NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ComputerAddCart {

	
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	String expectedName;
	String actualName;
By username=By.id("Email");               //By methods
By Password=By.id("Password");
By submit=By.xpath("(//button[@type='submit'])[2]");
By computers=By.xpath("//a[text()='Computers ']");
By notebooks=By.xpath(" //a[text()=' Notebooks '] ");
By Product=By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]/a/img");
By ProductName=By.xpath("//h1[text()='Asus N551JK-XO076H Laptop']");
By AddToCart=By.id("add-to-cart-button-5");
By CartView=By.xpath(" (//span[text()='Shopping cart'] )");
By verifyname=By.xpath("(//a[@class='product-name'])[1]");

public ComputerAddCart(WebDriver driver) {
	this.driver=driver;
}

public void ComputerCart(String Email, String password) {
	//Path for the extent reports to be saved
	reporter=new ExtentSparkReporter(".\\Datafiles\\Extent-Reports\\Computer.html");   
	  //Setting the title for the Document
	  reporter.config().setDocumentTitle("Computer Add Cart Page");                
	  //Giving the name for the report
    reporter.config().setReportName("validate the Computer Add Cart");            
    //Objection for extent reports
    extent = new ExtentReports();                                                 
    extent.attachReporter(reporter); 
  //setting the system info as we wanted to using setSystemInfo
    extent.setSystemInfo("Host Name", "Local Host");
    extent.setSystemInfo("Tester", "Ganesh.R");
    extent.setSystemInfo("Environment", "Quality Assurance(QA)");
    extent.setSystemInfo("OS", "Windows");
		test=extent.createTest("Login Test","This is test to validate the Computer Add Cart  Functionality");
		
		test.info("Test case");
		//email entered
	driver.findElement(username).sendKeys(Email); 
	test.pass("Email entered");
	//password entered
	driver.findElement(Password).sendKeys(password); 
	test.pass("Password entered");       
	//Clicking on login
	driver.findElement(submit).click();           
	test.pass("Logged in Successfully");
	//Clicked on computers
	driver.findElement(computers).click();          
	test.pass("Clicked on Computers option");
	//Clicking on NoteBooks
	driver.findElement(notebooks).click();        
	test.pass("Clicked on the notbooks");
	 //Clicked on product we wanted in laptops
	driver.findElement(Product).click();       
	test.pass("Clicked on the required Product");
	//store  the product name
	 actualName = driver.findElement(ProductName).getText(); 
	System.out.println(actualName);
	 //Clicking on adding product to cart
	driver.findElement(AddToCart).click();    
	test.pass("Clicked on add to Cart");
	//Viewing the cart
	driver.findElement(CartView).click();    
	test.pass("Clicked to view the items in cart");
	//verifying the product name
	 expectedName = driver.findElement(verifyname).getText(); 
	// Assertion
	Assert.assertEquals(actualName, expectedName);         
	test.pass("Verified successfully");
	if (actualName.equalsIgnoreCase(expectedName)) {
		System.out.println("Actual and Expected product names are matching: true");  
		
	} else {
		System.out.println("Actual and Expected product names are matching: false");
	}
	test.info("Closing the browser");
	 //to erase any previous data on the report and create a new report.
	extent.flush();        
}
}