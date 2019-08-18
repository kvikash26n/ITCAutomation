import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//spicejet_staging_razorpay_18_jun
//com.vl.spicejet/com.vl.spicejet.home.HomeActivity}
public class demo2 {
	public static AndroidDriver driver;
	//public static AppiumDriver<WebElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/src/file/");
		File app = new File(appDir, "spicejet_staging_razorpay_18_jun.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "4207711");
		capabilities.setCapability("platformVersion", "6.0.1");
	    capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("appPackage", "com.vl.spicejet");
		
		capabilities.setCapability("appActivity", "com.vl.spicejet.home.HomeActivity");
		capabilities.setCapability("skipUnlock",true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		//netzchef_v_1.7.0
	System.out.println(driver.getPageSource()) ;

		System.out.println("Execution over");
		System.out.println(driver.getPageSource()) ;
		//com.vl.spicejet:id/find_flights
		//android.widget.ImageButton
	//	driver.context("NATIVE_APP");
		System.out.println(driver.getContext());
		System.out.println(driver.getOrientation());
		
	//	MobileElement el1 = (MobileElement) driver.findElementById("com.vl.spicejet:id/find_flights");
		//el1.click();
	
	//	boolean  dis=driver.findElementById("com.vl.spicejet:id/find_flights").isDisplayed();
		//System.out.println(dis);
		//	com.vl.spicejet:id/totv
		//BLR
		driver.findElementById("totv").click();
		Thread.sleep(5000);
		//driver.findElementById("find_flights").click();
		System.out.println("eleemnt clicked");
		//driver.quit();

	}
}
