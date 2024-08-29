package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	public Properties readPropertiesFile() throws IOException {

		String propertiesFilePath = FrameworkConstants.getPropertiesFilePath();

		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(propertiesFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

	public WebElement customWait(WebDriver driver, WebElement element, String waitType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getDefaultTimeout()));

		switch (waitType.toLowerCase()) {
		case "clickable":
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		case "visible":
			return wait.until(ExpectedConditions.visibilityOf(element));
		case "invisible":
			wait.until(ExpectedConditions.invisibilityOf(element));
			return element; // Returning element, but usually invisible elements aren't interacted with
		case "present":
			return wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

		case "textpresent":
			return wait.until(ExpectedConditions.textToBePresentInElement(element, element.getText())) ? element : null;
		default:
			throw new IllegalArgumentException("Invalid wait type: " + waitType);
		}
	}

	public WebElement customWait(WebDriver driver, By locator, String waitType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getDefaultTimeout()));
		WebElement element = null;

		switch (waitType.toLowerCase()) {
		case "clickable":
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			break;
		case "visible":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;
		case "invisible":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			// Optional: Return null or a placeholder element if needed
			break;
		case "present":
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			break;
		case "textpresent":
			// Assuming you want to wait for specific text in an element, specify the text
			// in the method call
			String textToBePresent = "someText"; // Replace with actual text to be checked
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, textToBePresent));
			element = driver.findElement(locator); // Return the found element
			break;
			
		default:
			throw new IllegalArgumentException("Invalid wait type: " + waitType);
		}

		return element;
	}

}
