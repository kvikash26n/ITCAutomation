package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

public class PNR_Cancellation  extends TestControlAgent {
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

	@Test
	void Delete_PNR() throws InterruptedException, InvalidFormatException, IOException, ParseException {
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
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
		
		

		int row=1,col=10;
		//List pnrlist=util.GetColumnValue(4, "11_05_2018JD");
		List pnrlist=util.GetColumndateValue(4, "PNRRecord");
		List candate=util.GetColumndateValue(9, "PNRRecord");
		Date today = Calendar.getInstance().getTime();
	    
	    // print out today's date
	    System.out.println(today);
	    String dd=today.toString();
		//Mon Jun 04 00:00:00 IST 2018
		for(int i=0;i<pnrlist.size();i++)
		{
			
		  String TodaysDate=  util.splitDate(dd);
			String canceldate= candate.get(i).toString();
		//Date ddDate=	util.CancelDateNeedtoConvert(canceldate);
			canceldate=util.splitDate(canceldate);
			if(canceldate.equals(TodaysDate)) {
				//add cancellation flow
				//refer write refunded class for coding
				driver.get("https://book.spicejet.com/BookingList.aspx");
				Thread.sleep(5000);
				Select s = new Select(driver
						.findElement(By.id("ControlGroupBookingListView_BookingListBookingListView_DropDownListTypeOfSearch")));
				// s.selectByValue("RecordLocator");
				s.selectByVisibleText("RecordLocator");
				String send=(String) pnrlist.get(i);
				driver.findElement(By.id("ControlGroupBookingListView_BookingListBookingListView_TextBoxKeyword"))
				.sendKeys((send));

		driver.findElement(By.xpath("//*[contains(text(),'Find Bookings')]")).click();
		// need to handle exception in below code
		try {
		if (driver.findElement(By.xpath("//*[text()='Modify']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[text()='Modify']")).click();

			driver.findElement(By.xpath("//*[contains(text(),'Cancel Booking')]")).click();
		}
		}
		catch (Exception e) {
			System.out.println("Modify button is not available for pnr:="+pnrlist.get(i));
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
//need to write excel with refund amount below
			util.ToWriteRefundedAmount(row,col,refundAmount);
			//pnrdata.put(pnr, new Object[] { pnr, PnrStatus, refundAmount, "EmailID", "LASTNAME" });
row=row+1;
		}
		catch (Exception e) {
			System.out.println("cancellation is not done for pnr:="+pnrlist.get(i));
		}

			}else {
				row=row+1;
			}
			
		}
		
	//	System.out.println(pnrlist);
				// send pnr value to pnr field
		
	}
	


	@AfterMethod
	void teardown() {
		// TODO Auto-generated method stub
		driver.quit();

	}


}
