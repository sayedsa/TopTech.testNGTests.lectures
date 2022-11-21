package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_7_DataProviderTest {

	public static WebDriver driver;

	
	
	

	// this is testing for real data

	@Test(dataProvider = "testData")
	public void actualTest(String username, String password) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		driver.close();
	}

	@DataProvider(name = "testData")
	public Object dataSet2() {

		return new Object[][] { 
			
			{ "problem_user", "secret_sauce" },
	
			{ "standard_user", "secret_sauce" },
		};
	}	
}
