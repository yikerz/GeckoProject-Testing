package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LogoutStepDef {
	private WebDriver driver = WebDriverManager.getDriver();
	private int sleepTime = 500;

	@Given("A user is at the home page")
	public void a_user_is_at_the_home_page() throws InterruptedException {
		assertTrue(HomePage.isDisplayed(driver));
	  Thread.sleep(sleepTime);
	}

	@When("The logout button is clicked")
	public void the_logout_button_is_clicked() throws InterruptedException {
		HomePage.logoutButton(driver).click();	    
		Thread.sleep(sleepTime);
	}

	@Then("The login page should be displayed")
	public void the_login_page_should_be_displayed() throws InterruptedException {
	  assertTrue(LoginPage.isDisplayed(driver));
	  Thread.sleep(sleepTime);
	}
}
