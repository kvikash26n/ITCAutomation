package Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 */

/**
 * @author 29265 Kumar Vikash
 *
 */
public class SpiceJetApp extends TestControlAgent {
	public static AndroidDriver driver;

	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "/src/file/");
	File app = new File(appDir, "SpiceJ.apk");

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " test is pass");

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot("SJApp");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	public String getScreenshot(String imageName) throws IOException {
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir") + "\\src\\screenshot\\";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);
		return actualImageName;

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		test.log(LogStatus.INFO, result.getParameterCount() + " " + "inputs");

	}

	@BeforeMethod
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("noReset", "false");
		// 52005f904997a41b 8.1.0 neha BARCFIJRIVKVWWDE 6.0 vikash 4TCUP7RGCELRT4DU 7.0 NE1GAM4761535273 8.0.0
		capabilities.setCapability("deviceName", "BARCFIJRIVKVWWDE");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.vl.spicejet");
		capabilities.setCapability("--session-override", "true");
		capabilities.setCapability("autoGrantPermissions", "true");
		// com.vl.spicejet/com.vl.spicejet.home.HomeActivity
		capabilities.setCapability("appActivity", "com.vl.spicejet.home.HomeActivity");
		capabilities.setCapability("skipUnlock", "true");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		test.log(LogStatus.PASS, "app has been launch");
		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		// com.inspirenetz.app.netzchef/com.inspirenetz.app.netzchef.LoginActivity

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}

	@Test(dataProvider = "dataLoader")
	public void select(String DepartureCity, String ArrivalCity, String Email, String Mobile, String FirstName,
			String LastName, String DebitcardNum, String Expiry, String CVV) throws InterruptedException, IOException {
		// Thread.sleep(5000);
		driver.findElement(By.id("com.vl.spicejet:id/fromtv")).click();
	//	driver.findElementById("com.vl.spicejet:id/fromtv").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(DepartureCity);
		driver.findElementById("com.vl.spicejet:id/tv_city_name").click();
		String sc = getScreenshot("Spicejet");
		test.log(LogStatus.PASS, "City Name", DepartureCity + " " + ArrivalCity);
		test.log(LogStatus.PASS, test.addScreenCapture(sc));
		// to location
		driver.findElementById("com.vl.spicejet:id/totv").click();
		driver.findElementById("com.vl.spicejet:id/et_search").sendKeys(ArrivalCity);
		driver.findElementById("com.vl.spicejet:id/tv_city_name").click();
		// com.vl.spicejet:id/iv_add_choose_seat
		// date selection
		driver.findElementById("com.vl.spicejet:id/llDateLayout").click();

		// *************
		String day = "8";
		String visibleText1 = "April 2019";
		String visibleText2 = "May 2019";
		// public void scrollAndClick(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText1 + "\").instance(0))")
				.click();
		System.out.println(
				driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView")).getText());

		// driver.findElement(By.xpath("//*[@class='android.widget.TextView' and
		// text()='13']")).click();

		/*
		 * List<MobileElement> mElementsMonth=driver.findElements(By.xpath(
		 * "//android.widget.LinearLayout/android.widget.TextView"));
		 * 
		 * for(int i=1;i<mElementsMonth.size();i++) {
		 * System.out.println(mElementsMonth.get(i).getText()); }
		 */

		System.out.println(driver.findElement(By.xpath("//android.widget.TextView")).getText());

		List<MobileElement> mElements = driver.findElements(By.xpath("//android.widget.TextView"));
		List allvalue = new ArrayList();

		for (int i = 1; i < mElements.size(); i++) {
			System.out.println(mElements.get(i).getText());
			allvalue.add(mElements.get(i).getText());

		}
		//To check list is having April 2018 and 8 or not
		for(int i = 1; i < allvalue.size(); i++) {
			if(allvalue.get(i).equals(visibleText1)) {
				System.out.println("month input: "+allvalue.get(i)+" counter in mobile element is: "+i);
				for(int j=i;j<allvalue.size();j++) {
					if(allvalue.get(j).equals(visibleText2)) {
						System.out.println("month input: "+allvalue.get(j)+" counter in mobile element is: "+j);
						break;
					}
				}
				break;
				}
		}
		
		
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText2 + "\").instance(0))")
				.click();
		
		
		
		
		/*List<MobileElement> mElements1 = driver.findElements(By.xpath("//android.widget.TextView"));
		List allvalue1 = new ArrayList();

		for (int i = 1; i < mElements1.size(); i++) {
			System.out.println(mElements1.get(i).getText());
			allvalue1.add(mElements1.get(i).getText());

		}*/
		
		mElements.get(45).click();
		/*
		 * System.out.println (driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView"
		 * )).getText()); System.out.println (driver.findElement(By.xpath("\r\n" +
		 * "/hiera1chy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView\r\n"
		 * + "")).getText()); System.out.println (driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView"
		 * )).getText());
		 * 
		 * System.out.println (driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.TextView"
		 * )).getText()); driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView"
		 * )).click();
		 */

		/*
		 * String visibleText12="May 2019"; //public void scrollAndClick(String
		 * visibleText) {
		 * 
		 * driver.
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
		 * +visibleText12+"\").instance(0))").click();
		 * 
		 * AndroidElement list1 = (AndroidElement) driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout/android.widget.TextView"));
		 * 
		 * System.out.println (driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[4]"
		 * )).getText());
		 * //android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView
		 * //android.widget.LinearLayout/android.view.ViewGroup
		 * System.out.println(driver.findElement(By.xpath(
		 * "//android.widget.ListView/android.widget.LinearLayout/android.widget.TextView"
		 * )).getText());
		 * 
		 * AndroidElement list = (AndroidElement) driver.findElement(By.xpath(
		 * "//android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView"
		 * )); list.getText(); System.out.println(list.getText()); MobileElement
		 * listGroup = list .findElement(MobileBy
		 * .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" +
		 * "new UiSelector().text('6'));")); // assertNotNull(listGroup.getLocation());
		 * listGroup.click();
		 * 
		 * 
		 * MobileElement el2 = (MobileElement) driver.findElementByXPath(
		 * "/android.widget.ListView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView[contains(text()='3')]"
		 * ); el2.click(); driver.findElement(By.xpath(
		 * "//android.widget.ListView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView[contains(text()='3')]"
		 * )).click();
		 * 
		 * 
		 * Thread.sleep(1000);
		 */// **************************************************************

		/*
		 * String visibleText="April 2019"; //public void scrollAndClick(String
		 * visibleText) { driver.
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
		 * +visibleText+"\").instance(0))").click(); // } // } Thread.sleep(4000);
		 * MobileElement el1 = (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout[4]/android.widget.TextView"
		 * ); el1.click();
		 */
		// driver.findElement(By.xpath("//android.widget.TextView[contains(text(),'3')]")).click();
		sc = getScreenshot("DatePicker");
		test.log(LogStatus.PASS, "Date selected");
		test.log(LogStatus.PASS, test.addScreenCapture(sc));
		// trying scroll
		// Screenshots ss= new ScreenshotState((AndroidDriver<MobileElement>) driver);

		// search flights
		driver.findElementById("com.vl.spicejet:id/find_flights").click();
		driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout' and @bounds='[0,579][1080,779]']"))
				.click();
		driver.findElementById("com.vl.spicejet:id/tv_next").click();
		driver.findElementById("com.vl.spicejet:id/etEmailId").sendKeys(Email);
		driver.findElementById("com.vl.spicejet:id/etMobileNumber").sendKeys(Mobile);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.vl.spicejet:id/add_pass_tv").click();
		driver.findElementById("com.vl.spicejet:id/rbMale").click();
		driver.findElementById("com.vl.spicejet:id/etFirstName").sendKeys(FirstName);
		driver.findElementById("com.vl.spicejet:id/etLastName").sendKeys(LastName);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.vl.spicejet:id/tvSave").click();

		driver.findElementById("com.vl.spicejet:id/profile_arrow").click();
		driver.findElementById("com.vl.spicejet:id/tv_next").click();
		driver.findElementById("com.vl.spicejet:id/tv_next").click();
		driver.findElementById("com.vl.spicejet:id/include_debit_credit_card_layout").click();
		// invalid debit card details validation
		driver.findElementById("com.vl.spicejet:id/etCardNumber").sendKeys(DebitcardNum);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.vl.spicejet:id/etExpiryDate").sendKeys(Expiry);
		driver.findElementById("com.vl.spicejet:id/etCVV").sendKeys(CVV);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.vl.spicejet:id/tilPersonName").sendKeys(FirstName + " " + LastName);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		String price = driver.findElementById("com.vl.spicejet:id/tv_total_flight_price").getText();
		System.out.println("The total price for your ticket is:"
				+ driver.findElementById("com.vl.spicejet:id/tv_total_flight_price").getText());
		// failure
		String paymentsc = getScreenshot("paymentDetails");
		test.log(LogStatus.PASS, "Payment screen: " + price);
		test.log(LogStatus.PASS, test.addScreenCapture(paymentsc));

		// System.out.println("the total price
		// is:"+driver.findElement(By.xpath("(//*[@id='com.vl.spicejet:id/tv_total_flight_price'
		// and @bounds='[90,1821][223,1880]'])[2]")).getText());
		driver.findElementById("com.vl.spicejet:id/tv_next").click();
		Thread.sleep(5000);

		// id: com.vl.spicejet:id/tv_total_flight_price

	}

	/*
	 * @AfterMethod public void End() { driver.quit(); }
	 */

}
