/**
 * 
 */
package com.irritating.idiot;

import static org.testng.Assert.assertEquals;

/**
 * @author 29265
 *
 */

	

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import bsh.commands.dir;
import junit.framework.Assert;

public class richa{
	static WebDriver d;
	
	ExtentReports extent;
	ExtentTest logger;
	
	
	@BeforeTest
	public void startReport(){
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		extent = new ExtentReports (System.getProperty("user.dir") +"/report/STMExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Rajkumar SM");
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@BeforeMethod
	void addddd()
	{
		String path = "D:\\Selenium\\geckodriver.exe";
		///logger.log(LogStatus.PASS, "broswer has been launch");
		

		System.setProperty("webdriver.gecko.driver", path);
		d = new FirefoxDriver();

		//driver = new FirefoxDriver();

		d.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		d.get("https://book.spicejet.com/LoginAgent.aspx");

	}
	@Test
	public void passTest(){
		//extent.startTest("TestCaseName", "Description")
		//TestCaseName – Name of the test
		//Description – Description of the test
		//Starting test
		logger = extent.startTest("passTest");
		String url=d.getCurrentUrl();
		assertEquals(url, "https://book.spicejet.com/LoginAgent.aspx");
		logger.log(LogStatus.PASS, "url has been loaded properly");
		
		//To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "santa claus is coming on my bday");
	}
	
	
	
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		
		if (result.getStatus() == ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, result.getName() + " test is pass");
			String screen = getScreenshot("Prabhjot");
			logger.log(LogStatus.PASS, logger.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot("Prabhjot");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			logger.log(LogStatus.INFO, result.getName() + " test is started");
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
                extent.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
                extent.close();
    }
	public String getScreenshot(String imageName) throws IOException {
		File image = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir") + "\\src\\screenshot\\";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);
		return actualImageName;

	}
}