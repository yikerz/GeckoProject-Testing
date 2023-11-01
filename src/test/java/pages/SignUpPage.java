package pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;


public class SignUpPage {
	public static String url = "http://localhost:3000/signup";
	
	public static Boolean isDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.urlToBe(url));
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static WebElement firstNameField(WebDriver driver) {
		return driver.findElement(By.id("givenNames"));
	}
	public static WebElement lastNameField(WebDriver driver) {
		return driver.findElement(By.id("familyName"));
	}
	public static WebElement emailField(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}
	public static WebElement passwordField(WebDriver driver) {
		return driver.findElement(By.id("password"));
	}
	public static WebElement confirmPasswordField(WebDriver driver) {
		return driver.findElement(By.id("confirmPassword"));
	}
	public static WebElement signUpButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Sign Up']"));
	}


	public static void fillDetails(WebDriver driver, DataTable dataTable) {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String firstName = data.get(0).get("FirstName");
		String lastName = data.get(0).get("LastName");
		String email = data.get(0).get("Email") + Integer.toString(randomNumber) + "@gmail.com";
		String password = data.get(0).get("Password");
		String confirmPassword = data.get(0).get("ConfirmPassword");
		firstNameField(driver).sendKeys(firstName);
		lastNameField(driver).sendKeys(lastName);
		emailField(driver).sendKeys(email);
		passwordField(driver).sendKeys(password);
		confirmPasswordField(driver).sendKeys(confirmPassword);	
	}
	
	public static WebElement verifyButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Verify']")));
	}

	public static WebElement codeField(WebDriver driver) {
		return driver.findElement(By.id("code"));
	}
	
	
	
}
