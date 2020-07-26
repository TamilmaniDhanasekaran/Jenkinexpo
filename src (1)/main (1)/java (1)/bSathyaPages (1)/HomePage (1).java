package bSathyaPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aSathyaBasement.Basement;

//Code for Home Page
public class HomePage extends Basement
{

	@FindBy(xpath = "//img[@title='SATHYA']")
	WebElement sathyalogo;
	
	@FindBy(xpath = "(//a[@class='nav-link dropdown-toggle'])[2]")
	WebElement audio;
	
	@FindBy(id="dropdown-heading-42")
	WebElement television;

	//Initialize the WebElement Using Page Factory
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Validate the Home Page Title
	public boolean validateHomePage()
	{
		return sathyalogo.isDisplayed();
		
	}

	//Click the Television Page
	public TelevisionPage clickTelevisionPage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(audio).build().perform();
		television.click();
		
		return new TelevisionPage();
	}
}
