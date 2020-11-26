package propertycapsule.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import propertycapsule.qa.base.Base;

public class ContactUsPage extends Base {

	@FindBy(id = "FirstName")
	WebElement FirstName;

	@FindBy(id = "LastName")
	WebElement LastName;

	@FindBy(xpath = "//input[@type='email']")
	WebElement Email;

	@FindBy(className = "mktoButton")
	WebElement submit;
	
	public static String url;

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	public ThankYouPage createNewContact(String firstName, String lastName, String email) {
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		Email.sendKeys(email);
		submit.click();	
		return new ThankYouPage();
	}

}
