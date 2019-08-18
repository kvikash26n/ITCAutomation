
/**
 * 
 */
package Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 29265
 *
 */
public class BrooksRun extends TestControlAgentBS {
	public static WebDriver driver;

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " test is pass");

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot("BS");
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
		// test.log(LogStatus.INFO, result.getParameterCount() + " " + "inputs");

	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("Welcome to BS");

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);

		// driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

		driver.get("https://www.brooksrunning.com");
	}

	@Test(dataProvider = "dataLoader")
	public void AddToCart(String username, String password, String fname, String lname, String add1,
			String add2, String zip, String city, String state, String phone) throws InterruptedException, IOException {
		// Thread.sleep(5000);
		// WebDriver wait=(WebDriver) new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='My Account']")).click();
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		try {

			if (driver.findElement(By.xpath("//*[@class='error-form']")).isDisplayed()) {
				String error = driver.findElement(By.xpath("//*[@class='error-form']")).getText();
				test.log(LogStatus.PASS, "invalid login.." + error);
				String er = getScreenshot("error");
				// test.log(LogStatus.PASS, "DepartureCity"+ "" +" "+ "ArrivalCity " + "");
				test.log(LogStatus.PASS, test.addScreenCapture(er));
			} else {
				String Home = driver.findElement(By.xpath("//*[@class='x-large']")).getText();
				// add validation below Welcome
				assertEquals(Home, "Welcome");
				test.log(LogStatus.PASS, "Home has been validated with: " + Home);
				String home = getScreenshot("Home");
				// test.log(LogStatus.PASS, "DepartureCity"+ "" +" "+ "ArrivalCity " + "");
				test.log(LogStatus.PASS, test.addScreenCapture(home));
				driver.get("https://www.brooksrunning.com/en_us/mens-running-shirts/");
				driver.findElement(By.xpath("//*[@class='product__card--wrapper product__card--bra-wrapper']//a"))
						.click();
				driver.findElement(By.xpath("(//*[@class='cs-placeholder'])[2]")).click();
				driver.findElement(By.xpath("//*[text()='XS']")).click();
				driver.findElement(By.xpath("//*[@class='increment quantity-selector--plus']")).click();
				driver.findElement(By.id("add-to-cart")).click();
				driver.findElement(By.xpath("//a[text()='View Cart']")).click();
				driver.findElement(By.xpath("(//*[@class='checkout-btn'])[3]")).click();

				// Price validation
				String price = driver.findElement(By.xpath("(//*[@class='order-total']//td)[2]")).getText();
				if (price.length() > 0) {
					test.log(LogStatus.PASS, "Price has been validated.." + price);
					String sc = getScreenshot("Payement");
					// test.log(LogStatus.PASS, "DepartureCity"+ "" +" "+ "ArrivalCity " + "");
					test.log(LogStatus.PASS, test.addScreenCapture(sc));
				}

				driver.findElement(By.xpath("//*[contains(@name,'firstName')]")).sendKeys(fname);
				driver.findElement(By.xpath("//*[contains(@name,'lastName')]")).sendKeys(lname);

				driver.findElement(By.xpath("//*[contains(@name,'address1')]")).sendKeys(add1);

				driver.findElement(By.xpath("//*[contains(@name,'address2')]")).sendKeys(add2);
				driver.findElement(By.xpath("//*[contains(@name,'zip')]")).sendKeys(zip);
				driver.findElement(By.xpath("//*[contains(@name,'city')]")).sendKeys(city);
				Select select = new Select(driver.findElement(By.xpath("//*[contains(@name,'states_state')]")));
				select.selectByVisibleText(state);

				driver.findElement(By.xpath("//*[contains(@name,'addressFields_phone')]")).sendKeys(phone);
			}
		} catch (Exception e) {
			// TODO: handle exception
			String Home = driver.findElement(By.xpath("//*[@class='x-large']")).getText();
			// add validation below Welcome
			assertEquals(Home, "Welcome");
			test.log(LogStatus.PASS, "Home has been validated with: " + Home);
			String home = getScreenshot("Home");
			// test.log(LogStatus.PASS, "DepartureCity"+ "" +" "+ "ArrivalCity " + "");
			test.log(LogStatus.PASS, test.addScreenCapture(home));
			driver.get("https://www.brooksrunning.com/en_us/mens-running-shirts/");
			driver.findElement(By.xpath("//*[@class='product__card--wrapper product__card--bra-wrapper']//a")).click();
			driver.findElement(By.xpath("(//*[@class='cs-placeholder'])[2]")).click();
			driver.findElement(By.xpath("//*[text()='XS']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='increment quantity-selector--plus']")).click();
			driver.findElement(By.id("add-to-cart")).click();
			Thread.sleep(2000);
			String cartVal=driver.findElement(By.xpath("//*[@class='mini-cart-quantity']")).getText();
			test.log(LogStatus.PASS, "Cart has been validated and total value is: " + 3);
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//a[text()='View Cart']")).click();
			driver.findElement(By.xpath("(//*[@class='checkout-btn'])[3]")).click();

			// Price validation
			String price = driver.findElement(By.xpath("(//*[@class='order-total']//td)[2]")).getText();
			if (price.length() > 0) {
				test.log(LogStatus.PASS, "Price has been validated.." + price);
				String sc = getScreenshot("Payement");
				// test.log(LogStatus.PASS, "DepartureCity"+ "" +" "+ "ArrivalCity " + "");
				test.log(LogStatus.PASS, test.addScreenCapture(sc));
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(@name,'firstName')]")).sendKeys(fname);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(@name,'lastName')]")).sendKeys(lname);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(@name,'address1')]")).sendKeys(add1);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(@name,'address2')]")).sendKeys(add2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(@name,'zip')]")).sendKeys(zip);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(@name,'city')]")).sendKeys(city);
			Thread.sleep(1000);
			Select select = new Select(driver.findElement(By.xpath("//*[contains(@name,'states_state')]")));
			select.selectByVisibleText(state);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(@name,'addressFields_phone')]")).sendKeys(phone);

		}

	}

	@AfterMethod
	void kill() {
		driver.quit();
	}
}


