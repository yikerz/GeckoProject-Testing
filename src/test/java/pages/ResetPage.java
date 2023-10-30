package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPage {
	public static String url = "http://localhost:3000/resetPassword"; 
			
	public static boolean isDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.urlToBe(url));			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static WebElement emailField(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}

	public static WebElement sendCodeButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Send Verification Code']"));
	}

	public static WebElement resetButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Reset Password']")));
	}
	
	public static WebElement codeField(WebDriver driver) {
		return driver.findElement(By.id("code"));
	}
	
	public static WebElement passwordField(WebDriver driver) {
		return driver.findElement(By.id("password"));
	}
	
	public static WebElement confirmPasswordField(WebDriver driver) {
		return driver.findElement(By.id("confirmPassword"));
	}
	
}
