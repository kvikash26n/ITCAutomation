/**
 * 
 */
package Test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utility.util;

/**
 * @author kumar vikash
 *
 */
public class ITHdemo extends ithtestcontroller{

	/**
	 * @param args
	 */
	WebDriver driver;

	@BeforeMethod
	void launch() throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println("Welcome to spicejet");

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);

		// driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

		driver.get("http://192.168.14.118:8081/onetouch/pages/login/loginHome.xhtml");

	}
//dataLoader_bf
	@Test(dataProvider = "dataLoader_bf")
	void Ith_Booking(String scenarioname,String username, String password,String TripType,
			String DepartureCity,
			String ArrivalCity,String DOJ) throws InterruptedException, AWTException, FindFailed, IOException {
		
		driver.findElement(By.xpath("//*[contains(@id,'username')]")).sendKeys(username);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("signin")).click();
		Thread.sleep(10000);
		/// to select corporate option
		WebElement element = driver.findElement(By.xpath("//*[text()='E-docket']"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("//*[text()='New E-docket']"));

		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Corporate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='hideshowITHNotice']")).click();

		driver.findElement(By.id("nameInput")).sendKeys("BRANCH MANAG");
		Thread.sleep(2000);
		driver.findElement(By.id("nameInput")).sendKeys(Keys.TAB);
		Thread.sleep(2000);

		driver.findElement(By.id("contactNo")).sendKeys("1234567899");
		driver.findElement(By.id("corpEmailIDs")).sendKeys("rew@gmail.com");
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		Thread.sleep(2000);
		Select sc = new Select(driver.findElement(By.xpath("//*[@id='bookingGivenById']//select")));

		sc.selectByVisibleText("test test");

		driver.findElement(By.xpath("//*[text()='Proceed']")).click();

		Thread.sleep(5000);

		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		try {

			driver.findElement(By.xpath("//*[text()='Flight']")).click();
		} catch (Exception e) {
			// TODO: handle exception
			driver.findElement(By.xpath("//*[text()='Flight']")).click();
			//String  ITH=	getScreenshot("Welcome",driver);
			//test.log(LogStatus.ERROR, test.addScreenCapture(ITH));
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@name='selectTripType'])[2]")).click();
		Thread.sleep(2000);
		//negative flow
		driver.findElement(By.xpath("//*[contains(@name,'fromCity')]")).sendKeys("ABCZYR");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@name,'toCity')]")).sendKeys(ArrivalCity);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@name,'toCity')]")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("domsearchButtonId")).click();
		Thread.sleep(3000);
		
		boolean dc= driver.findElement(By.xpath("//*[contains(text(),'Please provide correct depature city name')]")).isDisplayed();
		assertEquals(dc, true);
		String  ITH1=	getScreenshot("Error_Msg",driver);
    	test.log(LogStatus.PASS,scenarioname+"validatuon for invalid departure city");
    	test.log(LogStatus.PASS, test.addScreenCapture(ITH1));
		////
		driver.findElement(By.xpath("//*[contains(@name,'fromCity')]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@name,'fromCity')]")).sendKeys(DepartureCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@name,'fromCity')]")).sendKeys(Keys.TAB);
//
		driver.findElement(By.xpath("//*[contains(@name,'toCity')]")).sendKeys(ArrivalCity);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@name,'toCity')]")).sendKeys(Keys.TAB);
		//// *[contains(@id,'departDate')]
		driver.findElement(By.xpath("//*[contains(@id,'departDate')]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@id,'departDate')]")).sendKeys(DOJ);
		// id="noOfAdults"
		// id="noOfChildren"
		// id="noOfInfants"
		sc = new Select(driver.findElement(By.id("noOfAdults")));
		sc.selectByVisibleText("1");
		/*
		 * sc=new Select(driver.findElement(By.id("noOfChildren")));
		 * sc.selectByVisibleText("4"); sc=new
		 * Select(driver.findElement(By.id("noOfInfants")));
		 * sc.selectByVisibleText("4");
		 */
		driver.findElement(By.id("domsearchButtonId")).click();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@ id='flightResultsId']//input")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='Select this Flight']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(7000);
		sc = new Select(driver.findElement(By.xpath("//*[text()='Title']//parent::div//following::select")));

		sc.selectByVisibleText("MR");

		driver.findElement(By.xpath("//*[text()='First Name']//parent::div//following::input")).sendKeys(util.randonString(4));
		driver.findElement(By.xpath("//*[text()='Last Name']//parent::div//following::input")).sendKeys(util.randonString(4));
		driver.findElement(By.xpath("//*[contains(text(),'Address1')]//parent::div//following::input"))
				.sendKeys("addressaxzybc");

		driver.findElement(By.xpath("(//*[contains(text(),'Mobile No.')]//parent::div//following::input)[2]"))
				.sendKeys("1234567890");

		driver.findElement(By.xpath("//*[contains(@id,'emailid')]")).sendKeys(util.randonString(4)+"@test1.com");

		driver.findElement(By.xpath("(//*[contains(@name,'dataTd')])[19]")).sendKeys(util.randonNumber(4));
		// 1000 i sec
		// 1 1000
		// 18000 

		driver.findElement(By.xpath("//*[text()='Book Flight']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 130000);
		WebElement EDocketxpath;
		EDocketxpath= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[contains(text(),'E-Docket No')]//parent::div//span")));
		
		//Thread.sleep(130000);
		String EDocket = EDocketxpath.getText();
		System.out.println(EDocket);
		String  ITH=	getScreenshot("Error_Msg",driver);
    	test.log(LogStatus.PASS,scenarioname+"EDocket no:"+EDocket+","+"booking  successful");
    	 
        	test.log(LogStatus.PASS, test.addScreenCapture(ITH));
    	
		// (//*[@class='flight_num_td_conf'])[4]
		String name = driver.findElement(By.xpath("(//*[@class='flight_num_td_conf'])[4]")).getText();
		System.out.println(name.trim());
		}
		/*catch (NoSuchElementException e) {
			 String  ITH=	getScreenshot("Welcome",driver);
				test.log(LogStatus.ERROR, test.addScreenCapture(ITH));
		}
		catch (TimeoutException e) {
			// TODO: handle exception ElementNotVisibleException
			 String  ITH=	getScreenshot("Welcome",driver);
				test.log(LogStatus.ERROR, test.addScreenCapture(ITH));
		}
		catch (ElementNotVisibleException e) {

			 String  ITH=	getScreenshot("Welcome",driver);
				test.log(LogStatus.ERROR, test.addScreenCapture(ITH));
		}*/
	
	@AfterMethod
	void tear()
	{
		driver.quit();
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
}
