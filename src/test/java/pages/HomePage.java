package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public static String url = "http://localhost:3000/";
	
	public static boolean isDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.urlToBe(url));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static WebElement logoutButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Logout']"));
	}
	
}
