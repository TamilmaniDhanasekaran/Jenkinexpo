package aSathyaTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import bSathyaPages.TelevisionPage;
import bSathyaPages.UltraHDTvPage;
import dSathyaUtil.SathyaUtil;

//Test Case for TV 3
public class SamsungTv3Test extends Basement
{

	//Creating Objects for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;
	TelevisionPage televisionpageObj;
	UltraHDTvPage ultrahdtvpageObj;
	SamsungTv1 samsungtv1Obj;
	SamsungTv2 samsungtv2Obj;
	SamsungTv3 samsungtv3Obj;
	
	
	public SamsungTv3Test()
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
		ultrahdtvpageObj = televisionpageObj.clickUltraHDtv(); //Enter into Ultra HD Page
		samsungtv3Obj = ultrahdtvpageObj.clickSamsungTV3(); //Enter into TV3 Page

	}
	
	@Test(priority = 1)
	public void validateSamsungTvTitleTest()
	{
		//Test Case to Check TV Page
		String title = samsungtv3Obj.validateSamsungTvPage();
		Assert.assertEquals(title, "Buy Samsung LED UA55RU7100 LED Smart TV @ SATHYA Online Shopping");
	}

	@Test(priority = 2, groups = {"smoke"})
	public void writeTv3Data() throws InterruptedException, IOException
	{
		//Test Case to Write TV3 Feature into Excel
				
		String featuresdata[] = samsungtv3Obj.featureClick();
		
		  src=new File(SathyaUtil.WRITEDATA_SHEET_PATH); // Achieved Code Re usability and Code Modularity
		  fis=new FileInputStream(src); 
		  workbook=new XSSFWorkbook(fis);
		  sheet=workbook.getSheet(SathyaUtil.WRITEDATA_SHEET_NAME); 
		  row3=sheet.createRow(3);
		  sheet.getRow(3).createCell(0).setCellValue("3"); 
		  for(int a=0;a<featuresdata.length;a++) 
		  {
			  sheet.getRow(3).createCell(a+1).setCellValue(featuresdata[a]); 
		  }
	  
		  fos=new FileOutputStream(src); 
		  workbook.write(fos); 
		  workbook.close();

		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit(); //CLose Browser
	}
}
