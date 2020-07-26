package aSathyaTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import aSathyaBasement.Basement;
import bSathyaPages.HomePage;
import bSathyaPages.LoginPage;
import fSathyaExtentReportListener.SathyaTestNGListener;


//Login Test Case
public class LoginPageTest extends Basement 
{
	//Creating Object for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;

	public LoginPageTest()
	{
		super(); //Invoking Base CLass Constructor
	}

	@BeforeMethod
	public void setUp()
	{
		initialization(); //Launch Browser
		loginpageObj = new LoginPage();
	}
		
	@Test(priority = 1)
	public void loginpagetitleTest()
	{
		//Test Case to Validate Login Page
		String title=loginpageObj.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	}

	@Test(priority = 2)
	public void loginTest()
	{
		//TestCase to Login the Application
		loginpageObj.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit(); //Close the Browser
	}

}
