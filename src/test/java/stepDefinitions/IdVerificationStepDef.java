package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.IdVerificationPage;
import pages.SuccessPage;

public class IdVerificationStepDef {
	private WebDriver driver = WebDriverManager.getDriver();
	private int sleepTime = 500;
	
	@When("Click the ID Verification on the NavBar")
	public void click_the_id_verification_on_the_nav_bar() throws InterruptedException {
		HomePage.idVerifyButton(driver).click();
		Thread.sleep(sleepTime);
	}

	@Then("The ID verification page should be displayed")
	public void the_id_verification_page_should_be_displayed() throws InterruptedException {
		assertTrue(IdVerificationPage.isDisplayed(driver));
		Thread.sleep(sleepTime);
	}
	
	@When("Click the {int}-th delete icon button")
	public void click_the_th_delete_icon_button(Integer int1) {
		IdVerificationPage.deleteButton(driver, 1).click();
	}

	@Then("The default row is not displayed")
	public void the_default_row_is_not_displayed() {
		int numOfRows = IdVerificationPage.categoryInputs(driver).size();
		assertEquals(0, numOfRows);
	}

	@When("Add primary, secondary and tertiary documents")
	public void add_primary_secondary_and_tertiary_documents() throws InterruptedException {
		IdVerificationPage.addMoreButton(driver).click();
		Thread.sleep(sleepTime);
		IdVerificationPage.addMoreButton(driver).click();
		Thread.sleep(sleepTime);
		IdVerificationPage.addMoreButton(driver).click();
		Thread.sleep(sleepTime);
		IdVerificationPage.categoryDropDown(driver).click();
		Thread.sleep(sleepTime);
	}

	@When("Click submit button")
	public void click_submit_button() {
		IdVerificationPage.submitButton(driver).click();
	}

	@Then("{string} is displayed")
	public void is_displayed(String expectedMessage) {
		String message = SuccessPage.successMessage(driver).getText();
		assertEquals(expectedMessage, message);
	}

	@Then("The MySQL database should be updated with the document information")
	public void the_my_sql_database_should_be_updated_with_the_document_information() {

	}
}
