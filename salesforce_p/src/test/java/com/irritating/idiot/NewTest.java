package com.irritating.idiot;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;



import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	public  WebDriver d;
  @Test
  public void f() {
	  WebElement webElement=d.findElement(By.cssSelector("input[id=username]"));
	  webElement.sendKeys("prabhjot.kaur@lashgroup.com");
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	//  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		//String path = "D:\\Selenium\\geckodriver.exe";
	//	test.log(LogStatus.PASS, "broswer has been launch");

		//System.setProperty("webdriver.gecko.driver", path);
		//d = new FirefoxDriver();
		 d= new ChromeDriver();
		d.get("https://www.test.salesforce.com/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
  }

  @AfterMethod
  public void afterMethod() {
  }

}
