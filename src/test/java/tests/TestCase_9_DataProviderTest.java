package tests;

import org.testng.annotations.Test;

public class TestCase_9_DataProviderTest  {


	@Test(dataProvider = "create",dataProviderClass = TestCase_8_DataProvider_Externalize.class)
	public void test(String username, String password ) {
    	 
		System.out.println(username + "*****" + password) ;
		
	}


	
	
	@Test(dataProvider = "create",dataProviderClass = TestCase_8_DataProvider_Externalize.class)
	public void test1(String username, String password, String test) {
    	 
		System.out.println(username + "*****" + password+"*****" + test);

	

	}

   
	
	
	
	}

