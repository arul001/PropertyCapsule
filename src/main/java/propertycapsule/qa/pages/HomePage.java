package propertycapsule.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import propertycapsule.qa.base.Base;

public class HomePage extends Base {

	@FindBy(xpath = "//header/div[1]/a[1]/img[1]")
	WebElement LogoImage;

	@FindBy(xpath = "//a[contains(text(),'See for yourself')]")
	WebElement SeeYourSelf;

	// initializing the page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String verifyhomepagetitle() {
		return driver.getTitle();
	}

	public String verifyhomepageurl() {
		return driver.getCurrentUrl();
	}

	public Boolean verifylogo() {
		return LogoImage.isDisplayed();
	}

	public ContactUsPage clickOnSeeForYourselfLink() {
		SeeYourSelf.click();
		return new ContactUsPage();

	}
}
