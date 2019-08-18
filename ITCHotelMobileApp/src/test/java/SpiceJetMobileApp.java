
import java.io.File;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class SpiceJetMobileApp extends TestControlAgent{
	public static AndroidDriver driver;

	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "/file/");//C:\Automation\ITCHotelMobileApp\file
	File app = new File(appDir, "SpiceJ.apk");
	
@BeforeMethod
public void setUp() throws Exception {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("noReset","false");
	// 52005f904997a41b 8.1.0 neha BARCFIJRIVKVWWDE 6.0 vikash 4TCUP7RGCELRT4DU 7.0  d67ed23f9804
	capabilities.setCapability("deviceName", "BARCFIJRIVKVWWDE");
		capabilities.setCapability("platformVersion", "6.0");
	   capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.vl.spicejet");
		capabilities.setCapability("--session-override","true");
		capabilities.setCapability("autoGrantPermissions","true");
		//com.vl.spicejet/com.vl.spicejet.home.HomeActivity
		capabilities.setCapability("appActivity", "com.vl.spicejet.home.HomeActivity");
		capabilities.setCapability("skipUnlock","true");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//com.inspirenetz.app.netzchef/com.inspirenetz.app.netzchef.LoginActivity
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
}

@Test(dataProvider = "dataLoader")
public void select(String TripType, String DepartureCity, String ArrivalCity, String FlightNo, String Fare, String NoOfPass) throws InterruptedException {
	Thread.sleep(5000);
	driver.findElementById("com.vl.spicejet:id/fromtv").click();
	 driver.findElementByClassName("android.widget.EditText").sendKeys("CCU");
	 driver.findElementById("com.vl.spicejet:id/tv_city_name").click();
	 //to location
	 driver.findElementById("com.vl.spicejet:id/totv").click();
	 driver.findElementById("com.vl.spicejet:id/et_search").sendKeys("BLR");
	 driver.findElementById("com.vl.spicejet:id/tv_city_name").click();
	 //com.vl.spicejet:id/iv_add_choose_seat
	 //date selection
	 driver.findElementById("com.vl.spicejet:id/llDateLayout").click();
	 driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @bounds='[48,1114][188,1254]']")).click();
	 //driver.findElementBy().click();
	 //search flights
	 driver.findElementById("com.vl.spicejet:id/find_flights").click();
	 driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout' and @bounds='[0,579][1080,779]']")).click();
		 driver.findElementById("com.vl.spicejet:id/tv_next").click();
	 driver.findElementById("com.vl.spicejet:id/etEmailId").sendKeys("abc@gmail.com");
	 driver.findElementById("com.vl.spicejet:id/etMobileNumber").sendKeys("1234567890");
	 driver.pressKeyCode(AndroidKeyCode.BACK);
	 driver.findElementById("com.vl.spicejet:id/add_pass_tv").click();
	 driver.findElementById("com.vl.spicejet:id/rbMale").click();
	 driver.findElementById("com.vl.spicejet:id/etFirstName").sendKeys("Kumar");
	 driver.findElementById("com.vl.spicejet:id/etLastName").sendKeys("Vikash");
	 driver.pressKeyCode(AndroidKeyCode.BACK);
	 driver.findElementById("com.vl.spicejet:id/tvSave").click();
	 
	 driver.findElementById("com.vl.spicejet:id/profile_arrow").click();
	 driver.findElementById("com.vl.spicejet:id/tv_next").click();
	 driver.findElementById("com.vl.spicejet:id/tv_next").click();
	 driver.findElementById("com.vl.spicejet:id/include_debit_credit_card_layout").click();
	 //invalid debit card details validation
	 driver.findElementById("com.vl.spicejet:id/etCardNumber").sendKeys("10029001");
	 driver.pressKeyCode(AndroidKeyCode.BACK);
	 driver.findElementById("com.vl.spicejet:id/etExpiryDate").sendKeys("06/23");
	 driver.findElementById("com.vl.spicejet:id/etCVV").sendKeys("233");
	 driver.pressKeyCode(AndroidKeyCode.BACK);
	 driver.findElementById("com.vl.spicejet:id/tilPersonName").sendKeys("Kumar Vikash");
	 driver.pressKeyCode(AndroidKeyCode.BACK);
	 System.out.println("The total price for your ticket is:" + driver.findElementById("com.vl.spicejet:id/ll_price_total").getText());
	 
	 

		/*	driver.findElementById("lblLoginPageTitle").click();
		//driver.findElementById("com.inspirenetz.app.netzchef:id/lblLoginPageTitle").click();
			MobileElement el1 = (MobileElement) driver.findElementById("com.inspirenetz.app.netzchef:id/lblLoginPageTitle");
			el1.click();com.vl.spicejet:id/ll_price_total

			System.out.println(driver.findElementById("txtUsername").isDisplayed());
			driver.findElementById("txtUsername").sendKeys("abc");;
		//	MobileElement el1 = (MobileElement) driver.findElementById("com.vl.spicejet:id/find_flights");
			//el1.click();
		
		//	boolean  dis=driver.findElementById("com.vl.spicejet:id/find_flights").isDisplayed();
			//System.out.println(dis);
			//	com.vl.spicejet:id/totv
			//BLR
			driver.findElementById("totv").click();
			//Thread.sleep(5000);
			System.out.println("page open");
*/}
@AfterMethod
public void End() {
	driver.quit();
}

}
