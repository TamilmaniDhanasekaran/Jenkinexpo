package bSathyaPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aSathyaBasement.Basement;

//Code for Third TV
public class SamsungTv3 extends Basement 
{

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
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[6]")
	WebElement displayfeatures;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[7]")
	WebElement audiofeatures;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[8]")
	WebElement videofeatures;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[14]")
	WebElement warrenty;

	//Initialize the WebElement Using PageFactory
	public SamsungTv3()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Validate the Page Title
	public String validateSamsungTvPage()
	{
		return driver.getTitle();
	}
	
	//Code to Fetch TV Feature Detail
	public String[] featureClick() throws InterruptedException, IOException
	{
			features.click();
			Thread.sleep(4000);
			String brandTv3 = brand.getText();
			String screenTv3 = screensize.getText();
			String televisiontypeTv3 = televisiontype.getText();
			String displaytypeTv3 = displaytype.getText();
			String displayfeatureTv3 = displayfeatures.getText();
			String audiofeatureTv3 = audiofeatures.getText();
			String videofeaturesTv3 = videofeatures.getText();
			String warrentyTv3 = warrenty.getText();
			
			String[] featuresdata= {brandTv3, screenTv3, televisiontypeTv3, displaytypeTv3, displayfeatureTv3, audiofeatureTv3, videofeaturesTv3, warrentyTv3};
			return featuresdata;
	}
	
}
