package aSathyaTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import aSathyaBasement.Basement;
import bSathyaPages.HomePage;
import bSathyaPages.LoginPage;
import bSathyaPages.SamsungTv1;
import bSathyaPages.TelevisionPage;
import bSathyaPages.UltraHDTvPage;

//Test Case for TV1

public class SamsungTv1Test extends Basement
{

	//Creating Object for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;
	TelevisionPage televisionpageObj;
	UltraHDTvPage ultrahdtvpageObj;
	SamsungTv1 samsungtv1Obj;
	
	
	public SamsungTv1Test()
	{
		super(); //Invoking Base Class Constructor
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException
	{
		initialization(); //Launch Browser
		Thread.sleep(9000);
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("email"), prop.getProperty("password")); //Enter into App
		televisionpageObj = homepageObj.clickTelevisionPage(); //Enter into Television Page
		ultrahdtvpageObj = televisionpageObj.clickUltraHDtv(); //Enter into Ultra HD TV Page
		samsungtv1Obj = ultrahdtvpageObj.clickSamsungTV1();  //Enter into TV1 Page
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void validateSamsungTv1Test()
	{
		//Test Case to Check TV1 Page
		String title = samsungtv1Obj.validateSamsungTv1Title();
		Assert.assertEquals(title, "Buy Samsung 55 inch 4K Smart LED TV UA55NU7090 Online @ Best Price");
	}
	
//	@Test(groups = {"smoke"})
//	public void failMethod()
//	{
//		
//		Assert.assertTrue(false);
//	}

	@Test(priority = 2, groups = {"smoke"})
	public void writeTv1Data() throws Exception
	{
		//Test Case to Write Feature Detail into Excel
		
		samsungtv1Obj.clickFeature();
		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit(); //Close Browser
	}
	

}
