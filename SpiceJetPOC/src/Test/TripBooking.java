package Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.util;



//import com.google.common.annotations.VisibleForTesting;

public class TripBooking extends TestControl{
	 WebDriver driver;
	String nr;
	 public void getresult(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.SUCCESS) {
				//test.log(LogStatus.PASS, "broswer has been launch");
			//	test.log(LogStatus.PASS, "triptype has been selected");
				//test.log(LogStatus.PASS, "Date selected successfully");
				//test.log(LogStatus.PASS, "selection page url got validated successfully");
				/*if(){
					
				}*/
			
				//test.log(LogStatus.PASS, "broswer has been closed");
				
				//test.log(LogStatus.PASS, "Date selected successfully");
				test.log(LogStatus.PASS, result.getName() + " test is pass");
				
			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
			} else if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
				String screen = getScreenshot(nr);
				test.log(LogStatus.FAIL, test.addScreenCapture(screen));
			} else if (result.getStatus() == ITestResult.STARTED) {
				test.log(LogStatus.INFO, result.getName() + " test is started");
			}
		}

		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			
			getresult(result);
		}

		@BeforeMethod()
		public void beforeMethod(Method result) {
			test = extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName() + " test Started");
			test.log(LogStatus.INFO, result.getParameterCount() +" "+ "inputs");
			
		}
	 
	 @BeforeMethod
	 void launch() {
		System.out.println("Welcome to spicejet");
		String path = "D:\\Selenium\\geckodriver.exe";
		test.log(LogStatus.PASS, "broswer has been launch");
		// System.setProperty("webdriver.chrome.driver", path);

		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
		// WebDriver dr=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.spicejet.com/");
		
	}
	
	@Test(dataProvider = "dataLoader")
	void Book(String TripType, String DepartureCity, String ArrivalCity, String Departdate, String Returndate,
			String Currency, String CategoryConcession) throws AWTException, InterruptedException {
	try {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//.tripSelection(TripType,DepartureCity,ArrivalCity);
		String tripxf = "//*[@id='travelOptions']//*[text()='";
		String tripxl = "']";
		// System.out.println(a);
		driver.findElement(By.xpath(tripxf + TripType + tripxl)).click();
		test.log(LogStatus.PASS, TripType+" "+"has been selected");
		driver.findElement(By.xpath(tripxf + TripType + tripxl)).sendKeys(Keys.TAB, DepartureCity);
		// *[@class='right1']
		//ArrivalCity
		driver.findElement(By.xpath("//*[@class='right1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='right1']")).sendKeys(ArrivalCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id,'view_date1')]")).click();
		Thread.sleep(2000);
		///
		
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		   	Date dateobj = new Date();
		   	String reportDate = df.format(dateobj);
		   	System.out.println("Report Date: " + reportDate);
		   	//to split current date n store in varible
		   	String datePartscurrent[] = reportDate.split("/");
		   	String monthcurrent  = datePartscurrent[0];
			String daycurrent  = datePartscurrent[1];
			String yearcurrent = datePartscurrent[2];
			System.out.println(monthcurrent+" "+daycurrent+" " +yearcurrent);
			int i=Integer.parseInt(monthcurrent);
			int k=Integer.parseInt(daycurrent);
			int l=Integer.parseInt(yearcurrent);
		//String 	Departdate="12/07/2018";
			
			/*String dateParts[] = Departdate.split("");
			System.out.println(dateParts[0]);
			String a1=dateParts[0];
			String b1=dateParts[1];
			String c1=dateParts[2];
			String d1=dateParts[3];
			String e1=dateParts[4];
			String f1=dateParts[5];
			String g1=dateParts[6];
			String h1=dateParts[7];
			String i1=dateParts[8];
			String j1=dateParts[9];
			String abvc="/";
		//	String dt12=a1+b1+c1+d1+e1+f1+g1+h1+i1+j1;
			String dt=c1+d1+abvc+a1+b1+abvc+e1+f1+g1+h1;
			System.out.println(dt);  */    
	      
	       
			String dateParts1[] = Departdate.split("/");
			String uday  = dateParts1[0];
			String umonth  = dateParts1[1];
			String uyear = dateParts1[2];
			System.out.println(umonth+" "+uday+" " +uyear);
			//to convert string to integer
			int a=Integer.parseInt(umonth);
			int b=Integer.parseInt(uday);
			
			int monthdiff=a-i;
			System.out.println("diff:"+" "+monthdiff);
			//click opration will go for -1
			for(int im=0;im<monthdiff-1;im++)
			{
				driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
				Thread.sleep(3000);
			}
			
			String[] myStringArray1 = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			String text=myStringArray1[a-1];
	System.out.println(text);
	String cx="//*[text()='";
	String cx1="']//ancestor::div//a[text()='";
	String cl="']";
	String xc=cx+text+cx1+b+cl;
	Thread.sleep(3000);
	driver.findElement(By.xpath(xc)).click();
	test.log(LogStatus.PASS, "Date selected successfully");
//	Thread.sleep(3000);
			//*[text()='text']//ancestor::div//a[text()='b']
	////
		
		
		
		
		//driver.findElement(By.xpath("//*[contains(@id,'view_date1')]")).click();
	//	Thread.sleep(3000);
		//added below code for date which is not available or past date
		/*if(driver.findElement(By.xpath("//span[@class='ui-state-default']")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[@class='ui-state-default']")).click();

		}*/
	//	driver.findElement(By.xpath("//span[@class='ui-state-default']")).click();
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//a[@class='ui-state-default']")).click();
		//Thread.sleep(3000);
		if(TripType.equals("Round Trip"))
		{
			driver.findElement(By.xpath("//*[contains(@id,'view_date2')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@class='ui-state-default'])[3]")).click();
			Thread.sleep(3000);
			/*String dateParts11[] = Returndate.split("/");
			String uday1  = dateParts11[0];
			String umonth1  = dateParts11[1];
			String uyear1 = dateParts11[2];
			System.out.println(umonth+" "+uday1+" " +uyear);
			//to convert string to integer
			int a1=Integer.parseInt(umonth);
			int b1=Integer.parseInt(uday1);
			
			int monthdiff1=a1-a;
			System.out.println("diff:"+" "+monthdiff1);
			//click opration will go for -1
			for(int im1=0;im1<monthdiff1-1;im1++)
			{
				driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
				Thread.sleep(3000);
			}
			
			String[] myStringArray11 = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			String text1=myStringArray11[a1-1];
	System.out.println(text1);
	String cx11="//*[text()='";
	String cx12="']//ancestor::div//a[text()='";
	String cl1="']";
	String xc1=cx11+text1+cx12+b1+cl1;
	Thread.sleep(3000);
	driver.findElement(By.xpath(xc)).click();
	Thread.sleep(3000);
*/			
		}
		Select s = new Select(driver.findElement(By.xpath("//*[contains(@id,'Adult')]")));
		s.selectByVisibleText("1");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[contains(@id,'Adult')]")).click();

		s = new Select(driver.findElement(By.xpath("//*[contains(@name,'Child')]")));
		s.selectByVisibleText("1");
		Thread.sleep(2000);
		s = new Select(driver.findElement(By.xpath("//*[contains(@name,'Infant')]")));
		s.selectByVisibleText("1");
		Thread.sleep(2000);
		s = new Select(driver.findElement(By.xpath("//*[contains(@name,'Currency')]")));
		s.selectByVisibleText(Currency);
		Thread.sleep(2000);
		//CategoryConcession
		//label[contains(text(),'Student')]
		String ccf="//label[contains(text(),'";
		String ccl="')]";
		
	//	driver.findElement(By.xpath(ccf+CategoryConcession+ccl)).click();
		driver.findElement(By.xpath("//*[contains(@id,'btn_FindFlights')]")).click();
	// Add validation for below xpath
		// *[@class='orig-dest']
		// *[contains(@class,'total-price')]//span
		// AMD - BLR
		Thread.sleep(6000);
	String ExpectedUrl=	"http://book.spicejet.com/Select.aspx";
	String ActualUrl=driver.getCurrentUrl();
	
	assertEquals(ActualUrl, ExpectedUrl);
	test.log(LogStatus.PASS,"selection page url got validated successfully");
	//This is only for round trip
	if(TripType.equals("Round Trip"))
	{
	driver.findElement(By.xpath("//*[contains(@class,'datepicker-2')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("AvailabilitySearchInputSelectView_ButtonSubmit")).click();
	/*WebElement Error=driver.findElement(By.xpath("//*[contains(text(),'Please re-check')]"));
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(Error));*/
	Thread.sleep(2000);
	
	//if (driver.findElement(By.xpath("//*[contains(text(),'Please re-check')]")).isDisplayed()) {
		String ErrorText=driver.findElement(By.xpath("//*[contains(text(),'Please re-check')]")).getText();
		if(ErrorText.equals("Please re-check the flights selected by you. The departure of your return flight should be atleast 90 minutes after arrival of your incoming flight.")){
			
		
		//assertEquals("Please re-check the flights selected by you. The departure of your return flight should be atleast 90 minutes after arrival of your incoming flight.", ErrorText);
		test.log(LogStatus.PASS, "Error msg validated successfully for return trip "+" "+"Please re-check the flights selected by you. The departure of your return flight should be atleast 90 minutes after arrival of your incoming flight.");
		}
		else {
			test.log(LogStatus.FAIL,"There is no error msg for invalid input for return date");
		 nr=	getScreenshot("noerror");
		}
	//}
	
	/*catch (Exception e) {
		test.log(LogStatus.FAIL,"There is no error msg for invalid input for return date");
	}*/
driver.findElement(By.xpath("//*[contains(@class,'datepicker-2')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[@class='ui-state-default'])[17]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("AvailabilitySearchInputSelectView_ButtonSubmit")).click();
	//*[@class='t_price']
	Thread.sleep(6000);
   String price1=driver.findElement(By.xpath("(//*[@class='t_price'])[1]")).getText();
 
 int price1_1= util.price(price1);
 // price1 = price1.indexOf(".") < 0 ? price1 : price1.replaceAll("0*$", "").replaceAll("\\.$", "");
  // float price1_1 = Float.parseFloat(price1);
  //int price1_1 = Integer.parseInt(price1);	
   Thread.sleep(3000);
   String price2=driver.findElement(By.xpath("(//*[@class='t_price'])[2]")).getText();
   int price2_2 = util.price(price2);
   Thread.sleep(3000);
   
   String totalPrice=driver.findElement(By.xpath("//*[contains(@class,'total-price')]//span")).getText();
  // int totalPrice2 = Integer.parseInt(totalPrice);	
   int totalPrice2= util.price(totalPrice);
   assertEquals(totalPrice2, price1_1+price2_2);
   test.log(LogStatus.PASS,"Round Trip Price calculation has been validated successfully");
   Thread.sleep(3000);
	}
	//driver.findElement(By.id("ControlGroupSelectView_AvailabilityInputSelectView_CheckBoxStudentAgreement")).click();
//	id="AvailabilitySearchInputSelectView_ButtonSubmit"
	//*[@id='ControlGroupSelectView_AvailabilityInputSelectView_CheckBoxStudentAgreement']
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(10000);
	String FirstName=util.randonString(5);
	String LastName=util.randonString(5);
	String phoneno=util.randonNumber(10);
	Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@name,'FirstName')]")).sendKeys(FirstName);
		driver.findElement(By.xpath("//*[contains(@name,'LastName')]")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//*[contains(@name,'TextBoxHomePhone')]")).sendKeys(phoneno);
		String endEx="@gmail.com";
		String emailId=FirstName+endEx;
		// CONTROLGROUPPASSENGER$ContactInputPassengerView$TextBoxEmailAddress
		driver.findElement(By.xpath("//*[contains(@name,'TextBoxEmailAddress')]")).sendKeys(emailId);
		// name="contact_cities_list_india"
		s = new Select(driver.findElement(By.xpath("//*[@name='contact_cities_list_india']")));
		s.selectByVisibleText("Agartala");
		// s.selectByVisibleText("INR");
		driver.findElement(By.xpath("//*[contains(@id,'IamFlying')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@name,'FirstName_1')]")).sendKeys("azq");
		driver.findElement(By.xpath("//*[contains(@name,'LastName_1')]")).sendKeys("qwer");
		driver.findElement(By.xpath("//*[contains(@name,'FirstName_0_0')]")).sendKeys("erw");
		driver.findElement(By.xpath("//*[contains(@name,'LastName_0_0')]")).sendKeys("iujhyh");

		driver.findElement(By.xpath("//*[@name='custom_date_picker']")).click();
		Thread.sleep(3000);
		s = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")));
		s.selectByIndex(1);
		driver.findElement(By.xpath("//a[@class='ui-state-default']")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Travellers details passed successfully");
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[text()='Skip to Continue']")).click();
		Thread.sleep(9000);
		boolean PaymentPage=driver.findElement(By.xpath("//*[@class='payment-options']")).isDisplayed();
		assertTrue(PaymentPage,"Not landed to payment page");
		//*[contains(@name,'TextBoxACCTNO')]
		String ccno=util.randonNumber(10);
		driver.findElement(By.xpath("//*[contains(@name,'TextBoxACCTNO')]")).sendKeys(ccno);
		Thread.sleep(4000);
		
		
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("Server is down");
	}
	finally {
		System.out.println("");
	}
	
	}

	@AfterMethod
	void teardown() 
	{
		driver.quit();
	}
}
