package aSathyaTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import aSathyaBasement.Basement;
import bSathyaPages.HomePage;
import bSathyaPages.LoginPage;
import bSathyaPages.TelevisionPage;
import bSathyaPages.UltraHDTvPage;

//Test Case for Television Page
public class TelevisionPageTest extends Basement
{

	//Creating Object for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;
	TelevisionPage televisionpageObj;
	UltraHDTvPage ultrahdtvpageObj;

	public TelevisionPageTest()
	{
		super(); //Invoking Base Class Constructor
	}

	@BeforeMethod
	public void setUp()
	{
		initialization(); //Launch Browser
		ultrahdtvpageObj = new UltraHDTvPage();
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("email"), "password"); //Enter into App
		televisionpageObj = homepageObj.clickTelevisionPage(); //Enter into Television Page
	}

	@Test(priority = 1)
	public void validateTelevisionPageTest()
	{
		//Test to Check Television Page Title 
		String title = televisionpageObj.validateTelevisionPage();
		Assert.assertEquals(title, "Buy LED TV Online | LED TV Online Shopping - SATHYA");
	}

	@Test(priority = 2)
	public void clickUltraHDTvTest()
	{
		//Test to Enter UltraHD Page
		ultrahdtvpageObj = televisionpageObj.clickUltraHDtv();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit(); //CLose Browser
	}

}
