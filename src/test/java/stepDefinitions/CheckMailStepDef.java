package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GmailPage;

public class CheckMailStepDef {
	private WebDriver driver4gmail;
	public static String code;
	private int sleepTime = 1000;
	
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
	    GmailPage.passField(driver4gmail).sendKeys("g6Xc{Ov48'H");
	    Thread.sleep(sleepTime);
	    GmailPage.passNextButton(driver4gmail).click();
	    Thread.sleep(sleepTime);
	}
	
	@Then("The user should receive a new email with a {string} code")
	public void the_user_should_receive_a_new_email_with_a_verification_code(String codeType) throws InterruptedException {
		String emailContent = GmailPage.emailContent(driver4gmail, codeType).getText();
		code = emailContent.substring(emailContent.lastIndexOf(" ")+1);
		GmailPage.hoverEmail(driver4gmail);
		Thread.sleep(sleepTime);
		GmailPage.deleteEmail(driver4gmail);
		Thread.sleep(sleepTime);
		driver4gmail.close();
	}
	
}
