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
@Test(groups = "smokeTests")
public class TestCase_5_groups {

	WebDriver driver;

	@BeforeTest 
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		/*
		driver.get("https://corammerswork.ml/wordpress/test1/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		*/
		System.out.println("beforeTest is running for ***************test-4****************");

	}
	
	
		  @Test(groups = {  "Regression" })
		  public void testMethod1() {
			  
			  System.out.println("I am in method 1 ");
		  }
		 
		  @Test(groups = {"functest", "Regression"} )
		  public void testMethod2() {
			  
			  System.out.println("I am in method 2 ");
		  }
		 
		  @Test(groups = { "functest" })
		  public void testMethod3() {
			  System.out.println("I am in method 3 ");
		  }
		  @Test(groups = { "functest" ,"integration" } )
		  public void testMethod4() {
			  System.out.println("I am in method 4 ");
		  }
	
	@AfterTest
	public void afterTest() {

		System.out.println("closing the driver");
		driver.close();
	}

}
