package testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class webUiHomePage {

	private WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String url = "https://www.aumni.fund";
	  driver.get(url);
	}
	@Test
	public void checkLogoElement() {
	  // Check Company Image  
	  boolean navLogo = driver.findElement(By.cssSelector("div.nav-logo")).isDisplayed();
	  	Assert.assertTrue(navLogo, "Is Not Present, this is not expected");
	}
	@Test
    public void checkHeaderElement() {
      // Check Header Navigation Menu
	  boolean marqueeElement = driver.findElement(By.cssSelector("div.c.c-nav")).isDisplayed();
	  	Assert.assertTrue(marqueeElement, "Is Not Present, this is not expected");
	}
	@Test
	public void checkBodyElement() {
	  // Check Body-Marquee
	  boolean marqueeElement = driver.findElement(By.cssSelector("section.s.s-marquee")).isDisplayed();
	  	Assert.assertTrue(marqueeElement, "Is Not Present, this is not expected");
	}
	@Test
	public void checkFooterElement() {	  
	  // Check Footer
	  boolean footerElement = driver.findElement(By.cssSelector("footer.s.footer")).isDisplayed();
	  	Assert.assertTrue(footerElement, "Is Not Present, this is not expected");
	}
	@Test
	public void checkPageLoginFlow() {
	  // Login Flow Check
	  // Click Login from Home Page Navigation Menu
	  driver.findElement(By.cssSelector("a.login")).click();

	  // Click login again on Login Page
	  driver.findElement(By.cssSelector("button.login-page-dialog-button")).click();
		  
	  // Enter Username & PW
	  String username = "username";
	  String password = "password";

	  // Select and enter text for username and password
	  driver.findElement(By.id("1-email")).click();
	  driver.findElement(By.id("1-email")).sendKeys(username);
	  driver.findElement(By.name("password")).click();
	  driver.findElement(By.name("password")).sendKeys(password);

	  // Verify Username box displayed
	  boolean usernameElement = driver.findElement(By.id("1-email")).isDisplayed();
	  	Assert.assertTrue(usernameElement, "Is Not Present, this is not expected");
	  
	  // Verify Password box displayed
	  boolean passwordElement = driver.findElement(By.name("password")).isDisplayed();
	  	Assert.assertTrue(passwordElement, "Is Not Present, this is not expected");
	}
	
	@AfterClass
	public void afterMethod() {
	  driver.close();
	}
}