package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import common.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.DriverFactory;

public class LoginSteps {

	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	CommonMethods commonMethods = new CommonMethods();

	@Given("I am on OrangrHRM page")
	public void i_am_on_the_login_page() throws IOException {
		Properties prop = commonMethods.readPropertiesFile();
		driver.get(prop.getProperty("url"));
	}

	@When("I enter  {string} and  {string}")
	public void i_enter_username_and_password(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		loginPage.clickLoginButton();
	}

}
