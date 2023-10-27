package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverManager {
	private static WebDriver driver;
	
	@Before
	public void setUp() {
		System.out.println("Testing...");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
