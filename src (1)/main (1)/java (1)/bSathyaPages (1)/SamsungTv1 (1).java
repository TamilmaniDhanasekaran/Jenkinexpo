package bSathyaPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aSathyaBasement.Basement;
import dSathyaUtil.SathyaUtil;

//Code for First TV
public class SamsungTv1 extends Basement
{
	
	
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	WebElement features;
	
	@FindBy(xpath="//td[@class='pd-spec-value']")
	WebElement brand;
	
	@FindBy(xpath = "(//td[@class='pd-spec-value'])[2]")
	WebElement screensize;
	
	@FindBy(xpath = "(//td[@class='pd-spec-value'])[3]")
	WebElement televisiontype;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[4]")
	WebElement displaytype;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[7]")
	WebElement displayfeature;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[8]")
	WebElement audiofeature;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[9]")
	WebElement videofeature;
	
	@FindBy(xpath="(//td[@class='pd-spec-value'])[16]")
	WebElement warranty;
	
	
	//Initialize the WebElement Using PageFactory
	public SamsungTv1()
	{
		PageFactory.initElements(driver, this);
	}

	//Validate the TV Page Title
	public String validateSamsungTv1Title()
	{
		return driver.getTitle();
		
	}
	
	//Code to Write the TV Feature Details
	public void clickFeature() throws Exception
	{
		features.click();
		Thread.sleep(4000);
		src=new File(SathyaUtil.WRITEDATA_SHEET_PATH); //Achieved Code Re usability and Code Modularity
		fis=new FileInputStream(src);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.createSheet(SathyaUtil.WRITEDATA_SHEET_NAME);
		
		row0 = sheet.createRow(0);
		String[] header= {"S.No", "Brand Name", "Screensize", "Television Type", "Display Type", "Display Feature", "Audio Features", "Video Features", "Warranty"};
		
				
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		for(int a=0;a<header.length;a++)
		{
			sheet.getRow(0).createCell(a).setCellValue(header[a]);
			sheet.getRow(0).getCell(a).setCellStyle(style);
		}
		
		row1=sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("1");
		sheet.getRow(1).createCell(1).setCellValue(brand.getText());
		sheet.getRow(1).createCell(2).setCellValue(screensize.getText());
		sheet.getRow(1).createCell(3).setCellValue(televisiontype.getText());
		sheet.getRow(1).createCell(4).setCellValue(displaytype.getText());
		sheet.getRow(1).createCell(5).setCellValue(displayfeature.getText());
		sheet.getRow(1).createCell(6).setCellValue(audiofeature.getText());
		sheet.getRow(1).createCell(7).setCellValue(videofeature.getText());
		sheet.getRow(1).createCell(8).setCellValue(warranty.getText());
		
		fos=new FileOutputStream(src);
		workbook.write(fos);
		workbook.close();
	
	}
	
	

}
