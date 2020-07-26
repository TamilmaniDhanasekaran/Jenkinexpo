package aSathyaTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import aSathyaBasement.Basement;
import bSathyaPages.HomePage;
import bSathyaPages.LoginPage;
import bSathyaPages.SamsungTv1;
import bSathyaPages.SamsungTv2;
import bSathyaPages.SamsungTv3;
import bSathyaPages.SamsungTv4;
import bSathyaPages.TelevisionPage;
import bSathyaPages.UltraHDTvPage;

//Test Case for Ultra HD TV Page
public class UltraHDTvTest extends Basement 
{
	//Creating Object for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;
	TelevisionPage televisionpageObj;
	UltraHDTvPage ultrahdtvpageObj;
	SamsungTv1 samsungtv1Obj;
	SamsungTv2 samsungtv2Obj;
	SamsungTv3 samsungtv3Obj;
	SamsungTv4 samsungtv4Obj;
	
	public UltraHDTvTest()
	{
		super(); //Invoking Base Class Constructor
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization(); //Launch Browser
		Thread.sleep(6000);
		samsungtv1Obj = new SamsungTv1();
		samsungtv2Obj = new SamsungTv2();
		samsungtv3Obj = new SamsungTv3();
		samsungtv4Obj = new SamsungTv4();
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("email"), "password"); //Enter into App
		televisionpageObj = homepageObj.clickTelevisionPage(); //Enter into Television Page
		ultrahdtvpageObj = televisionpageObj.clickUltraHDtv(); //Enter into Ultra HD Page
		Thread.sleep(3000);
	}
			
	@Test(priority = 1)
	public void validateUltraHDPageTest()
	{
		//Test Case for Page Title
		String title = ultrahdtvpageObj.validateUltraHDtvPage();
		Assert.assertEquals(title, "Ultra HD Tv : Buy 4K UHD Tv Online @ Best Offer Prices | SATHYA");
	}

	@Test(priority = 2)
	public void clickSamsungTv1Test()
	{
		//Test Case to Enter TV 1
		samsungtv1Obj = ultrahdtvpageObj.clickSamsungTV1();
		
	}

	@Test(priority = 3)
	public void clickSamsungTv2Test()
	{
		//Test Case to Enter TV 2
		samsungtv2Obj = ultrahdtvpageObj.clickSamsungTV2();
	}
	
	@Test(priority = 4)
	public void clickSamsungTv3Test()
	{
		//Test Case to Enter TV 3
		samsungtv3Obj = ultrahdtvpageObj.clickSamsungTV3();
	}
	
	@Test(priority = 5)
	public void clickSamsungTv4Test() throws InterruptedException
	{
		//Test Case to Enter TV 4
		samsungtv4Obj = ultrahdtvpageObj.clickSamsungTV4();
	}


	@AfterMethod
	public void tearDown() 
	{
		driver.quit(); //CLose Browser
	}
}
