//Author:      	Manikandan Krishnamoorthy
//Title:       	PageObjectModel with TestNG TDD Framework (Maven Project)
//Scope:  	   	Fetching the Product Details and Write into Spreadsheet | Read the User Address From Spreadsheet
//Application: 	Sathya E-Commerce Website
//Concept Used: JAVA, SELENIUM WEBDRIVER, POM, TestNG - Annotation, Priority, Listeners, DataDriven Approach, Apache POI

package aSathyaBasement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dSathyaUtil.SathyaUtil;

//Base Class to Launch Browser and Enter URL
public class Basement 
{

	//Declaring Static Variables
	public static WebDriver driver;
	public static Properties prop;
	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row0;
	public static XSSFRow row1;
	public static XSSFRow row2;
	public static XSSFRow row3;
	public static FileOutputStream fos;
	
	
	// Constructor to initialize the property file
	public Basement()
	{
		
		try {
			prop = new Properties();
			FileInputStream ip;
			ip = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SathyaProject\\src\\main\\java\\cSathyaConfig\\config.properties");
			prop.load(ip);
			}
		catch (IOException e) 
			{				
			e.printStackTrace();
			}	
	}

	// Launching Browser 
	public static void initialization()
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Timeout is Defined in Util Class So That We Change Easily Without Disturb the Code
		driver.manage().timeouts().pageLoadTimeout(SathyaUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(SathyaUtil.IMPLICT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

	//Code for Take a Screenshot for Failed Test Case 
	public void failedTestCase(String failMethodName)
	{
		
		try {
			File fileObj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			org.apache.commons.io.FileUtils.copyFile(fileObj, new File("C:\\Users\\hp\\eclipse-workspace\\SathyaProject\\"
					+ "SathyaScreenshots\\"+failMethodName+"_"+".png"));
			}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
