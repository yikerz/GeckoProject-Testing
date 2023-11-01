package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GmailPage;
import pages.LoginPage;
import pages.ResetPage;

public class ResetPassStepDef {
	private WebDriver driver = WebDriverManager.getDriver();
	private int sleepTime = 1000;
	WebDriver driver4gmail;
	String code;
	
	@When("The link text {string} is clicked")
	public void the_link_text_is_clicked(String linkText) throws InterruptedException {
		LoginPage.linkText(driver, linkText).click();
		Thread.sleep(sleepTime);
	}

	@Then("The site should navigate to reset-password page")
	public void the_site_should_navigate_to_reset_page() throws InterruptedException {
		assertTrue(ResetPage.isDisplayed(driver));
		Thread.sleep(sleepTime);
	}

	@When("The user insert {string} in the Email field")
	public void the_user_insert_in_the_email_field(String emailAddress) throws InterruptedException {
		ResetPage.emailField(driver).sendKeys(emailAddress);
		Thread.sleep(sleepTime);
	}

	@When("The Send Verification Code button is clicked")
	public void the_send_code_button_is_clicked() throws InterruptedException {
		ResetPage.sendCodeButton(driver).click();
		Thread.sleep(sleepTime);
	}

	@Then("The Reset Password button should be displayed")
	public void the_reset_button_should_be_displayed() {
		assertTrue(ResetPage.resetButton(driver).isDisplayed());
	}
		
	@When("The user insert the code and new password {string}")
	public void the_user_insert_the_code_and_new_password(String password) throws InterruptedException {
		ResetPage.codeField(driver).sendKeys(CheckMailStepDef.code);
		Thread.sleep(sleepTime);
		ResetPage.passwordField(driver).sendKeys(password);
		Thread.sleep(sleepTime);
		ResetPage.confirmPasswordField(driver).sendKeys(password);
		Thread.sleep(sleepTime);
	}

	@When("Click Reset Password button")
	public void click_reset_button() {
		ResetPage.resetButton(driver).click();
	}
		
}
