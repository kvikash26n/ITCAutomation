package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utility.util;

public class PNR_Cancellation_up  extends TestControlAgent {
	WebDriver driver;
	Map<String, Object[]> pnrdata = new TreeMap<String, Object[]>();

	@BeforeSuite
	void initial() {
		pnrdata.put("A", new Object[] { "PNR", "PNR Status", "Refund Amount"});
		System.out.println("Beforesuite executed");
	}

	@BeforeMethod
	void launch() throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println("Welcome to spicejet");
		String path = "D:\\Selenium\\geckodriver.exe";
		// test.log(LogStatus.PASS, "broswer has been launch");
		// System.setProperty("webdriver.chrome.driver", path);

		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
		// WebDriver dr=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://book.spicejet.com/LoginAgent.aspx");
		// System.out.println("@BeforeMethod:="+a);
		// List namerecord = getPassengerNameDetails();

	}

	@Test(dataProvider = "dataLoaderpnr")
	void Delete_PNR(String pnr, String Passname, String DOJ) throws InterruptedException {
		System.out.println(pnr);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.id("ControlGroupLoginAgentView_AgentLoginView_TextBoxUserID")).sendKeys("SDMARKETNG");
		Thread.sleep(3000);

		driver.findElement(By.id("ControlGroupLoginAgentView_AgentLoginView_PasswordFieldPassword"))
				.sendKeys("India@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[contains(@class,'closethick')]")).click();
		Thread.sleep(4000);
		
		driver.get("https://book.spicejet.com/BookingList.aspx");
		Thread.sleep(5000);
		Select s = new Select(driver
				.findElement(By.id("ControlGroupBookingListView_BookingListBookingListView_DropDownListTypeOfSearch")));
		// s.selectByValue("RecordLocator");
		s.selectByVisibleText("RecordLocator");
		// send pnr value to pnr field
		driver.findElement(By.id("ControlGroupBookingListView_BookingListBookingListView_TextBoxKeyword"))
				.sendKeys(pnr);

		driver.findElement(By.xpath("//*[contains(text(),'Find Bookings')]")).click();
		// need to handle exception in below code
		try {
		if (driver.findElement(By.xpath("//*[text()='Modify']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[text()='Modify']")).click();

			driver.findElement(By.xpath("//*[contains(text(),'Cancel Booking')]")).click();
		}
		}
		catch (Exception e) {
			System.out.println("Modify button is not available for pnr:="+pnr);
		}
		try {
			String refundAmount = driver.findElement(By.xpath("(//*[@id='bookingDetail']//strong)[5]")).getText();
			refundAmount = refundAmount.replace("Refund Amount-", "");
			System.out.println(refundAmount);
			driver.findElement(By.xpath("(//*[@value='Confirm Cancellation'])[2]")).click();
			// checked term condition button
			// *[@name='termcondition']
			driver.findElement(By.xpath("//*[@id='confirm-payment-button']")).click();
			Thread.sleep(10000);
			try {
				if (driver.findElement(By.xpath("(//a[@class='popup-close2'])[2]")).isDisplayed()) {
					driver.findElement(By.xpath("(//a[@class='popup-close2'])[2]")).click();
					Thread.sleep(2000);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			String PnrStatus = driver.findElement(By.xpath("(//*[@id='bookingDetail']//strong)[2]")).getText();
			assertEquals(PnrStatus, "Cancelled");

			pnrdata.put(pnr, new Object[] { pnr, PnrStatus, refundAmount, "EmailID", "LASTNAME" });

		}
		catch (Exception e) {
			System.out.println("cancellation is not done for pnr:="+pnr);
		}

	}
	


	@AfterMethod
	void teardown() {
		// TODO Auto-generated method stub
		driver.quit();

	}

	@AfterSuite
	void pnrgenerate() {
		try {
			util.PrintPnrCancel(pnrdata);
			// util.PrintPnr(pnrdata);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
