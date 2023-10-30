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
	public void the_link_text_is_clicked(String string) throws InterruptedException {
		LoginPage.resetLinkText(driver).click();
		Thread.sleep(sleepTime);
	}

	@Then("The site should navigate to {string} page")
	public void the_site_should_navigate_to_page(String string) throws InterruptedException {
		assertTrue(ResetPage.isDisplayed(driver));
		Thread.sleep(sleepTime);
	}

	@When("The user insert {string} in the Email field")
	public void the_user_insert_in_the_email_field(String emailAddress) throws InterruptedException {
		ResetPage.emailField(driver).sendKeys(emailAddress);
		Thread.sleep(sleepTime);
	}

	@When("The {string} is clicked")
	public void the_is_clicked(String string) throws InterruptedException {
		ResetPage.sendCodeButton(driver).click();
		Thread.sleep(sleepTime);
	}

	@Then("The {string} button should be displayed")
	public void the_button_should_be_displayed(String string) {
		assertTrue(ResetPage.resetButton(driver).isDisplayed());
	}
	
	@When("The user open a new window and nagivate to Gmail")
	public void the_user_open_a_new_window_and_nagivate_to_gmail() throws InterruptedException {
		driver4gmail = new ChromeDriver();
		driver4gmail.get("https://mail.google.com");  
		Thread.sleep(sleepTime);
	}
	
	@When("Login with the email and password")
	public void login_with_the_email_and_password() throws InterruptedException {
	    GmailPage.emailField(driver4gmail).sendKeys("Yikerz.Testing@gmail.com");
	    Thread.sleep(sleepTime);
	    GmailPage.idNextButton(driver4gmail).click();
	    Thread.sleep(sleepTime);
	    GmailPage.passField(driver4gmail).sendKeys("");
	    Thread.sleep(sleepTime);
	    GmailPage.passNextButton(driver4gmail).click();
	    Thread.sleep(sleepTime);
	}

	@Then("The user should receive a new email with a verification code")
	public void the_user_should_receive_a_new_email_with_a_verification_code() throws InterruptedException {
		String emailContent = GmailPage.emailContent(driver4gmail).getText();
		code = emailContent.substring(emailContent.lastIndexOf(" ")+1);
		GmailPage.hoverEmail(driver4gmail);
		Thread.sleep(sleepTime);
		GmailPage.deleteEmail(driver4gmail);
		Thread.sleep(sleepTime);
		driver4gmail.close();
	}
	
	@When("The user insert the code and new password {string}")
	public void the_user_insert_the_code_and_new_password(String password) throws InterruptedException {
		ResetPage.codeField(driver).sendKeys(code);
		Thread.sleep(sleepTime);
		ResetPage.passwordField(driver).sendKeys(password);
		Thread.sleep(sleepTime);
		ResetPage.confirmPasswordField(driver).sendKeys(password);
		Thread.sleep(sleepTime);
	}

	@When("Click {string} button")
	public void click_button(String string) {
		ResetPage.resetButton(driver).click();
	}
		
}
