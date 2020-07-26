package aSathyaTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import dSathyaUtil.SathyaUtil;

//Test Case for TV4
public class SamsungTv4Test extends Basement
{

	//Creating Objects for Page Class
	LoginPage loginpageObj;
	HomePage homepageObj;
	TelevisionPage televisionpageObj;
	UltraHDTvPage ultrahdtvpageObj;
	SamsungTv1 samsungtv1Obj;
	SamsungTv2 samsungtv2Obj;
	SamsungTv3 samsungtv3Obj;
	SamsungTv4 samsungtv4Obj;
	SathyaUtil sathyautilObj;
	
	
	public SamsungTv4Test()
	{
		super(); //Invoking Base Class Constructor
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException
	{
		initialization(); //Initialization
		Thread.sleep(9000);
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("email"), prop.getProperty("password")); //Enter into App
		televisionpageObj = homepageObj.clickTelevisionPage(); //Enter into Television Page
		ultrahdtvpageObj = televisionpageObj.clickUltraHDtv(); //Enter into Ultra HD Page
		samsungtv4Obj = ultrahdtvpageObj.clickSamsungTV4(); //Enter into TV4 Page
		Thread.sleep(3000);
	}
	
	
	  @Test(priority = 1) 
	  public void validateSamsungTv4TitleTest() 
	  { 
		  //Test Case to Check TV4 Page
		  String title = samsungtv4Obj.validateSamsungTv4Page();
		  Assert.assertEquals(title, "Buy Samsung LED UA65RU7100 LED Smart TV @ SATHYA Online Shopping"); 
	  }
	 
	

	
	  @Test(priority = 2, groups = {"smoke"}) 
	  public void writeTv4Data() throws InterruptedException, IOException 
	  { 
			//Test Case to Write TV4 Feature into Excel
		  
		  	String featuresdata[] = samsungtv4Obj.clickFeature();
			
		  	  src=new File(SathyaUtil.WRITEDATA_SHEET_PATH); //Achieved Code Re usability and Code Modularity 
			  fis=new FileInputStream(src); 
			  workbook=new XSSFWorkbook(fis);
			  sheet=workbook.getSheet(SathyaUtil.WRITEDATA_SHEET_NAME); 
			  row3=sheet.createRow(4);
			  sheet.getRow(4).createCell(0).setCellValue("4"); 
			  for(int a=0;a<featuresdata.length;a++) 
			  {
				  sheet.getRow(4).createCell(a+1).setCellValue(featuresdata[a]); 
			  }
		  
			  fos=new FileOutputStream(src); 
			  workbook.write(fos); 
			  workbook.close();

		 
	  
	  }
	 
	
	@DataProvider
	public Iterator<Object[]> getSathyaTestData() throws Exception
	{
		ArrayList<Object[]> mydata= SathyaUtil.getTestData();
		
		return mydata.iterator(); 
		}
	
	@Test(priority = 3, dataProvider = "getSathyaTestData", groups = {"smoke", "sanity"})
	public void entry(String FIRSTNAME, String LASTNAME, String ADDRESS, String CITY, String ZIP, String COUNTRY, String EMAIL, String MOBILE) throws InterruptedException
	{
		//DataDriven Approach Followed Using Data Provider
		//Test Case to Read User Address from Excel
		
		samsungtv4Obj.enterDetails(FIRSTNAME, LASTNAME, ADDRESS, CITY, ZIP, COUNTRY, EMAIL, MOBILE);
		samsungtv4Obj.shipAddress();
		samsungtv4Obj.shippingMethod();
		samsungtv4Obj.shippingConfirm();
	
	
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit(); //Close Browser
	}






}
