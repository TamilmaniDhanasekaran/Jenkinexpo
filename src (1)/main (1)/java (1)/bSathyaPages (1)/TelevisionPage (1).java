package bSathyaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aSathyaBasement.Basement;

//Code for Television Page
public class TelevisionPage extends Basement
{

	@FindBy(xpath="//a[@title='Ultra HD']")
	WebElement ultrahd;

	//Initialize WebElement Using PageFactory
	public TelevisionPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Validate the Page
	public String validateTelevisionPage()
	{
		return driver.getTitle();
	}
	
	//Click Ultra HD TV
	public UltraHDTvPage clickUltraHDtv()
	{
		
		WebElement ck = ultrahd;
		Click(driver, ck, 60);
		
		return new UltraHDTvPage();
	}

	//Explict Wait
	public static void Click(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
}

