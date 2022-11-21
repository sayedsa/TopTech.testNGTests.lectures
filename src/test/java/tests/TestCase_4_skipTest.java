package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_4_skipTest {


	Boolean data = true;

	@BeforeTest
	public void beforeTest() {
		
	

		System.out.println("beforeTest is running for ***************test-4****************");

	}

	@Test(enabled = false)
	public void testMethod1() {

		System.out.println("it is skiping test using enabled=false");
	}

	@Test
	public void testMethod2() {
		throw new SkipException("it is skipping test.");
	}

	@Test
	public void testMethod3() {
		if (data == true) {
			System.out.println("execute the test");

		} else {
			throw new SkipException("skip the test");
		}
	}

	@AfterTest
	public void afterTest() {

		System.out.println("closing the driver");

	}

}
