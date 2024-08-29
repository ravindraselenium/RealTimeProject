package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverFactory;

public class Hooks {

	// WebDriver instance shared across steps
	private WebDriver driver;

	@Before
	public void launchBrowser() {
		// You can choose the browser based on a system property or config file
		// String browser = System.getProperty("browser", "chrome");
		String browser = "chrome";
		if (browser.equalsIgnoreCase("chrome")) {
			// Set the path to the ChromeDriver executable (if not set in the environment
			// variables)
			// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// Set the path to the GeckoDriver executable (if not set in the environment
			// variables)
			// System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
		}

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set the WebDriver instance in a central place, such as a DriverFactory or a
		// Base class
		DriverFactory.setDriver(driver);
	}

	@After
	public void quitBrowser() {
		// Quit the browser after the scenario
		if (driver != null) {
			driver.quit();
		}
	}
}
