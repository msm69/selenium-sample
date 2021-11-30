package tests;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void setupDriver() throws Exception {
		String host = "localhost";
		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String completeUrl = "http://" + host + ":4444";

		if (isFirefox()) {
			this.driver = new RemoteWebDriver(new URL(completeUrl), new FirefoxOptions());
		} else {
			this.driver = new RemoteWebDriver(new URL(completeUrl), new ChromeOptions());
		}
	}

	@AfterTest
	public void quiteDriver() {
		this.driver.quit();
	}

	private boolean isFirefox() {
		if (System.getProperty("BROWSER") == null) {
			return false;
		}
		if (System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			return true;
		}
		return false;
	}

}
