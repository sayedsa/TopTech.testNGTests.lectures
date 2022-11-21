package tests;

import static org.testng.Assert.assertEquals;

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

public class TestCase_2 {

	WebDriver driver;

	@BeforeTest 
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.ebay.com.au/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		System.out.println("beforeTest is running for ***************test-2****************");
	}

	@Test(priority=4,description ="test a")
	public void aTestCase() throws InterruptedException {

		WebElement dropDown = driver.findElement(By.id("gh-cat"));
		Select select = new Select(dropDown);

		select.selectByVisibleText(" Cameras");
		System.out.println("select the camera");
		Actions action = new Actions(driver);
		Thread.sleep(4000);
		action.click(dropDown).perform();
		System.out.println("clicked the dropDown");
		WebElement shopByCategory = driver.findElement(By.id("gh-shop-a"));
		shopByCategory.click();
		System.out.println("clicked the shop by category");
		WebElement Car = driver.findElement(By.xpath("//a[text()='Cars']"));
		Thread.sleep(3000);

		System.out.println("move to car");
		action.moveToElement(Car);

	}

	@Test(priority=3, description="test b", invocationCount=1)
	public void bGetTitle() {

		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
	//	String ExpectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String ExpectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String assertionMsg = " it is assertion";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("assertion passed");
		// Assert.assertNotSame(ActualTitle, ExpectedTitle, assertionMsg);
	}

	@Test (priority=2,description="test c  ... Assertion", dependsOnMethods="bGetTitle")
	public void clickElement() {
		WebElement ele_Tech = driver.findElement(By.xpath("//*[@id=\"destinations_list1\"]/ul/li[1]/a/div[2]"));
		ele_Tech.click();
		System.out.println("clicked Tech");
		
		String actualUrl = driver.getCurrentUrl();
		String exptectUrl = "https://www.ebay.com.au/e/toys/c-gifts-for-kids-xmas-gifting";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualUrl, exptectUrl);
		
		softAssert.assertAll();
		
		//Assert.assertEquals(actualUrl, exptectUrl);

	}

    @Ignore
	@Test(priority=1,description="test d")
	public void dSearchBttn() {

		WebElement searchBttn = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		searchBttn.click();
		String search_Attribut = searchBttn.getAttribute("text");
		System.out.println("search button attribute is " + search_Attribut);

	}

	@AfterTest
	public void afterTest() {

		System.out.println("closing the driver");
		driver.close();
	}

}
