package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_15_TestDependency {

	WebDriver driver;

	@BeforeTest 
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
		System.out.println("beforeTest is running for ***************test-4****************");

	}
	
	
		  @Test(groups = {  "Regression" })
		  public void testMethod1() {
			  
			  System.out.println("I am in method 1 ");
		  }
		 
		  @Test(groups = {"functest"} )
		  public void testMethod2() {
			  Assert.assertTrue(false);
			  System.out.println("I am in method 2 ");
		  }
		 
		  @Test(groups = { "Smoke" })
		  public void testMethod3() {
			  System.out.println("I am in method 3 ");
		
			  
		  } 
		  	  @Test(dependsOnGroups = { "Smoke" })
			  public void testMethod4() {
				  System.out.println("I am in method 4 ");
		  }
	
	@AfterTest
	public void afterTest() {

		System.out.println("closing the driver");
		driver.close();
	}
	
	
}
