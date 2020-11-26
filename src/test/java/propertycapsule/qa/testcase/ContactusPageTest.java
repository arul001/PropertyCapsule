package propertycapsule.qa.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import propertycapsule.qa.base.Base;
import propertycapsule.qa.pages.ContactUsPage;
import propertycapsule.qa.pages.HomePage;
import propertycapsule.qa.pages.ThankYouPage;
import propertycapsule.qa.util.Utility;

public class ContactusPageTest extends Base {

	HomePage homepage;
	ContactUsPage contactuspage;
	ThankYouPage thankyoupage;

	String sheetName = "contacts";

	public ContactusPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		contactuspage = new ContactUsPage();
		thankyoupage = new ThankYouPage();
	}

	@DataProvider
	public Object[][] getContactTestData() {
		Object data[][] = Utility.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getContactTestData")
	public void createNewContactTest(String firstName, String lastName, String email) {
		homepage.clickOnSeeForYourselfLink();
		contactuspage.createNewContact(firstName, lastName, email);
		thankyoupage.verifylabels();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
