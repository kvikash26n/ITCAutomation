/**
 * 
 */
package com.ith.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.ith.framework.dataprovider_for_sample;

/**
 * @author 29265
 *
 */
public class sample extends dataprovider_for_sample{

	/**
	 * @param args
	 */
	@Test(dataProvider = "sample")
	public  void main(String a,String b,String c) {
		// TODO Auto-generated method stub
/*WebDriver driver;
System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");

ChromeOptions options = new ChromeOptions();
options.addArguments("disable-infobars");
options.addArguments("--start-maximized");

 driver = new ChromeDriver(options);

//driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

driver.get("https://mvnrepository.com/artifact/com.relevantcodes/extentreports");*/
		
		System.out.println(a+b+c);
	}

}
