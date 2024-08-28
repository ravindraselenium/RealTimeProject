package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By userName_l = By.name("username");

	By password_l = By.name("password");

	By login_l = By.xpath("//button[@type='submit']");

	// Actions
	public void enterUsername(String username) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement userNameElement = driver.findElement(userName_l);
		userNameElement.sendKeys(username);
	}

	public void enterPassword(String password) {
		WebElement userNameElement = driver.findElement(password_l);
		userNameElement.sendKeys(password);
	}

	public void clickLoginButton() {
		WebElement login_e = driver.findElement(login_l);
		login_e.click();
	}
}
