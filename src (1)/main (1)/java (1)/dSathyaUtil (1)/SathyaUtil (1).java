package dSathyaUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import aSathyaBasement.Basement;
import bSathyaPages.SamsungTv1;
import bSathyaPages.SamsungTv2;
import bSathyaPages.SamsungTv3;
import bSathyaPages.SamsungTv4;

public class SathyaUtil extends Basement
{
	SamsungTv1 samsungtv1Obj;
	SamsungTv2 samsungtv2Obj;
	SamsungTv3 samsungtv3Obj;
	SamsungTv4 samsungtv4Obj;
	

	//Achieved Code Re usability and Code Modularity
	//Declare the Timeout and Spreadsheet Path in the Separate Util class to ensure code modularity
	public static long PAGE_LOAD_TIMEOUT = 90;
	public static long IMPLICT_TIMEOUT = 90;
	public static String WRITEDATA_SHEET_PATH = "C:\\Users\\hp\\eclipse-workspace\\SathyaProject\\src\\main\\java\\eSathyaTestData\\Sathya.xlsx";
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\hp\\eclipse-workspace\\SathyaProject\\src\\main\\java\\eSathyaTestData\\Sathya.xlsx";
	public static String WRITEDATA_SHEET_NAME = "Maven_Sathya";


	//Read the Address Detail From Excel
	public static ArrayList<Object[]> getTestData() throws Exception
	{
		ArrayList<Object[]> data = new ArrayList();
		
		src=new File(TESTDATA_SHEET_PATH);
		fis=new FileInputStream(src);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Address");
		int lastrow=sheet.getLastRowNum();
		DataFormatter df=new DataFormatter();
		
		for(int i=1; i<=lastrow; i++)
		{
			XSSFCell cc=sheet.getRow(i).getCell(0);
			String fname=df.formatCellValue(cc);
			XSSFCell dd=sheet.getRow(i).getCell(1);
			String lname=df.formatCellValue(dd);
			XSSFCell ee=sheet.getRow(i).getCell(2);
			String addressU=df.formatCellValue(ee);
			XSSFCell ff=sheet.getRow(i).getCell(3);
			String cityU=df.formatCellValue(ff);
			XSSFCell gg=sheet.getRow(i).getCell(4);
			String codeU=df.formatCellValue(gg);
			XSSFCell hh=sheet.getRow(i).getCell(5);
			String countryU=df.formatCellValue(hh);
			XSSFCell ii=sheet.getRow(i).getCell(6);
			String emailU=df.formatCellValue(ii);
			XSSFCell jj=sheet.getRow(i).getCell(7);
			String mobileU=df.formatCellValue(jj);
			
			
			Object ob[]= {fname, lname, addressU, cityU, codeU, countryU, emailU, mobileU};
			data.add(ob);
		}
			return data;				
	
	}

			

}
