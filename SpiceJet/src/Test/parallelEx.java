/**
 * 
 */
package Test;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author 29265
 *
 */
public class parallelEx {
	public static AndroidDriver driver;

	
	@BeforeTest(alwaysRun = true)
	@Parameters({"platform", "udid", "systemPort","URL_"})
	public void setup(String platform, String udid, String systemPort,String URL_) throws Exception {
	 //  URL url = new URL(URL_);
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/src/file/");
		File app = new File(appDir, "SpiceJ.apk");
	    String[] platformInfo = platform.split(" ");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    /*capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	    capabilities.setCapability(MobileCapabilityType.UDID, udid);
	    capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
	    
	    //capabilities.setCapability("app", app.getAbsolutePath());
	    
	    capabilities.setCapability(MobileCapabilityType.APP, "/Users/henrrich/Documents/work/jsta/appium/demo-apps/demo.apk");
	    capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, false);*/
	   // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	    
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("noReset", "false");
		// 52005f904997a41b 8.1.0 neha BARCFIJRIVKVWWDE 6.0 vikash 4TCUP7RGCELRT4DU 7.0 NE1GAM4761535273 8.0.0
		capabilities.setCapability("deviceName", udid);
		capabilities.setCapability("platformVersion", platformInfo[1]);
		capabilities.setCapability("platformName", platformInfo[0]);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.vl.spicejet");
		capabilities.setCapability("--session-override", "true");
		capabilities.setCapability("autoGrantPermissions", "true");
		// com.vl.spicejet/com.vl.spicejet.home.HomeActivity
		capabilities.setCapability("appActivity", "com.vl.spicejet.home.HomeActivity");
		capabilities.setCapability("skipUnlock", "true");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		//driver = new AndroidDriver(new URL("http://0.0.0.0:" + systemPort + "/wd/hub"), capabilities);
		driver = new AndroidDriver(new URL("http://"+URL_), capabilities);
	   // driver = new AndroidDriver<MobileElement>(url, capabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest(alwaysRun = true)
	public void teardown() throws Exception {
	    if (driver != null) {
	        driver.quit();
	    }
	}


	@Test
	public void testLoginAndLogout() throws InterruptedException {
		System.out.println("exc");
	   /* navigateToCategory("drawer_login_page");
	    MobileElement usernameInput = (MobileElement) driver.findElementByAccessibilityId("Username Input Field");
	    MobileElement passwordInput = (MobileElement) driver.findElementByAccessibilityId("Password Input Field");
	    MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("Login Button");
	    usernameInput.clear();
	    usernameInput.sendKeys(CORRECT_USER_NAME);
	    passwordInput.click();
	    passwordInput.sendKeys(CORRECT_PASSWORD);
	    loginButton.click();
	    Assert.assertEquals(getMessage(), LOGIN_SUCCESS_MESSAGE);
	    driver.findElementByAccessibilityId("Alt Button").click();
	    Assert.assertTrue(loginButton.isDisplayed() && usernameInput.isDisplayed() && passwordInput.isDisplayed());
	*/}

}
