package bSathyaPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aSathyaBasement.Basement;

//Code for UltraHD TV
public class UltraHDTvPage extends Basement
{

	@FindBy(xpath="//a[@title='Show details for Samsung LED UA55NU7090']")
	WebElement tv7090;
	
	@FindBy(xpath="//a[@title='Show details for Samsung LED UA43RU7100']")
	WebElement tv7100;

	@FindBy(xpath="//a[@title='Show details for Samsung LED UA55RU7100']")
	WebElement tvU7100;

	@FindBy(xpath="//a[@title='Samsung LED UA65RU7100']")
	WebElement tv657100;
	
	//Initialize the WebElement Using PageFactory
	public UltraHDTvPage()
	{ 
		PageFactory.initElements(driver, this);
	}

	//Validate the Page
	public String validateUltraHDtvPage()
	{
		return driver.getTitle();
	}

	//Click TV 1
	public SamsungTv1 clickSamsungTV1()
	{
		tv7090.click();
		
		return new SamsungTv1();
	}
	
	//Click TV 2
	public SamsungTv2 clickSamsungTV2()
	{
		tv7100.click();
		
		return new SamsungTv2();
	}

	//Click TV 3
	public SamsungTv3 clickSamsungTV3()
	{
		tvU7100.click();
		
		return new SamsungTv3();
	}

	//Click TV 4
	public SamsungTv4 clickSamsungTV4() throws InterruptedException
	{
		tv657100.click();
		Thread.sleep(3000);
		
		return new SamsungTv4();
	}
	
}
