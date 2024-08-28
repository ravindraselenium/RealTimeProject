package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class HomePage {
	WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By userName_l = By.xpath("//span[@class='oxd-userdropdown-tab']");

	public By getMenuLocator(String menuName) {
		return By.xpath("//span[text()='" + menuName + "']");
	}

	public void verifyLoggedInUser() {

		WebElement userName_e = driver.findElement(userName_l);
		//org.junit.Assert.assertEquals(userName_e.getText(), "manda user");
	}

	public void navigateToSideMenuItems(String menu) {

		WebElement menu_e = driver.findElement(getMenuLocator(menu));
		menu_e.click();

	}

}
