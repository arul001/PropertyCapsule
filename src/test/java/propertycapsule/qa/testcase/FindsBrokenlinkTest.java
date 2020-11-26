package propertycapsule.qa.testcase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import propertycapsule.qa.base.Base;
import propertycapsule.qa.pages.HomePage;

public class FindsBrokenlinkTest extends Base {

	HomePage homepage;

	public FindsBrokenlinkTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}

	@Test
	public void brokenlinkTest() throws IOException {
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("No of links are" + linkList.size());

		List<WebElement> activelinks = new ArrayList<WebElement>();

		for (int i = 0; i < linkList.size(); i++) {
			if (linkList.get(i).getAttribute("href") != null) {
				activelinks.add(linkList.get(i));
			}

		}
		System.out.println("Links are " + activelinks.size());

		for (int j = 0; j < activelinks.size(); j++) {
			HttpURLConnection con = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
					.openConnection();
			con.connect();

			String resp = con.getResponseMessage();
			con.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href") + "----->" + resp);
		}
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
