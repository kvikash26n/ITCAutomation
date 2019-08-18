package test;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class demo {

	/**
	 * @param args
	 */
	WebDriver driver;
	
@Test(alwaysRun = true, description = "_Guest Checkin flow__Departure Date _Departure Date before arrival date ")
void GuestCheckinflow_DepartureDatebeforearrival() {
		// TODO Auto-generated method stub
	driver.get("url")
	driver.findElement(By.xpath("")).click();
	Select select = new Select(driver.findElement(By.xpath("")));select.selectByValue(arg0);
	driver.findElement(By.xpath("")).sendKeys("input");

	assertEquals(actual, expected);

	}

@Test(alwaysRun = true, description = "Guest Checkin flow_Departure Date _Departure Date after arrival date_&Room Number _already assigned to another guest")
void GuestCheckinflow_DepartureDateafterarrival() {
		// TODO Auto-generated method stub
	driver.get("url")
	driver.findElement(By.xpath("")).click();
	Select select = new Select(driver.findElement(By.xpath("")));select.selectByValue(arg0);
	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");

	assertEquals(actual, expected);

	}
@Test(alwaysRun = true, description = "_Guest Checkin flow_Departure Date _Departure Date after arrival date_&Email ID _Invalid Format")
void GuestCheckinflow_DepartureDateafterarrivaldateEmailIDInvalidFormat() {
		// TODO Auto-generated method stub
	driver.get("url")
	driver.findElement(By.xpath("")).click();
	Select select = new Select(driver.findElement(By.xpath("")));select.selectByValue(arg0);
	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");

	assertEquals(actual, expected);

	}
@Test(alwaysRun = true,  description = "_Guest Checkin flow_Departure Date _Departure Date after arrival date_&Credit Card Number _AMEX/ Master Card")
void GuestCheckinflow_AMEXMasterCard() {

		// TODO Auto-generated method stub
	driver.get("url")
	driver.findElement(By.xpath("")).click();
	Select select = new Select(driver.findElement(By.xpath("")));select.selectByValue(arg0);
	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");
	assertEquals(actual, expected);

	}
@Test(description = "_Guest Checkin flow_Departure Date _Departure Date after arrival date_&CC Expiry Date _On or Before the current date")
void GuestCheckinflow_ExpiryDateBefore
() {
		// TODO Auto-generated method stub
	driver.get("url")
	driver.findElement(By.xpath("")).click();
	Select select = new Select(driver.findElement(By.xpath("")));select.selectByValue(arg0);
	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");



	driver.findElement(By.xpath("")).sendKeys("input");

	assertEquals(actual, expected);

	}
@Test(description = "_Guest Checkin flow_Departure Date _Departure Date after arrival date_&CC Expiry Date _After the current date")
void GuestCheckinflow_ExpiryDateAfter() {
		// TODO Auto-generated method stub
	driver.get("url")
	driver.findElement(By.xpath("")).click();
	Select select = new Select(driver.findElement(By.xpath("")));select.selectByValue(arg0);
	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).sendKeys("input");



	driver.findElement(By.xpath("")).sendKeys("input");

	driver.findElement(By.xpath("")).click();

	}
@Test(description = "_Capacity Validation__Capacity Value _Capacity is sum of Vacancy and Occupied")
void CapacityValidation() {
		// TODO Auto-generated method stub
	driver.get("url")
	assertEquals(actual, expected);
	assertEquals(actual, expected);
	assertEquals(actual, expected);

	}
@Test(description = "_Capacity Validation__Capacity Value _Capacity is not the sum of Vacancy and Occupied")
void CapacityValidation_Sum_Validation() {
		// TODO Auto-generated method stub
	driver.get("url")
	assertEquals(actual, expected);
	assertEquals(actual, expected);
	assertEquals(actual, expected);

	assertEquals(actual, expected);


	}
@BeforeMethod
void launch()  {
	System.out.println("Welcome to spicejet");
	String path = "D:\\Selenium\\geckodriver.exe";
	
	System.setProperty("webdriver.gecko.driver", path);
	driver = new FirefoxDriver();

	// driver = new FirefoxDriver();

	driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
//_Capacity Validation__Capacity Value _Capacity is sum of Vacancy and Occupied


}
@AfterMethod
void teardown() {
	Driver.quit();
}
}