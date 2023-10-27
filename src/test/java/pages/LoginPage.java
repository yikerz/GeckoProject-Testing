package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public static String url = "http://localhost:3000/login";
	
	public static void navigate(WebDriver driver) {
		driver.get(url);
	}
	
	public static WebElement emailField(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}
	
	public static WebElement passwordField(WebDriver driver) {
		return driver.findElement(By.id("password"));
	}
	
	public static WebElement signInButton(WebDriver driver) {
		return driver.findElement(By.cssSelector("button[type='submit']"));
	}
	
	public static boolean isDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(url));
		String currentURL = driver.getCurrentUrl();
		return url.equals(currentURL);
	}
	
	public static WebElement incorrectLoginAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By alertLocator = By.xpath("//div[contains(text(), 'Incorrect')]");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(alertLocator));
	}
	
	
}
