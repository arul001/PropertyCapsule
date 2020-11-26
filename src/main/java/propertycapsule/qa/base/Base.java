package propertycapsule.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import propertycapsule.qa.util.Utility;
import propertycapsule.qa.util.WebEventListener;

public class Base {
	public static WebDriver driver;
	public static Properties props;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public final String Config_PATH = "C:/Users/TRINKETS/eclipse-workspace/PropertyCapsule/src/main/java/propertycapsule/qa/config/config.properties";

	public Base() {
		try {
			props = new Properties();
			FileInputStream ip = new FileInputStream(Config_PATH);
			props.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browsername = props.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:/Arul/Automation/driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:/Arul/Automation/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.ImplicityWait, TimeUnit.SECONDS);

		driver.get(props.getProperty("url"));

	}
}
