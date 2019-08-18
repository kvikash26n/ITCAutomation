package com.itc.itchotels.BaseP;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {

	public static void main(String[] args) {

		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "ZY224GD66X");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);

		//Set ChromeDriver location
		//System.setProperty("webdriver.chrome.driver","./DriverExe/chromedriver.exe");

		//Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		driver.get("http://www.google.com");
	}


}
