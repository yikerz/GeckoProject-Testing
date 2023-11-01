package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;

public class SignUpStepDef {
	private WebDriver driver = WebDriverManager.getDriver();
	private int sleepTime = 2000;
	
	@Then("The site should navigate to sign-up page")
	public void the_site_should_navigate_to_sign_up_page() throws InterruptedException {
		assertTrue(SignUpPage.isDisplayed(driver));
		Thread.sleep(sleepTime);
	}

	@When("The user insert sign-up details")
	public void the_user_insert_sign_up_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		SignUpPage.fillDetails(driver, dataTable);
		Thread.sleep(sleepTime);		
	}

	@When("Click the sign-up button")
	public void click_the_sign_up_button() throws InterruptedException {
		SignUpPage.signUpButton(driver).click();
		Thread.sleep(sleepTime);
	}
	
	@Then("The verify button should be displayed")
	public void the_verify_button_should_be_displayed() {
	    assertTrue(SignUpPage.verifyButton(driver).isDisplayed());
	}

	@When("The user insert the code")
	public void the_user_insert_the_code() throws InterruptedException {
		SignUpPage.codeField(driver).sendKeys(CheckMailStepDef.code);
		Thread.sleep(sleepTime);
	}

	@When("Click verify button")
	public void click_verify_button() throws InterruptedException {
		SignUpPage.verifyButton(driver).click();
		Thread.sleep(sleepTime);
	}
}
