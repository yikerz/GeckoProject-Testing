package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IdVerificationPage {
	public static String url = "http://localhost:3000/idVerification";
	
	public static boolean isDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.urlToBe(url));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static WebElement deleteButton(WebDriver driver, int row) {
		return driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div/div/div[1]/table/tbody/tr["+row+"]/th[5]/button	"));
	}

	public static List<WebElement> categoryInputs(WebDriver driver) {
		return driver.findElements(By.cssSelector("input[name='documentCategory']"));		
	}

	public static WebElement addMoreButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='+ Add More']"));		
	}

	public static WebElement categoryDropDown(WebDriver driver, int row) {
		return driver.findElement(By.xpath("//*[@id='root']/div[2]/main/div/div/div/div[1]/table/tbody/tr["+row+"]/th[1]/div/div/div"));	
	}
	
	public static WebElement categoryOptions(WebDriver driver, int optionIndex) {
		return driver.findElement(By.xpath("//*[@id='menu-documentCategory']/div[3]/ul/li["+optionIndex+"]"));	
	}

	public static WebElement docTypeDropDown(WebDriver driver, int row) {
		return driver.findElement(By.xpath("//*[@id='root']/div[2]/main/div/div/div/div[1]/table/tbody/tr["+row+"]/th[2]/div/div/div"));
	}

	public static WebElement docTypeOptions(WebDriver driver, int optionIndex) {
		return driver.findElement(By.xpath("//*[@id='menu-documentType']/div[3]/ul/li["+optionIndex+"]"));	
	}
	
	public static List<WebElement> uploadButtons(WebDriver driver) {
		return driver.findElements(By.xpath("//span[text()='Upload']"));
	}
	
	public static WebElement fileInput(WebDriver driver, int row) {
		return driver.findElement(By.xpath("//*[@id='raised-button-file-"+row+"']"));		
	}
	
	public static WebElement submitButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Submit']"));
	}

		
}
