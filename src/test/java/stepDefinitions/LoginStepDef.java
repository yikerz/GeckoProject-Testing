package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDef {
	private WebDriver driver = WebDriverManager.getDriver();
	private int sleepTime = 500;
			
	@Given("A user access to the login page")
	public void a_user_access_to_the_login_page() throws InterruptedException {
	    LoginPage.navigate(driver);
	    Thread.sleep(sleepTime);
	}

	@When("A {string} and {string} are inserted")
	public void a_almaqdad55_gmail_com_and_password_are_inserted(String email, String password) throws InterruptedException {
		LoginPage.emailField(driver).sendKeys(email);
		LoginPage.passwordField(driver).sendKeys(password);
		Thread.sleep(sleepTime);
	}

	@When("The sign in button is clicked")
	public void the_sign_in_button_is_clicked() throws InterruptedException {
		LoginPage.signInButton(driver).click();
	}

	@When("the refresh button is clicked while the page is loading")
	public void correct_Email_And_Password_Inserted() throws InterruptedException {
		driver.navigate().refresh();
	}
	
	@Then("Redirect back to login page")
	public void redirect_back_to_login_page() {
	    driver.navigate().to("http://localhost:3000/login");
	    assertTrue(LoginPage.isDisplayed(driver));
	}
	
	@Then("The home page should be displayed")
	public void the_home_page_should_be_displayed() throws InterruptedException {
	  assertTrue(HomePage.isDisplayed(driver));
	  Thread.sleep(sleepTime);		
	}

	@Then("The logout button is displayed")
	public void the_logout_button_is_displayed() {
	  assertTrue(HomePage.logoutButton(driver).isDisplayed());
	}

	@Then("Alert with {string} is displayed")
	public void alert_with_is_displayed(String expectedAlert) throws InterruptedException {
		assertTrue(LoginPage.incorrectLoginAlert(driver).isDisplayed());
		assertEquals(expectedAlert, LoginPage.incorrectLoginAlert(driver).getText());
		Thread.sleep(sleepTime);		
	}
	
}
