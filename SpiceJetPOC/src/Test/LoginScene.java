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
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.omg.CORBA.FloatSeqHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 29265
 *
 */
public class LoginScene extends ithtestcontroller{

	/**
	 * @param args
	 */
	@BeforeMethod
	void launch() throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println("Welcome to spicejet");
	//	String path = "D:\\Selenium\\geckodriver.exe";
	//	test.log(LogStatus.PASS, "broswer has been launch");

		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	//	driver = new FirefoxDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
	//	options.setPageLoadStrategy(strategy)
		 driver = new ChromeDriver(options);

		//driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		
		driver.get("http://192.168.14.118:8081/onetouch/pages/login/loginHome.xhtml");
	}
	static WebDriver driver;
	@Test(dataProvider = "dataLoader_ls")
 void LoginFlow(String scenarioname,String username, String password) throws InterruptedException, IOException {
		
		try {
		driver.findElement(By.xpath("//*[contains(@id,'username')]")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@id,'password')]"))
		.sendKeys(password);
       Thread.sleep(3000);
       driver.findElement(By.id("signin")).click();
       Thread.sleep(5000);
     /*  try {
    if (driver.findElement(By.xpath("//*[contains(text(),'Please Enter Valid Username and Password')]")).isDisplayed()) {
    	boolean  login_status=driver.findElement(By.xpath("//*[contains(text(),'Please Enter Valid Username and Password')]")).isDisplayed();
    	assertEquals(login_status, true,"no error msg dispalyed");
    	String  ITH=	getScreenshot("Error_Msg",driver);
    	test.log(LogStatus.PASS,scenarioname+" "+"Please Enter Valid Username and Password validated successfully");
    	 
        	test.log(LogStatus.PASS, test.addScreenCapture(ITH));
    	
    	
    	//screenshot add
	}
       }
       catch (Exception e) {
		//positive flow validate Welcome
    	   boolean  welcome_msg=driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).isDisplayed();
       	assertEquals(welcome_msg, true,"");
        String  ITH=	getScreenshot("Welcome",driver);
       	test.log(LogStatus.PASS,scenarioname+" "+"login successful,welcome page validated");
     
       	test.log(LogStatus.PASS, test.addScreenCapture(ITH));
       
      //screenshot add
	}*/

       if (driver.findElement(By.xpath("//*[contains(text(),'Please Enter Valid Username and Password')]")).isDisplayed()) {
       	boolean  login_status=driver.findElement(By.xpath("//*[contains(text(),'Please Enter Valid Username and Password')]")).isDisplayed();
       	assertEquals(login_status, true,"no error msg dispalyed");
       	String  ITH=	getScreenshot("Error_Msg",driver);
       	test.log(LogStatus.PASS,scenarioname+" "+"Please Enter Valid Username and Password validated successfully");
       	 
           	test.log(LogStatus.PASS, test.addScreenCapture(ITH));
       	
       	
       	//screenshot add  Welcome
   	}
else if (driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).isDisplayed()) {
	 boolean  welcome_msg=driver.findElement(By.xpath("//*[contains(text(),'Welcome')]")).isDisplayed();
    	assertEquals(welcome_msg, true,"");
     String  ITH=	getScreenshot("Welcome",driver);
    	test.log(LogStatus.PASS,scenarioname+" "+"login successful,welcome page validated");
  
    	test.log(LogStatus.PASS, test.addScreenCapture(ITH));
}
		}
		catch (NoSuchElementException e) {
			 String  ITH=	getScreenshot("Welcome",driver);
			test.log(LogStatus.FAIL, test.addScreenCapture(ITH));
		}

	}
	@AfterMethod
	void teardown()
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
/*	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " test is pass");

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot("ITH");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}*/

	/*@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		test.log(LogStatus.INFO, result.getParameterCount() + " " + "inputs");

	}
*/

}
