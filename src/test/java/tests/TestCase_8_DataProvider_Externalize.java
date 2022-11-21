package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_8_DataProvider_Externalize {

	// this class of dataprovider is run by testCase-9

	@DataProvider(name = "create")
	public Object dataSet1(Method m) {

		
		Object [][] testdata = null ;
		
		if(m.getName().equals("test")) {
			
		
		testdata = new Object[][] { 
			{ "username", "password" },
			{ "username1", "password1" },
			{ "username2", "password2" },
		    { "username3", "password3" },
		};
	}
		    else if(m.getName().equals("test1")) {
		    	
		    	testdata = new Object[][] { 
					{ "username", "password", "test" },
					{ "username1", "password1", "test1" },
					{ "username2", "password2", "test2" },
				    { "username3", "password3", "test3" }
		    
		};
		    }
          return testdata;
		  
		
	}
}
