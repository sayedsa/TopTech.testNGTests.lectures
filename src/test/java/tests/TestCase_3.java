package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_3 {

	WebDriver driver;

	@BeforeTest 
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://corammerswork.ml/wordpress/test1/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		System.out.println("beforeTest is running for ***************test-3****************");

	}
	
	@Test
	public void createAccount() throws InterruptedException {
		
	WebElement myAccount = 	driver.findElement(By.xpath("//*[@id=\'Top_bar\']/div/div/div[2]/div/a[4]"));
	System.out.println("clicking my account");         
	myAccount.click();

	Thread.sleep(3000);
	
	WebElement userName = 	driver.findElement(By.id("username"));
	System.out.println("entering username");
	Thread.sleep(3000);
	userName.sendKeys("Sayed Sadat");
	
	WebElement Password = 	driver.findElement(By.id("password"));
	System.out.println("entering username");
	Password.sendKeys("House@$123456789");
	Thread.sleep(3000);
	WebElement bttn_login = 	driver.findElement(By.name("login"));
	System.out.println("clicking login button");
	bttn_login.click();
	
	}
	
	@AfterTest
	public void afterTest() {

		System.out.println("closing the driver");
		driver.close();
	}

}
