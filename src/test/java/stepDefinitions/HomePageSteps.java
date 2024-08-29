package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.DriverFactory;

public class HomePageSteps {

	WebDriver driver = DriverFactory.getDriver();
	HomePage homePage = new HomePage(driver);

	@Then("I navigate to home page")
	public void i_should_be_logged_in_successfully() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.verifyLoggedInUser();
	}
	
	@When("I navigate To {string}")
	public void navigateTOMenu(String menu) {
		homePage.navigateToSideMenuItems(menu);
	}

}
