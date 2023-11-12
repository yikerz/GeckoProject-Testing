package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChenxiSampleTest {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = WebDriverManager.chenxiSetUp();
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
	}

	@Test 
	public void test_login() {
		driver.get("http://localhost:3000/login");
		driver.manage().window().maximize();
		WebElement usernameField = driver.findElement(By.id("email"));
		usernameField.sendKeys("Yikerz.Testing+1@gmail.com");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Testing@1");
		WebElement signinButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/form/button"));
		signinButton.click();
		Duration waitTime = Duration.ofSeconds(10);
		driver.manage().timeouts().implicitlyWait(waitTime);
		String expectedUsernameDisplayed = "Travis";
		String actualUsernameDisplayed = driver.findElement(By.className("/MuiTypography-root MuiTypography-subtitle2 css-w82rd8-MuiTypography-root")).getText();
		assertEquals(expectedUsernameDisplayed, actualUsernameDisplayed);
	}
	
	@Test @Ignore
	public void login() {
		driver.get("http://localhost:3000/login");
		driver.manage().window().maximize();
		WebElement usernameField = driver.findElement(By.id("email"));
		usernameField.sendKeys("Yikerz.Testing+1@gmail.com");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Testing@1");
		WebElement signinButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/form/button"));
		signinButton.click();
	}

}
