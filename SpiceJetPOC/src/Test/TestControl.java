package Test;
import java.io.File;





import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;


import org.apache.logging.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.examples.LoadPasswordProtectedXlsx;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;



public class TestControl {
	
	public WebDriver driver;
	public Properties OR;
	public File f1;
	public FileInputStream file;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
//	public static final Logger logger=Logger.getLogger(TestControl.class.getName());
	
	static
	{
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir") + "\\src\\report" + formater.format(calendar.getTime()) + ".html" , false);
	}
	
	
	public void getBrowser(String browser)
	{
		if(System.getProperty("os.name").contains("Window"));
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}
	
	public String getScreenshot(String imageName) throws IOException
	{
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation=System.getProperty("user.dir")+"\\src\\main\\java\\screenshot";
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName=imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile=new File(actualImageName);
		FileUtils.copyFile(image,destFile);
		return actualImageName;
		
	}
	//***************

	@DataProvider(name = "dataLoader")
	public Object[][] testDataProvider(Method testMethod) {
		// startExtentTest(testMethod.getDeclaringClass().getSimpleName());
		System.out.println("Starting Test : " + testMethod.getDeclaringClass().getName());
		//logger.info("Starting Test : " + testMethod.getDeclaringClass().getName());
		String testClass = testMethod.getDeclaringClass().getSimpleName();

		List<List<Object>> testDataSetList = new ArrayList<>();

		XSSFWorkbook testDataBook = null;
		FileInputStream testDataStream = null;
		try {
			String testDataFilePath = null;
			//HashMap<String, String> testDataFileDetails = testDataMapping.get(testClass);
			try {
			//	testDataFilePath = TESTDATADIR + "/" + testDataFileDetails.get("DataFile");
				testDataFilePath = "C:\\Users\\29265\\Desktop\\SpicjetTestdata.xlsx";
				if (!testDataFilePath.endsWith(".xlsx")) {
					testDataFilePath += ".xlsx";
				}
				
			} catch (NullPointerException e) {
				throw new NullPointerException("Test File/Sheet Name is not specified for class " + testClass);
			}

			File testDataFile = new File(testDataFilePath);
			testDataStream = new FileInputStream(testDataFile);
			testDataBook = new XSSFWorkbook(testDataStream);
			XSSFSheet testDataSheet = testDataBook.getSheet("Regression");
			int numberOfDataElement = testDataSheet.getLastRowNum();
			int numberOfDataSet = 0;

			for (int rowCounter = 0; rowCounter <= numberOfDataElement; rowCounter++) {
				if (testDataSheet.getRow(rowCounter) != null
						&& numberOfDataSet < (testDataSheet.getRow(rowCounter).getLastCellNum() - 1)) {
					numberOfDataSet = testDataSheet.getRow(rowCounter).getLastCellNum() - 1;
				}
			}

			for (int columnCounter = 1; columnCounter < numberOfDataSet + 1; columnCounter++) {
				String testDataFlag = null;
				try {
					testDataFlag = testDataSheet.getRow(1).getCell(columnCounter).getStringCellValue();
				} catch (NullPointerException e) {
					testDataBook.close();
					testDataStream.close();
					throw new NullPointerException("Issue with reading data from column " + columnCounter);
				}

				if (true) {
					List<Object> testDataSet = new ArrayList<>();

					for (int rowCounter = 2; rowCounter <= numberOfDataElement; rowCounter++) {
						try {
							if (testDataSheet.getRow(rowCounter) != null
									&& testDataSheet.getRow(rowCounter).getCell(1) != null) {
								String testData;
								String elementName = testDataSheet.getRow(rowCounter).getCell(1).getStringCellValue();
								if (elementName != null && elementName.trim().length() > 0) {
									try {
										testData = testDataSheet.getRow(rowCounter).getCell(columnCounter)
												.getStringCellValue();
									} catch (NullPointerException e) {
										testData = "";
									}
									testDataSet.add(testData.trim());
								}
							}
						} catch (NullPointerException e) {
							testDataBook.close();
							testDataStream.close();
							throw new NullPointerException(
									"Issue with reading data from column : " + columnCounter + ", row : " + rowCounter);
						}
					}
					testDataSetList.add(testDataSet);
				}
			}
		} catch (IOException e) {
		//	logger.warn("Error in reading spreadsheet");
			System.err.println("Error in reading spreadsheet");
		} catch (NullPointerException e) {
			if (e.getLocalizedMessage() != null) {
			//	logger.warn(e.getLocalizedMessage());
				System.err.println(e.getLocalizedMessage());
			}
			//logger.warn("TestData issue. Check test data file/sheet mapping");
			System.err.println("TestData issue. Check test data file/sheet mapping");
		} finally {
			try {
				if (testDataBook != null) {
					testDataBook.close();
				}
				if (testDataStream != null) {
					testDataStream.close();
				}
			} catch (Exception e) {
			//	logger.warn("Issue with workbook/datastream close");
				System.err.println("Issue with workbook/datastream close");
			}
		}

		Object[][] dataSet = new Object[testDataSetList.size()][];
		int dataSetCounter = 0;
		for (List<Object> testDataSet : testDataSetList) {
			dataSet[dataSetCounter++] = testDataSet.toArray(new Object[testDataSet.size()]);
		}
		//logger.info("No of DataSet to Execute : " + dataSet.length);
		System.out.println("No of DataSet to Execute : " + dataSet.length);
		return dataSet;
	}
	
	
	/*public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "broswer has been launch");
			test.log(LogStatus.PASS, "triptype has been selected");
			test.log(LogStatus.PASS, "Date selected successfully");
			test.log(LogStatus.PASS, "selection page url got validated successfully");
			test.log(LogStatus.PASS, "Travellers details passed successfully");
			test.log(LogStatus.PASS, "broswer has been closed");
			
			//test.log(LogStatus.PASS, "Date selected successfully");
			test.log(LogStatus.PASS, result.getName() + " test is pass");
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot("");
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
		test.log(LogStatus.INFO, result.getParameterCount() +" "+ "inputs are there");
		
	}*/
	@BeforeMethod
	void LoadPro() throws IOException
	{
		File src=new File(System.getProperty("user.dir")+"\\"+"objectRepo\\ObjectLocator.properties");
		 
		// Create  FileInputStream object
		FileInputStream fis=new FileInputStream(src);
		 
		// Create Properties class object to read properties file
		Properties pro=new Properties();
		 
		// Load file so we can use into our script
		pro.load(fis);
		System.out.println(pro.getProperty("ArrivalCity"));
		System.out.println("Property class loaded");
		System.err.println();
	}
	@AfterClass(alwaysRun = true)
	public void endTest() {
		//driver.quit();
		extent.endTest(test);
		extent.flush();
	}

}
