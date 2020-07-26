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
import bSathyaPages.TelevisionPage;
import bSathyaPages.UltraHDTvPage;
import dSathyaUtil.SathyaUtil;

//Test Case for TV 2
public class SamsungTv2Test extends Basement
{
	//Creating Object for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;
	TelevisionPage televisionpageObj;
	UltraHDTvPage ultrahdtvpageObj;
	SamsungTv1 samsungtv1Obj;
	SamsungTv2 samsungtv2Obj;
	
	
	public SamsungTv2Test()
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
		samsungtv2Obj = ultrahdtvpageObj.clickSamsungTV2(); //Enter into TV2 Page
		
	}

	
	  @Test(priority = 1) 
	  public void validateSamsungTv2TitleTest() 
	  { 
		  //Test Case to Check TV Page
		  boolean flag = samsungtv2Obj.validateSamsungTv2Title(); 
		  Assert.assertEquals(flag, true); 
	  }
	 
	
	@Test(priority = 2, groups = {"smoke"})
	public void writeTv2Data() throws IOException, InterruptedException
	{
		//Test Case to Write TV2 Feature into Excel
		Thread.sleep(3000);
		String featuresdata[] = samsungtv2Obj.clickFeature();
		
		  src=new File(SathyaUtil.WRITEDATA_SHEET_PATH); //Achieved Code Re usability and Code Modularity
		  fis=new FileInputStream(src); 
		  workbook=new XSSFWorkbook(fis);
		  sheet=workbook.getSheet(SathyaUtil.WRITEDATA_SHEET_NAME); 
		  row2=sheet.createRow(2);
		  sheet.getRow(2).createCell(0).setCellValue("2"); 
		  for(int a=0;a<featuresdata.length;a++) 
		  {
			  sheet.getRow(2).createCell(a+1).setCellValue(featuresdata[a]); 
		  }
	  
		  fos=new FileOutputStream(src); 
		  workbook.write(fos); 
		  workbook.close();

		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit(); //Close Browser
	}
}
