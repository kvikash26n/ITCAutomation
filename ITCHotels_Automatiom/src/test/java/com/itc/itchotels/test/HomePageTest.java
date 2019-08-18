/**
 * 
 */
package com.itc.itchotels.test;

/**
 * @author 29265
 *
 */


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.itc.itchotels.baseP.TestBase;
import com.itc.itchotels.pages.HomePage;
import com.itc.itchotels.utility.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	TestUtil testUtil;


	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
	
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	@Test(priority=2)
	public void verifysearchButton(){
		boolean homePageTitle = homePage.verifysearchButton();
		Assert.assertEquals(homePageTitle, true);
	}
}