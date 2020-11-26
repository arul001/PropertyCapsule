package propertycapsule.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import propertycapsule.qa.base.Base;

public class ThankYouPage extends Base {
	
	@FindBy(xpath="//span[contains(text(),'THANK YOU!')]")
	WebElement Thankyou;
	
	
	public ThankYouPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifylabels() {
		return Thankyou.isDisplayed();
	}

}
