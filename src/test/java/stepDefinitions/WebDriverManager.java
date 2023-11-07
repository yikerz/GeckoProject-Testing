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
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//		System.setProperty("webdriver.chrome.binary", "src/test/resources/chrome-win64/chrome.exe");
		driver = new ChromeDriver();
		
//		ChromeOptions options = new ChromeOptions();
//		options.setBinary("src/test/resources/chrome-win64/chrome.exe");
//		WebDriver driver = new ChromeDriver(options);
//		driver.get("https://www.google.com/");
	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriver chenxiSetUp() {
		driver = new ChromeDriver();
		return driver;
	}
	
}