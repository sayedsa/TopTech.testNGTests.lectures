package tests;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_6_DataProviderTest {

	public static WebDriver driver;

	@BeforeTest
	public void loginToWebPage() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

		System.out.println("beforeTest is running for ***************test-1****************");

	}
	// there are two ways to create data provider, 1):
     @Ignore
	@Test(dataProvider = "dataSet")
	public void test(String username, String password) {
		System.out.println(username + "*****" + password);

	}

	@DataProvider
	public Object dataSet() {
		Object[][] dataset = new Object[4][2];

		// first row
		dataset[0][0] = "user1";
		dataset[1][0] = "pass1";

		// second row
		dataset[1][0] = "user2";
		dataset[1][1] = "pass2";
		// third row
		dataset[2][0] = "user3";
		dataset[2][1] = "pass3";

		// fourth row
		dataset[3][0] = "user4";
		dataset[3][1] = "pass4";

		return dataset;

	}
	// number 2):
    @Ignore
	@Test(dataProvider = "create")
	public void test1(String username, String password, String test) {

		System.out.println(username + "***" + password + "***" + test);
	}

	@DataProvider(name = "create")
	public Object dataSet1() {

		return new Object[][] { 
			{ "username", "password", "test" },
			{ "username1", "password1", "test1" },
			{ "username2", "password2", "test2" },
		    { "username3", "password3", "test3" },

		};
	}

		
	
	@AfterTest
		public void tearDwon(){
			driver.close();
			System.out.println("closing the driver");
	}
}
