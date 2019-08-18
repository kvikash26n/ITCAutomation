package com.itc.itchotels.BaseP;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {

	public static void main(String[] args) {

		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "ZY224GD66X");
		caps.setCapability("udid", "ZY224GD66X");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);

		//Set ChromeDriver location
		//System.setProperty("webdriver.chrome.driver","./DriverExe/chromedriver.exe");

		//Instantiate Appium Driver
		AndroidDriver<WebElement> driver = null;
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		driver.get("http://www.itchotels.in");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebElement BtnMenu = driver.findElement(By.xpath("//a[@class='menuBtn']"));
		WebElement BtnBookNow = driver.findElement(By.xpath("//li[@id='configButt']"));
		
		if(BtnMenu.isDisplayed() && BtnBookNow.isDisplayed()) {
			System.out.println("ITC Hotels Dashboard Screen Launched Successfully");
		}else {
			System.out.println("ITC Hotels Dashboard Screen didnt Launched Successfully");
		
		}
		
		BtnMenu.click();
		WebElement BtnLogin = driver.findElement(By.xpath("//a[@rel='logIn']"));
		BtnLogin.click();
		
		
	}


}
