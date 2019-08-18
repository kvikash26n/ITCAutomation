package Test;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumParallelExecution_v1 implements Runnable {
	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "/src/file/");
	File app = new File(appDir, "SpiceJ.apk");
	String port;
	String platformVersion;
	String udid;

	public AppiumParallelExecution_v1(String portNumber, String udid, String platformVersion) {
		this.port = portNumber;
		this.udid = udid;
		this.platformVersion = platformVersion;
	}

	AppiumDriver<WebElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	private void openAppAndPerformSomeActions() {
		// *******
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("noReset", "false");
		// 52005f904997a41b 8.1.0 neha BARCFIJRIVKVWWDE 6.0 vikash 4TCUP7RGCELRT4DU 7.0
		// NE1GAM4761535273 8.0.0
		// capabilities.setCapability("deviceName", "BARCFIJRIVKVWWDE");
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.vl.spicejet");
		capabilities.setCapability("--session-override", "true");
		capabilities.setCapability("autoGrantPermissions", "true");

		capabilities.setCapability("appActivity", "com.vl.spicejet.home.HomeActivity");
		capabilities.setCapability("skipUnlock", "true");

		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

		capabilities.setCapability("deviceName", "My Mobile Device");

		try {

			driver = new AndroidDriver(new URL("http://0.0.0.0:" + port + "/wd/hub"), capabilities);
			// driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:" + port +
			// "/wd/hub"), capabilities);
			Thread.sleep(15000);

			driver.findElement(By.id("com.vl.spicejet:id/fromtv")).click();
			System.out.println("excution done for: " + udid);
			Thread.sleep(10000);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
@Test
	public  void main() {
		Runnable r1 = new AppiumParallelExecution_v1("5000", "0123456789ABCDEF", "5.0.2"); // device id of first mobile
																						// device
		Runnable r2 = new AppiumParallelExecution_v1("4724", "BARCFIJRIVKVWWDE", "6.0"); // device id of second mobile
																						// device
		new Thread(r1).start();
		new Thread(r2).start();
	}

	@Override
	public void run() {
		openAppAndPerformSomeActions();
	}
}