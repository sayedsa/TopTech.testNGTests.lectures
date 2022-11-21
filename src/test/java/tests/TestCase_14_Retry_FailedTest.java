package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCase_14_Retry_FailedTest {
		
	public static WebDriver driver;
	
							//Note: TestCase 13 and 14 are referenced to each other
@Test(retryAnalyzer = TestCase_13_MyRetry.class)
public void launchApplication() {

	
		
	WebDriverManager.chromedriver();
	driver= new ChromeDriver();
		

	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//input[@id='user-name5']")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	driver.close();

	}
	
}


