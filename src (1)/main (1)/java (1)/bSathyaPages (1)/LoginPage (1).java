package bSathyaPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aSathyaBasement.Basement;

//Code for Login Page
public class LoginPage extends Basement
{

	@FindBy(xpath="(//a[@class='menubar-link'])[3]")
	WebElement loginclick;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement loginsubmit;
	
	//Initialize the Web Element Using Page Factory
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Validate Login Page Title
	public String validateLoginPageTitle()
	{
		loginclick.click();
		return driver.getTitle();
		
	}
	
	//Login into the Application
	public HomePage login(String name, String pwd)
	{
		
		WebElement ck = loginclick;
		Click(driver, ck, 90);
		email.sendKeys(name);
		password.sendKeys(pwd);
		loginsubmit.click();
		
		return new HomePage();
	}

	//Explict Wait
	public static void Click(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
}
