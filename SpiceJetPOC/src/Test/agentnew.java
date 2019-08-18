package Test;



import java.awt.AWTException;


import java.io.File;
import java.io.IOException; 
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import utility.util;

public class agentnew extends TestControlAgent {
	static String	day;
	static String cod;
	static String can;
	static boolean flag=true;

	WebDriver driver;
	String nr, EmailID = "";
	int a = 0, k = 3, b;
	Map<String, Object[]> pnrdata = new TreeMap<String, Object[]>();
	List<String> lines;
	Select select;
	List<String> alltitle;
	List<String> allfname;
	List<String> alllname;

	List<String> pnrrecord = new ArrayList<>();
	List<String> AmountRecord = new ArrayList<>();
	List<String> mList = new ArrayList<>();

	/*
	 * List<String> getPassengersName(String path) throws IOException { lines =
	 * Files.readAllLines(Paths.get(path)); System.out.println("before booking:=" +
	 * lines.size()); // System.out.println(lines.get(2)); for (String line : lines)
	 * { System.out.println(line); } return lines; }
	 */
	// pnr, Amount, EmailID, "LASTNAME"
	@BeforeSuite
	void initial() throws InvalidFormatException, IOException {
		System.err.println("done");
		util.GetColumnValue(0, "Passenger_Name_List");
		alltitle = util.GetColumnValue(0, "Passenger_Name_List");
		allfname = util.GetColumnValue(1, "Passenger_Name_List");
		alllname = util.GetColumnValue(2, "Passenger_Name_List");
		System.err.println("done");
		

		/*
		 * Object [][]pnrdetails= {{ "Date Of Booking (yyyy/MM/dd)", "DepartureCity",
		 * "ArrivalCity", "FlightNo", "PNR", "Date Of Journey", "Amount", "EmailID",
		 * "Passengers Name","Cancellation Date(yyyy/MM/dd)","Refund Amount"}}; if
		 * (pnrdetails != null) { //util.PrintPnr(pnrdata); util.AppendPnr(pnrdetails);
		 * }
		 */
		/*
		 * pnrdata.put("A", new Object[] { "Date Of Booking (yyyy/MM/dd)",
		 * "DepartureCity", "ArrivalCity", "FlightNo", "PNR", "Date Of Journey",
		 * "Amount", "EmailID",
		 * "Passengers Name","Cancellation Date(yyyy/MM/dd)","Refund Amount"});
		 */}

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			//test.log(LogStatus.PASS, result.getName() + " test is pass");

		} else if (result.getStatus() == ITestResult.SKIP) {
			/*test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());*/
		} else if (result.getStatus() == ITestResult.FAILURE) {
			/*test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot(nr);
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));*/
		} else if (result.getStatus() == ITestResult.STARTED) {
			//test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		//test = extent.startTest(result.getName());
		//test.log(LogStatus.INFO, result.getName() + " test Started");
		//test.log(LogStatus.INFO, result.getParameterCount() + " " + "inputs");

	}

	@BeforeMethod
	void launch() throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println("Welcome to spicejet");
		String path = "D:\\Selenium\\geckodriver.exe";
		//test.log(LogStatus.PASS, "broswer has been launch");

		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();

		// driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://book.spicejet.com/LoginAgent.aspx");

	}

	/**
	 * @param TripType
	 * @param DepartureCity
	 * @param ArrivalCity
	 * @param FlightNo
	 * @param Fare
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test(dataProvider = "dataLoader")
	void Book(String TripType, String DepartureCity, String ArrivalCity, String FlightNo, String Fare, String NoOfPass)
			throws AWTException, InterruptedException, InvalidFormatException, IOException, ParseException {
		// System.out.println(NoOfPass);
		int np = Integer.parseInt(NoOfPass);
		// System.out.println(DepartureCity);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);
		/*
		 * alltitle = util.GetColumnValue(0, "Passenger_Name_List"); allfname =
		 * util.GetColumnValue(1, "Passenger_Name_List"); alllname =
		 * util.GetColumnValue(2, "Passenger_Name_List");
		 */// List<Integer> passcoutnlist = null;

		driver.findElement(By.id("ControlGroupLoginAgentView_AgentLoginView_TextBoxUserID")).sendKeys("SDMARKETNG");
		Thread.sleep(3000);

		driver.findElement(By.id("ControlGroupLoginAgentView_AgentLoginView_PasswordFieldPassword"))
		.sendKeys("India@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[contains(@class,'closethick')]")).click();
		// List <String>dateList = util.GetColumnValue(0, "Flight_Date_with_PAX_count");
		List dateList = getDate("Sheet1");
		System.out.println(dateList);
		String tripxf = "//*[@id='travelOptions']//*[text()='";
		String tripxl = "']";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();
		String reportDate = df.format(dateobj);
		System.out.println("Report Date: " + reportDate);
		// to split current date n store in varible
		String datePartscurrent[] = reportDate.split("/");

		String monthcurrent = datePartscurrent[0];
		String daycurrent = datePartscurrent[1];
		String yearcurrent = datePartscurrent[2];
		System.out.println(monthcurrent + " " + daycurrent + " " + yearcurrent);
		int i = Integer.parseInt(monthcurrent);
		int k = Integer.parseInt(daycurrent);
		int l = Integer.parseInt(yearcurrent);
		String cx = "//*[text()='";
		// List date = getDate(FlightNo);
		for (int q = 0; q < dateList.size(); q++) {
			driver.get("https://book.spicejet.com/Search.aspx");
			Thread.sleep(9000);

			// add trip booking flow here

			try {
				tripxf = "//*[@id='travelOptions']//*[text()='";
				tripxl = "']";

				// Round Trip
				driver.findElement(By.xpath(tripxf + TripType + tripxl)).click();
				//test.log(LogStatus.PASS, TripType + " " + "has been selected");

				driver.findElement(By.xpath(tripxf + TripType + tripxl)).sendKeys(Keys.TAB, DepartureCity);
				//test.log(LogStatus.PASS, DepartureCity + " " + "has been selected");

				driver.findElement(By.xpath("//*[@class='right1 mobile-right destination']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='right1 mobile-right destination']")).sendKeys(ArrivalCity);
				//test.log(LogStatus.PASS, ArrivalCity + " " + "has been selected");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[contains(@id,'custom_date_picker_id_1')]")).click();
				Thread.sleep(2000);

				/*
				 * Select s = new Select(driver.findElement(By.xpath(
				 * "//*[contains(@id,'ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT')]"
				 * ))); s.selectByVisibleText(passcoutnlist.get(p).toString());
				 * driver.findElement(By.xpath("//*[contains(@id,'custom_date_picker_id_1')]")).
				 * click(); Thread.sleep(2000);
				 */
			}

			catch (Exception e) {
				// TODO: handle exception
				System.out.println("price is not matching for given condition");
				/*
				 * Select s = new Select(driver.findElement(By.xpath(
				 * "//*[contains(@id,'AvailabilitySearchInputSelectView_DropDownListPassengerType_ADT')]"
				 * ))); s.selectByIndex(passcoutnlist.get(p));
				 */
				// s.selectByVisibleText(passcoutnlist.get(p).toString());
			}
			String val = (String) dateList.get(q);
			String dateParts1[] = val.split("/");
			String umonth = dateParts1[0];
			String uday = dateParts1[1];
			String uyear = dateParts1[2];
			System.out.println(umonth + " " + uday + " " + uyear);
			// to convert string to integer
			int a = Integer.parseInt(umonth);
			int b = Integer.parseInt(uday);

			int monthdiff = a - i;
			System.out.println("diff:" + " " + monthdiff);
			//driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
			//driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
			// click opration will go for -1
			/*	try {
				if (driver.findElement(By.xpath("//*[contains(@id,'custom_date_picker_id_1')]")).isDisplayed()) {
					for (int im = 0; im < monthdiff - 1; im++) {
						driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
						Thread.sleep(3000);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}*/

			/*	
			 * driver.findElement(By.xpath("//*[@class='date-wrapper date_wrapper_1']")).
			 * click(); Thread.sleep(3000); // value String SelectPageDate =
			 * driver.findElement(By.id("date_picker_id_1")).getAttribute("value"); String
			 * dateParts11[] = SelectPageDate.split("-"); String uday1 = dateParts11[0];
			 * String umonth1 = dateParts11[1]; String uyear1 = dateParts11[2];
			 * System.out.println(umonth1 + " " + uday1 + " " + uyear1); // to convert
			 * string to integer int a1 = Integer.parseInt(umonth1); int b1 =
			 * Integer.parseInt(uday1); int monthdiff1 = a - a1; for (int im = 0; im <
			 * monthdiff1 - 1; im++) {
			 * driver.findElement(By.xpath("(//*[contains(text(),'Next')])[3]")).click();
			 * Thread.sleep(3000); }*/




			String[] myStringArray1 = { "January", "February", "March", "April", "May", "June", "July", "August",
					"September", "October", "November", "December" };
			String text = myStringArray1[a - 1];
			System.out.println(text);

			String cx1 = "']//parent::div//parent::div//parent::div//a[text()='";
			String cl = "']";
			String xc = cx + text + cx1 + b + cl;
			Thread.sleep(3000);
			//	driver.findElement(By.xpath(xc)).click();
			//driver.findElement(By.xpath("(//a[text()='15'])[6]")).click();

			//test.log(LogStatus.PASS, dateList.get(q) + " " + "Date selected successfully");

			Thread.sleep(5000);

			boolean naviagtion=true;
			
			//driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
			//Thread.sleep(2000);
			//driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
			//Thread.sleep(2000);
			//driver.findElement(By.xpath(xc)).click();
			while(naviagtion) {
				/*if (driver.findElement(By.xpath(xc)).isDisplayed()) {
					driver.findElement(By.xpath(xc)).click();
					naviagtion=false;
				}
				else {
					driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
				}*/
				try {
					if (driver.findElement(By.xpath(xc)).isDisplayed()) {
						driver.findElement(By.xpath(xc)).click();
						naviagtion=false;
					}
//					driver.findElement(By.xpath(xc)).click();
//					naviagtion=false;
				}
				catch (Exception e) {
					// TODO: handle exception
					driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
				}

			}
			 
			// add passenger field code below
			try {
				Thread.sleep(2000);
				driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(2000);
				for (int w = 1; w < np; w++) {
					driver.findElement(By.id("hrefIncAdt")).click();
					Thread.sleep(1000);
				}
				/*
				 * select = new Select(driver.findElement(By.xpath(
				 * "//*[contains(@id,'ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT')]"
				 * ))); select.selectByVisibleText(passcoutnlist.get(p).toString());
				 */
			} catch (Exception e) {
				/*
				 * select = new Select(driver.findElement(By.xpath(
				 * "//*[contains(@id,'AvailabilitySearchInputSelectView_DropDownListPassengerType_ADT')]"
				 * ))); select.selectByIndex(passcoutnlist.get(p)-1);
				 */
			}

			try {
				if (driver
						.findElement(By.xpath(
								"//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit']"))
						.isDisplayed()) {
					driver.findElement(By
							.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit']"))
					.click();
					Thread.sleep(5000);
				}
			} catch (Exception e) {
				// driver.findElement(By.id("AvailabilitySearchInputSelectView_ButtonSubmit")).click();
			}
			String farelx = "']//ancestor::tr//span[@class='flightfare']";
			// need to add in try block with displayed function of selenium
			String Flightfare = driver.findElement(By.xpath(cx + FlightNo + farelx)).getText();
			Flightfare = Flightfare.replace(" INR", "");
			int Flightfare1 = util.price(Flightfare);

			Fare = Fare.replace("<", "");
			int fareoriginal = Integer.parseInt(Fare);
			System.out.println(Fare);
			// if price condition not matching
			// if matching
			if (Flightfare1 < fareoriginal) {
				driver.findElement(By.xpath(cx + FlightNo + farelx)).click();
				//test.log(LogStatus.PASS, FlightNo + " " + "selected successfully for price " + " " + Flightfare1);

				// complete flow for booking step n pnr generation
				// handle everything like booking flow with agent login for next pnr
				driver.findElement(By.id("ControlGroupSelectView_ContactInputGSTViewSelectView_CheckBoxGST")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[text()='Continue']")).click();

				Thread.sleep(4000);
				driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone"))
				.sendKeys("8524527137");
				driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxOtherPhone"))
				.sendKeys("8524527137");
				String Title = "CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_DropDownListTitle_";
				String Fname = "CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxFirstName_";
				String Lname = "CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxLastName_";

				List<String> namec = new ArrayList<String>();
				String namecom = null;
				for (int j = 0; j < np; j++) {
					Thread.sleep(2000);
					select = new Select(driver.findElement(By.id(Title + j)));
					Thread.sleep(2000);
					select.selectByValue(alltitle.get(j).toUpperCase());

					driver.findElement(By.id(Fname + j)).sendKeys(allfname.get(j));
					driver.findElement(By.id(Lname + j)).sendKeys(alllname.get(j));

					EmailID = allfname.get(j) + alllname.get(j);

					namecom = alltitle.get(j) + " " + allfname.get(j) + " " + alllname.get(j);
					namec.add(namecom);
					//test.log(LogStatus.PASS, "Passenger Name" + " " + namecom);
				}

				String listString = "";

				if (namec != null) {
					listString = namec.toString();
					listString = listString.substring(1, listString.length() - 1);
					System.out.println(listString);
				}
				List<String> mail = new ArrayList<>();
				mail.add("gmail");
				mail.add("hotmail");
				mail.add("yahoomail");
				Random ran = new Random();
				int shomail = 1 + ran.nextInt(2);

				// need to change email id format
				List<String> em = new ArrayList<>();
				em.add("its");
				em.add("rockz");
				em.add("cool");
				em.add("wow");
				em.add("solid");
				em.add("tricky");
				ran = new Random();
				int showMe = 1 + ran.nextInt(5);
				EmailID = EmailID + util.randonNumber(3);
				EmailID = EmailID.replaceAll("\\s", "");
				EmailID = em.get(showMe) + EmailID + "@" + mail.get(shomail) + ".com";
				driver.findElement(By.id("CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress"))
				.sendKeys(EmailID);

				System.out.println(FlightNo + ":" + " " + EmailID);
				for (int j = 0; j < np; j++) {
					allfname.remove(0);
					alltitle.remove(0);
					alllname.remove(0);

				}
				System.out.println(allfname.size());
				System.out.println(alltitle.size());
				System.out.println(alllname.size());
				// add step for pnr n payment below
				driver.findElement(By.xpath("//*[text()='Continue']")).click();
				Thread.sleep(7000);
				driver.findElement(By.id("spiceAssuranceBtn")).click();
				String jetassure = "(//*[contains(@name,'SpiceJetAssurancePassengerView')])[";
				for (int j = 1; j <= np; j++) {
					driver.findElement(By.xpath(jetassure + j + "]")).click();
					Thread.sleep(1000);
				}
				Thread.sleep(6000);
				driver.findElement(By.xpath("//*[text()='Continue']")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//*[text()='Skip to Continue']")).click();
				Thread.sleep(9000);
				driver.findElement(By.id("AgencyAccount_tab")).click();
				Thread.sleep(2000);
				//*[@id='totalDue']
				String am=driver.findElement(By.id("totalDue")).getText();
				System.out.println("amount:="+am);
				Thread.sleep(2000);
				driver.findElement(By.id("confirm-payment-button")).click();
				Thread.sleep(9000);
				// add extent report here with date ,flight no
				try {
					if (driver.findElement(By.xpath("(//a[@class='popup-close2'])[2]")).isDisplayed()) {
						driver.findElement(By.xpath("(//a[@class='popup-close2'])[2]")).click();
						Thread.sleep(2000);
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
				// String pnr = "1234";
				String pnr = driver.findElement(By.xpath("//*[@id='bookingDetail']//strong")).getText();
				Thread.sleep(7000);
				driver.findElement(By.xpath("//*[@id='paymentHeader']")).click();
				Thread.sleep(4000);
				String Amount = driver
						.findElement(By.xpath("(//*[contains(text(),'Total Price')]//parent::td//span)[2]")).getText();
				Amount=Amount.replace("INR", "");
				System.out.println(Amount);
				Amount=Amount.replace(" ", "");
				System.out.println("PNR=:" + pnr + " " + "Total Amount=:" + Amount);
				Thread.sleep(2000);
				String sc = getScreenshot("Spicejet");
				pnrrecord.add(pnr);
				AmountRecord.add(Amount);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				//////modification in date
				String datePattern = "dd-MMM-yy";
				Date today;
				String DOB;
				SimpleDateFormat simpleDateFormat;
				simpleDateFormat = new SimpleDateFormat(datePattern);
				today = new Date();
				DOB = simpleDateFormat.format(today);
				////////////////
				// System.out.println(dtf.format(localDate)); //2016/11/16
				/*test.log(LogStatus.PASS,
						"AgentBooking details" + " " + DepartureCity + " ," + ArrivalCity + " ," + FlightNo + " ," + pnr
								+ " ," + dateList.get(q) + Amount + " ," + " " + EmailID + " ," + listString);
				test.log(LogStatus.PASS, test.addScreenCapture(sc));*/
				//	System.out.println(util.getCancelDate(dateList.get(q).toString()));
				//	Date COD = util.getCancelDate(dateList.get(q).toString());
				/*	System.out.println("COD=" + COD.toString());
				String cod = COD.toString();
				String string1[] = cod.split(" ");
				// string1=string1.replace("00:00:00", arg1)
				String mon = string1[1];
				String day1 = string1[2];
				String year = string1[5];
				cod = mon + " " + day1 + "," + " " + year;*/
				// cod=day1+"/"+mon+"/"+year;

				///////////////////////////////////
				//String abc="7/13/2018";
				day=d(dateList.get(q).toString());
				can=cod;
				//input Jul 07, 2018
				System.out.println("before day=:"+day);


				while (flag) {

					if (day.equals("Saturday") || day.equals("Sunday")) {
						day= d(dateList.get(q).toString());
						can=cod;
						System.out.println(can);

					}
					else {
						System.out.println("after day=:"+day);
						flag=false;
					}

				}

				///////////////////////////////////
				simpleDateFormat = new SimpleDateFormat(datePattern);
				today = new Date(dateList.get(q).toString());
				String DOJ;
				DOJ = simpleDateFormat.format(today);
				today = new Date(can);

				can = simpleDateFormat.format(today);


				//	Object[][] pnrdetails = { { dtf.format(localDate), DepartureCity, ArrivalCity, FlightNo, pnr,
				//		dateList.get(q), Amount, EmailID, np, listString, can } };

				Object[][] pnrdetails = { {DOB, DepartureCity, ArrivalCity, FlightNo, pnr,
					DOJ, am, EmailID, np, listString, can } };

				// pnrdata.put(pnr, new Object[] {
				// dtf.format(localDate),DepartureCity,ArrivalCity,FlightNo,pnr,
				// dateList.get(q),Amount, EmailID, listString ,cod});
				// util.PrintPnr("", pnrdata);
				if (pnrdetails != null) {
					// util.PrintPnr(pnrdata);
					util.AppendPnr(pnrdetails);
				}
				driver.get("https://book.spicejet.com/Search.aspx");

				Thread.sleep(7000);

			}

		}
	}

	@AfterMethod
	void teardow() {
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
	public static String  d(String abc) throws ParseException
	{
		Date COD = util.getCancelDate(abc);
		System.out.println("COD=" + COD.toString());
		cod = COD.toString();
		String string1[] = cod.split(" ");
		// string1=string1.replace("00:00:00", arg1)
		String mon = string1[1];
		String day1 = string1[2];
		String year = string1[5];
		cod = mon + " " + day1 + "," + " " + year;
		//System.out.println(cod);
		String day = util.ExtractDayFromDate(cod);
		return day;	
	}

}
