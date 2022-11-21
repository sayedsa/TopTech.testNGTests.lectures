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

//@Listeners( tests.TestCase_11_ItestListeners.class )
public class TestCase_10_Parameters {//Note: it should be run from xml file otherwise it throws Exception 	
	//public static String browser = "chrome";
	public static WebDriver driver;
	
@Parameters({"browser"})	
@Test
public void launchApplication(String browser) {

	if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver();
		driver = new FirefoxDriver();
		
	} else if (browser.equals("chrome")) {
		WebDriverManager.chromedriver();
		driver= new ChromeDriver();
		
	
	}
	
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	driver.close();

	}
	
}


