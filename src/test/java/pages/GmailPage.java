package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {
		
	public static WebElement emailField(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
	}
	
	public static WebElement idNextButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button"));
	}
	
	public static WebElement passField(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
	}
	
	public static WebElement passNextButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button"));
	}
	
	public static WebElement emailContent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[starts-with(text(),'Your password reset code is')]")));
	}

	
	public static void hoverEmail(WebDriver driver) {
		WebElement elementToHover = driver.findElement(By.cssSelector("div[role='tabpanel']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
	}

	public static void deleteEmail(WebDriver driver) {
		driver.findElement(By.cssSelector("li[data-tooltip='Delete']")).click();
	}
	
	
	
}
