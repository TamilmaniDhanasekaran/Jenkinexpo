package bSathyaPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aSathyaBasement.Basement;

//Code for Second TV
public class SamsungTv2 extends Basement 
{
	@FindBy(xpath="//h1[@class='pd-name pd-name-sm']")
	WebElement tvtitle;
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	WebElement features;

	@FindBy(xpath="(//td[@class='pd-spec-value'])[1]")
	WebElement brand;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[2]")
	WebElement screensize;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[3]")
	WebElement televisiontype;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[4]")
	WebElement displaytype;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[5]")
	WebElement displayfeatures;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[6]")
	WebElement audiofeatures;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[7]")
	WebElement videofeatures;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[13]")
	WebElement warrenty;

	//Initialize the WebElement Using PageFactory
	public SamsungTv2()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Validate the TV Title
	public boolean validateSamsungTv2Title()
	{
		return tvtitle.isDisplayed();
	}

	//Code to Fetch TV Feature 
	public String[] clickFeature() throws IOException, InterruptedException
	{
			
		  features.click();
		  
		  Thread.sleep(4000);
			String brandTv2 = brand.getText();
			String screenTv2 = screensize.getText();
			String televisiontypeTv2 = televisiontype.getText();
			String displaytypeTv2 = displaytype.getText();
			String displayfeatureTv2 = displayfeatures.getText();
			String audiofeatureTv2 = audiofeatures.getText();
			String videofeaturesTv2 = videofeatures.getText();
			String warrentyTv2 = warrenty.getText();
			
			String[] featuresdata= {brandTv2, screenTv2, televisiontypeTv2, displaytypeTv2, displayfeatureTv2, audiofeatureTv2, videofeaturesTv2, warrentyTv2};
			return featuresdata;
		 
	}


}
