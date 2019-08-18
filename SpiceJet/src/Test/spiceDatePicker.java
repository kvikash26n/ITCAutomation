/**
 * 
 */
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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author 29265
 *
 */
public class spiceDatePicker extends TestControlAgent {
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
		// 52005f904997a41b 8.1.0 neha BARCFIJRIVKVWWDE 6.0 vikash 4TCUP7RGCELRT4DU 7.0 520073b2e8de74eb
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
	public void BookingFlowValidation(String DepartureCity, String ArrivalCity,String DOJ, String Email, String Mobile, String FirstName,
			String LastName, String DebitcardNum, String Expiry, String CVV) throws InterruptedException, IOException {
		// Thread.sleep(5000);
		driver.findElementById("com.vl.spicejet:id/fromtv").click();
		 Thread.sleep(2000);
		driver.findElementByClassName("android.widget.EditText").sendKeys(DepartureCity);
		driver.findElementById("com.vl.spicejet:id/tv_city_name").click();
		 Thread.sleep(3000);
			test.log(LogStatus.PASS, "Home Page has been validated..");
		String sc = getScreenshot("Spicejet");
		test.log(LogStatus.PASS, "DepartureCity"+ DepartureCity +" "+ "ArrivalCity " + ArrivalCity);
		test.log(LogStatus.PASS, test.addScreenCapture(sc));
		// to location
		driver.findElementById("com.vl.spicejet:id/totv").click();
		 Thread.sleep(5000);
		driver.findElementById("com.vl.spicejet:id/et_search").sendKeys(ArrivalCity);
		driver.findElementById("com.vl.spicejet:id/tv_city_name").click();
		 Thread.sleep(5000);
		// com.vl.spicejet:id/iv_add_choose_seat
		// date selection
		driver.findElementById("com.vl.spicejet:id/llDateLayout").click();
		 Thread.sleep(2000);
		
		datePicker("", "");
			sc = getScreenshot("DatePicker");
		test.log(LogStatus.PASS, "Date selected");
		test.log(LogStatus.PASS, test.addScreenCapture(sc));
		// trying scroll
		// Screenshots ss= new ScreenshotState((AndroidDriver<MobileElement>) driver);
//com.vl.spicejet:id/rl_flight_row
		// search flights
		driver.findElementById("com.vl.spicejet:id/find_flights").click();
		//android.widget.RelativeLayout
		 Thread.sleep(5000);
		///List<MobileElement> SelectFL=driver.findElements(By.xpath("//*[@class='android.widget.RelativeLayout']"));
		//SelectFL.get(1).click();
		
		driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout' and @bounds='[0,579][1080,779]']"))
			.click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/tv_next").click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/etEmailId").sendKeys(Email);
		driver.findElementById("com.vl.spicejet:id/etMobileNumber").sendKeys(Mobile);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.vl.spicejet:id/add_pass_tv").click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/rbMale").click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/etFirstName").sendKeys(FirstName);
		driver.findElementById("com.vl.spicejet:id/etLastName").sendKeys(LastName);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElementById("com.vl.spicejet:id/tvSave").click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/profile_arrow").click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/tv_next").click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/tv_next").click();
		 Thread.sleep(3000);
		driver.findElementById("com.vl.spicejet:id/include_debit_credit_card_layout").click();
		 Thread.sleep(3000);
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

	
	void datePicker(String input1, String input2) {

		int counter = 0;
		String day = "8";
		String visibleText1 = "April 2019";
		String visibleText2 = "May 2019";
		String[] myStringArray1 = { "Jan", "Feb", "Mar", "April", "May", "June", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		// String text=myStringArray1[a-1];
		// public void scrollAndClick(String visibleText) {
		boolean flag = true;
		int k = 3;
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ myStringArray1[k] + " " + "2019" + "\").instance(0))")
				.click();

		List<MobileElement> mElements = driver.findElements(By.xpath("//android.widget.TextView"));
		List allvalue = new ArrayList();

		for (int i = 1; i < mElements.size(); i++) {
			System.out.println(mElements.get(i).getText());
			allvalue.add(mElements.get(i).getText());
		}
		// Check positive n negative flow
		for (int i = 1; i < allvalue.size(); i++) {
			if (allvalue.get(i).equals(visibleText1)) {
				System.out.println("month input: " + allvalue.get(i) + " counter in mobile element is: " + i);
				for (int j = i; j < allvalue.size(); j++) {
					if (allvalue.get(j).equals(day)) {
						System.out.println("month input: " + allvalue.get(j) + " counter in mobile element is: " + j);
						mElements.get(j + 1).click();
						counter = j;
						flag = false;
						break;
					}
				}
				break;
			}
			break;
		}

		if (flag) {
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ myStringArray1[k + 1] + " " + "2019" + "\").instance(0))")
					.click();

			List<MobileElement> mElements1 = driver.findElements(By.xpath("//android.widget.TextView"));
			List allvalue1 = new ArrayList();

			for (int i = 1; i < mElements1.size(); i++) {
				System.out.println(mElements1.get(i).getText());
				allvalue1.add(mElements1.get(i).getText());
			}
			// Check positive n negative flow
			for (int i = 1; i < allvalue.size(); i++) {
				if (allvalue1.get(i).equals(day)) {
					System.out.println("month input: " + allvalue1.get(i) + " counter in mobile element is: " + i);
					mElements1.get(i + 1).click();
					break;

				}

			}

		}
	}
}
