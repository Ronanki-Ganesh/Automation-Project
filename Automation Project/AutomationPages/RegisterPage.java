package com.NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RegisterPage {
	ExtentSparkReporter reporter; // variables for extent reports were declared globally.
	ExtentReports extent;
	ExtentTest test;
WebDriver driver;
String reSult;
boolean Result;
By registerbutton=By.className("ico-register"); // Storing web elements by using By methods
By gender=By.xpath("//*[@id=\"gender\"]/span[2]/label");
By firstname=By.id("FirstName");
By lastname=By.id("LastName");
By day=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[11]");
By month=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[6]");
By year=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]/option[93]");
By email=By.id("Email");
By company=By.id("Company");
By newsletter=By.id("Newsletter");
By password=By.xpath("//*[@id=\"Password\"]");
By confirmPassword=By.id("ConfirmPassword");
By registration=By.id("register-button");
By result=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]");
By error=By.id("ConfirmPassword-error");

//Used to initialize the objects
public RegisterPage(WebDriver driver) {
	// we assign the value of the method parameter (“driver”) to the class parameter
	this.driver=driver;
}
//method for register with parameters of registration
public void Register(String firstName, String lastName, String Email, String Company, String Password,String ConfirmPassword) {
	// create visually attractive reports for Selenium tests
			// setting the path for the extent reports
	reporter=new ExtentSparkReporter(".\\Datafiles\\Extent-Reports\\Register.html");
	//Setting the page title of report
	  reporter.config().setDocumentTitle("Registration Page");
	  //setting the report name
      reporter.config().setReportName("Registration Valid and Invalid details");
    //Setting the system info we wanted to be in the extent reports
      extent = new ExtentReports();
      extent.attachReporter(reporter);
      extent.setSystemInfo("Host Name", "Local Host");
      extent.setSystemInfo("Tester", "Ganesh.R");
      extent.setSystemInfo("Environment", "Quality Assurance(QA)");
      extent.setSystemInfo("OS", "Windows");
		test=extent.createTest("Login Test","This is test to validate the Register Functionality");
		
		test.info("Test case");
		//Clicking on register button to start the registration
	driver.findElement(registerbutton).click();    
	test.pass("Register Button Clicked");
	//Selecting the Gender
	driver.findElement(gender).click();   
	test.pass("Gender is Selected");
	//Entering the user first name
	driver.findElement(firstname).sendKeys(firstName);
	test.pass("Firste Name entered");
	//Entering the user last name
	driver.findElement(lastname).sendKeys(lastName);
	test.pass("Last Name Entered");
	//Selecting the user  Date month and year of birth
	driver.findElement(day).click();
	driver.findElement(month).click();
	driver.findElement(year).click();
	test.pass("Date of birth Selected");
	//Entering the Email of the user
	driver.findElement(email).sendKeys(Email);
	test.pass("Email has been entered");
	//Entering the Company Name
	driver.findElement(company).sendKeys(Company);
	test.pass("Company name has been entered");
	//Verifying whether the check box is displayed
	boolean NewsSelect = driver.findElement(newsletter).isDisplayed();
	System.out.println("Checkbox "+NewsSelect);
	test.pass("New Letter has been selected");
	//Entering the Password 
	driver.findElement(password).sendKeys(Password);
	test.pass("Password has been accepted");
	//Entering the password for re confirmation
	driver.findElement(confirmPassword).sendKeys(ConfirmPassword);
	test.pass("Password Confirmed succesfully");
	//Clicking on registration button
	driver.findElement(registration).click();
	test.pass("Clicked on register for registration");
	//Storing the message of registration
	 reSult=driver.findElement(result).getText();
	 Result = driver.findElement(result).isDisplayed();
	if(Result) {
		System.out.println("Registration Message: "+reSult);
	}
	
	test.pass("Registration Successsfull");
	test.info("Closing the browser");
	// to erase any previous data on the report and create a new report.
	extent.flush();
	
}

}