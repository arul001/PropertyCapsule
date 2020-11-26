package propertycapsule.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import propertycapsule.qa.base.Base;
import propertycapsule.qa.pages.ContactUsPage;
import propertycapsule.qa.pages.HomePage;
import propertycapsule.qa.pages.ThankYouPage;

public class HomePageTest extends Base {

	HomePage homepage;
	ContactUsPage contactuspage;
	ThankYouPage thankyoupage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		contactuspage = new ContactUsPage();

	}

	@Test(priority = 2)
	public void homepageTitleTest() {
		String title = homepage.verifyhomepagetitle();
		Assert.assertEquals(title,
				"PROPERTY CAPSULE: Retail + Commercial Real Estate iPad Leasing App, Automated Marketing Flyers, Site Plans, & More");

		System.out.println("Current title is : " + title);
		System.out.println(
				"Expected title is : PROPERTY CAPSULE: Retail + Commercial Real Estate iPad Leasing App, Automated Marketing Flyers, Site Plans, & More ");
	}

	@Test(priority = 1)
	public void homepageUrlTest() {
		String url = homepage.verifyhomepageurl();
		Assert.assertEquals(url, "https://www.propertycapsule.com/");
	}

	@Test(priority = 4)
	public void LogoTest() {
		boolean flag = homepage.verifylogo();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
