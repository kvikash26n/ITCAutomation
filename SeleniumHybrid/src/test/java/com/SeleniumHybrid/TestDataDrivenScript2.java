package com.SeleniumHybrid;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testbase.TestBase;

public class TestDataDrivenScript2 extends TestBase{
	
	@DataProvider(name="testData")
	public String[][] dataSource()
	{
		return getData("TestData.xlsx" , "RegistrationTest");
	}
	
    @Test(dataProvider="testData")
    public void testLogin(String variable1, String variable2, String variable3, String variable4, String variable5, String variable6)
    {
    	System.out.println("variable1:-"+ variable1);
    	System.out.println("variable2:-"+ variable2);
    	System.out.println("variable3:-"+ variable3);
    	System.out.println("variable4:-"+ variable4);
    	System.out.println("variable5:-"+ variable5);
    	System.out.println("variable6:-"+ variable6);
    	//TestBase.getScreenshot();
    }
}