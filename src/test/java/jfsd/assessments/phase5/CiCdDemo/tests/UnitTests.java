package jfsd.assessments.phase5.CiCdDemo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnitTests {
	private static WebDriver driver;	
	private final String url = "http://localhost:8001/CiCdDemo"; 
	
	@BeforeAll
	public static void setup() {
		String fileName = "chromedriver";
		if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
			fileName += ".exe";
				
		Path driverPath = Paths.get(System.getProperty("user.dir"), "src", "resources", fileName);
		System.setProperty("webdriver.chrome.driver", driverPath.toString());
		driver = new ChromeDriver();
	}
	
	@AfterAll
	public static void tearDown() {
		if(driver != null)
			driver.quit();
	}
	
	@Test
	public void TestHomePage() {
		driver.navigate().to(url);

		assertEquals("Sign in", driver.getTitle());
		
		WebElement elem = driver.findElement(By.id("username"));

		assertNotNull(elem);
		assertEquals("Username", elem.getAttribute("placeholder"));
		
		elem = driver.findElement(By.id("password"));

		assertNotNull(elem);
		assertEquals("Password", elem.getAttribute("placeholder"));
		
		elem = driver.findElement(By.id("submitLogin"));
		
		assertNotNull(elem);
		assertEquals("Sign in", elem.getText());
	}
	
	@Test
	public void TestLoginSuccessAndLogout() {
		final String username = "rui.g";
		final String password = "root";
		
		driver.navigate().to(url);
		
		WebElement elem = driver.findElement(By.id("username"));
		
		assertNotNull(elem);
		
		elem.sendKeys(username);
		assertEquals(username, elem.getAttribute("value"));
		
		elem = driver.findElement(By.id("password"));
		
		assertNotNull(elem);
		
		elem.sendKeys(password);
		assertEquals(password, elem.getAttribute("value"));
		
		driver.findElement(By.id("submitLogin")).click();

		assertEquals("Congratulations", driver.getTitle());
		
		elem = driver.findElement(By.id("submitLogout"));
		
		assertNotNull(elem);
		
		elem.click();
		assertEquals("Sign in", driver.getTitle());
	}
	
	@Test
	public void TestLoginFail() {
		final String username = "invalid";
		final String password = "invalid";
		
		driver.navigate().to(url);
		
		WebElement elem = driver.findElement(By.id("username"));		
		elem.sendKeys(username);
		
		assertEquals(username, elem.getAttribute("value"));
		
		elem = driver.findElement(By.id("password"));		
		elem.sendKeys(password);
		
		assertEquals(password, elem.getAttribute("value"));
		
		driver.findElement(By.id("submitLogin")).click();

		assertEquals("Sign in", driver.getTitle());
		
		elem = driver.findElement(By.id("errorMsg"));
		
		assertNotNull(elem);
		assertEquals("Invalid Credentials", elem.getText());
	}
}
