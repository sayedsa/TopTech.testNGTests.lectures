package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_1 {
	public static WebDriver driver;	 // Note:  this test case does not run due to some issues, it needs more work

	@BeforeTest
	public void loginToWebPage() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://corammerswork.ml/wordpress/test1/");
		 driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		System.out.println("beforeTest is running for ***************test-1****************");
	}

	@Test
	public void loginAccount() throws InterruptedException {
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\'Top_bar\']/div/div/div[2]/div/a[4]"));
		Thread.sleep(4000);                                 //*[@id=\"Top_bar\"]/div/div/div[2]/div/a[4]
		System.out.println("clicking loginAccount");
		myAccount.click();
		Thread.sleep(4000);
		WebElement enterName = driver.findElement(By.xpath("//input[@id='wpwc_custom_registration_field_125']"));
		enterName.sendKeys("sayed");
		System.out.println("entering name");
		Thread.sleep(4000);
		
		WebElement enterCity = driver.findElement(By.xpath("//input[@id='wpwc_custom_registration_field_126']"));
		enterCity.sendKeys("Seattle");
		System.out.println("entering city");
		Thread.sleep(4000);
		WebElement enterAddress = driver.findElement(By.xpath("//input[@name='wpwc_custom_registration_field_127']"));
		enterAddress.sendKeys("Burien city");
		System.out.println("entering address");
		Thread.sleep(4000);
		WebElement enterEmail = driver.findElement(By.xpath("//input[@id='reg_email']"));
		enterEmail.sendKeys("sayed@toptech.us");
		System.out.println("entering email");
		WebElement clickRegisterBttn = driver.findElement(By.xpath("//button[@name='register']"));
		Thread.sleep(4000);
		clickRegisterBttn.click();
		System.out.println("clicking the register button");
	}
	@AfterTest
		public void tearDwon(){
			driver.close();
			System.out.println("closing the driver");
		}
	}


