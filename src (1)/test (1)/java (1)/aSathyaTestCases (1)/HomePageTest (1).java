package aSathyaTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import aSathyaBasement.Basement;
import bSathyaPages.HomePage;
import bSathyaPages.LoginPage;
import bSathyaPages.TelevisionPage;

//Home Page Test Case
public class HomePageTest extends Basement 
{
	//Creating Object for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;
	TelevisionPage televisionpageObj;
	
	public HomePageTest()
	{
		super(); //Invoking Base Class Constructor
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); //Launching Browser
		televisionpageObj = new TelevisionPage();
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("email"), prop.getProperty("password")); //Enter into Application
	}
	
	@Test(priority = 1)
	public void validateHomePageTest() 
	{
		//Test Case to Validate Home Page
		boolean flag = homepageObj.validateHomePage();
		Assert.assertEquals(flag, true); 
	}

	@Test(priority = 2)
	public void televisionPageTest()
	{
		//Test Case to go Television Page
		televisionpageObj = homepageObj.clickTelevisionPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit(); //Close the Browser
	}


}
