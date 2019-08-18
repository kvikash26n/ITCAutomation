/**
 * 
 */
package Test;

import static org.testng.Assert.assertTrue;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 29265
 *
 */
public class passengerCount extends ithtestcontroller {
	WebDriver driver;
	@BeforeMethod
	void launch() throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println("Welcome to spicejet");

		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
	
		 driver = new ChromeDriver(options);

		//driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		
		driver.get("http://192.168.14.118:8081/onetouch/pages/login/loginHome.xhtml");
	
	}
@Test(dataProvider = "dataLoader_ps")
void pax_validation(String scenarioname,String username, String password,String depart,String arriv,String ad,String ch,String inf) throws InterruptedException, AWTException, FindFailed, IOException
{
	driver.findElement(By.xpath("//*[contains(@id,'username')]")).sendKeys(username);
	Thread.sleep(3000);

	driver.findElement(By.xpath("//*[contains(@id,'password')]"))
			.sendKeys(password);
	Thread.sleep(3000);
	driver.findElement(By.id("signin")).click();
	Thread.sleep(9000);
	///to select corporate option
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
	Select sc=new Select(driver.findElement(By.xpath("//*[@id='bookingGivenById']//select")));

	sc.selectByVisibleText("test test");
	
	
	
	
	driver.findElement(By.xpath("//*[text()='Proceed']")).click();
	

	Thread.sleep(5000);
	
	
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	try {
	
		driver.findElement(By.xpath("//*[text()='Flight']")).click();
	}
	catch (Exception e) {
		// TODO: handle exception
		driver.findElement(By.xpath("//*[text()='Flight']")).click();
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//*[@name='selectTripType'])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name,'fromCity')]")).sendKeys(depart);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@name,'fromCity')]")).sendKeys(Keys.TAB);
	test.log(LogStatus.PASS,depart+" "+"selected successfully");

	driver.findElement(By.xpath("//*[contains(@name,'toCity')]")).sendKeys(arriv);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@name,'toCity')]")).sendKeys(Keys.TAB);
	test.log(LogStatus.PASS,arriv+" "+"selected successfully");
	////*[contains(@id,'departDate')]
	driver.findElement(By.xpath("//*[contains(@id,'departDate')]")).clear();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@id,'departDate')]")).sendKeys("28/07/2018");
	//id="noOfAdults"
	//id="noOfChildren"
	//id="noOfInfants"
	//String adult=Integer.parseInt(ad);
	//
	//
	sc=new Select(driver.findElement(By.id("noOfAdults")));
	sc.selectByVisibleText(ad);
	sc=new Select(driver.findElement(By.id("noOfChildren")));
	sc.selectByVisibleText(ch);
	sc=new Select(driver.findElement(By.id("noOfInfants")));
	sc.selectByVisibleText(inf);
	//No. of Infants cannot be more than No. of Adults
	//*[contains(text(),'Total no. of passengers cannot be more than 9')]
	driver.findElement(By.id("domsearchButtonId")).click();
	Thread.sleep(2000);
	int adult=Integer.parseInt(ad);
	int infant=Integer.parseInt(inf);
	int child=Integer.parseInt(ch);
	if(adult<infant)
	{
		boolean errorMsg_inf=driver.findElement(By.xpath("//*[contains(text(),'No. of Infants cannot be more than No. of Adults')]")).isDisplayed();
		assertTrue(errorMsg_inf, "no error msg");
		 String  ITH=	getScreenshot("Welcome",driver);
	       	test.log(LogStatus.PASS,scenarioname+" "+"No. of Infants cannot be more than No. of Adults,validated successfully");
	     
	       	test.log(LogStatus.PASS, test.addScreenCapture(ITH));
	}else if ((adult+child)>9) {
		boolean errorMsg_moreThan9=	driver.findElement(By.xpath("//*[contains(text(),'Total no. of passengers cannot be more than 9')]")).isDisplayed();
		assertTrue(errorMsg_moreThan9, "no error msg more than 9");
		 String  ITH=	getScreenshot("Welcome",driver);
	       	test.log(LogStatus.PASS,scenarioname+" "+"Total no. of passengers cannot be more than 9 ,validated successfully");
	     
	       	test.log(LogStatus.PASS, test.addScreenCapture(ITH));

	}else {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		Thread.sleep(20000);
		
		boolean modifybutton=	driver.findElement(By.xpath("//*[contains(text(),'Modify Search')]")).isDisplayed();
		assertTrue(modifybutton, "modify button is not visible");
		  String  ITH=	getScreenshot("Welcome",driver);
	       	test.log(LogStatus.PASS,scenarioname+" "+"Modify button dispalyed in search page");
	     
	       	test.log(LogStatus.PASS, test.addScreenCapture(ITH));
	}	
	

	
}
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