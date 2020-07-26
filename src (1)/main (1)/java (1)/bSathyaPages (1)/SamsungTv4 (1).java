package bSathyaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import aSathyaBasement.Basement;

//Code for Fourth TV
public class SamsungTv4 extends Basement 
{

	@FindBy(xpath="(//li[@class='nav-item'])[3]")
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

	//For Cart
	@FindBy(xpath="//a[@class='btn btn-primary btn-lg btn-block btn-add-to-cart ajax-cart-link']")
	WebElement cart;
	
	
	
	
	@FindBy(xpath = "//a[@class='btn btn-clear btn-block btn-action']")
	WebElement checkout;
	
	@FindBy(id = "NewAddress_FirstName")
	WebElement firstname;
	
	@FindBy(name = "NewAddress.LastName")
	WebElement lastname;
	
	@FindBy(name = "NewAddress.Address1")
	WebElement address1;
	
	@FindBy(id = "NewAddress_City")
	WebElement city;
	
	@FindBy(name = "NewAddress.ZipPostalCode")
	WebElement zipcode;
	
	@FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
	WebElement country;
	
	@FindBy(name = "NewAddress.Email")
	WebElement email;
	
	@FindBy(id = "NewAddress_PhoneNumber")
	WebElement phoneno;
	
	@FindBy(xpath = "//button[@class='btn btn-warning btn-lg new-address-next-step-button']")
	WebElement next;
	
	@FindBy(xpath="(//button[@class='btn btn-warning btn-block select-shipping-address-button'])[1]")
	WebElement shipaddress;
	
	@FindBy(xpath="//button[@class='btn btn-warning btn-lg shipping-method-next-step-button']")
	WebElement shipping;
	
	@FindBy(xpath="//button[@class='btn btn-warning btn-lg payment-method-next-step-button']")
	WebElement confirm;

	//Initialize the WebElement Using PageFactory
	public SamsungTv4()
	{

		PageFactory.initElements(driver, this);
	}
	
	//Validate Page Title
	public String validateSamsungTv4Page()
	{
		return driver.getTitle();
	}

	//Code to Fetch TV Feature
	public String[] clickFeature() throws InterruptedException
	{
		features.click();
		Thread.sleep(4000);
		String brandTv4 = brand.getText();
		String screenTv4 = screensize.getText();
		String televisiontypeTv4 = televisiontype.getText();
		String displaytypeTv4 = displaytype.getText();
		String displayfeatureTv4 = displayfeatures.getText();
		String audiofeatureTv4 = audiofeatures.getText();
		String videofeaturesTv4 = videofeatures.getText();
		String warrentyTv4 = warrenty.getText();
		
		String[] featuresdata= {brandTv4, screenTv4, televisiontypeTv4, displaytypeTv4, displayfeatureTv4, audiofeatureTv4, videofeaturesTv4, warrentyTv4};
		return featuresdata;
	
	}

	//Code to Read the Address Detail from Excel
	public void enterDetails(String fName, String lName, String address, String cityName, String zipNo, String countryName, String emailName, String mobile ) throws InterruptedException
	{
		cart.click();
		Thread.sleep(3000);
		checkout.click();
		Thread.sleep(3000);
		firstname.sendKeys(fName);
		lastname.sendKeys(lName);
		address1.sendKeys(address);
		city.sendKeys(cityName);
		zipcode.sendKeys(zipNo);
		
		Select select = new Select(driver.findElement(By.id("NewAddress_CountryId")));
		select.selectByVisibleText(countryName);
		
		email.sendKeys(emailName);
		
		phoneno.sendKeys(mobile);
		
		next.click();
		
	}
	
	//Code to Ensure Address
	public void shipAddress()
	{
		shipaddress.click();
	}
	
	//Code for Shippment
	public void shippingMethod()
	{
		shipping.click();
	}
	
	//Code to Confirm
	public void shippingConfirm() throws InterruptedException
	{
		confirm.click();
		Thread.sleep(3000);
	}


}