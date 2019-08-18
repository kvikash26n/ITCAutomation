/**
 * 
 */
package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author 29265
 *
 */
public class ithtestcontroller {
	//private static HashMap<String, HashMap<String, String>> testDataMapping = new HashMap<>();
	//private static List<List<Object>> TESTDATASET;
	//int TestCounter = 0;
	private static HashMap<String, HashMap<String, String>> testDataMapping = new HashMap<>();
	public WebDriver driver;
	public static final String DATA_XLSX_FILE_PATH ="C:\\Users\\29265\\Desktop\\ITH_Test_Data.xlsx";
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
	@AfterClass(alwaysRun = true)
	public void endTest() {
		//driver.quit();
		extent.endTest(test);
		extent.flush();
	}
	public String getScreenshot(String imageName,WebDriver driver) throws IOException
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
	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			//test.log(LogStatus.PASS, test.addScreenCapture("ITH"));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
		//	String screen = getScreenshot("ith",driver);
			test.log(LogStatus.FAIL, test.addScreenCapture("ITH"));
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
		//test.log(LogStatus.INFO, result.getParameterCount() + " " + "inputs");
	}
	
	
	///ith dataloader
	/*@BeforeSuite
	void PreAct()
	{
		prepareTestDataMapping();
	}
	*/
	@DataProvider(name = "dataLoader_ls")
	public Object[][] testDataProvider_ls(Method testMethod) {
		// startExtentTest(testMethod.getDeclaringClass().getSimpleName());
		System.out.println("Starting Test : " + testMethod.getDeclaringClass().getName());
		//logger.info("Starting Test : " + testMethod.getDeclaringClass().getName());
		String testClass = testMethod.getDeclaringClass().getSimpleName();

		List<List<Object>> testDataSetList = new ArrayList<>();
		String elementName = null ;
		XSSFWorkbook testDataBook = null;
		FileInputStream testDataStream = null;
		try {
			String testDataFilePath = null;
			//HashMap<String, String> testDataFileDetails = testDataMapping.get(testClass);
			try {
			//	testDataFilePath = TESTDATADIR + "/" + testDataFileDetails.get("DataFile");
				testDataFilePath = DATA_XLSX_FILE_PATH;
				if (!testDataFilePath.endsWith(".xlsx")) {
					testDataFilePath += ".xlsx";
				}
				
			} catch (NullPointerException e) {
				throw new NullPointerException("Test File/Sheet Name is not specified for class " + testClass);
			}

			File testDataFile = new File(testDataFilePath);
			testDataStream = new FileInputStream(testDataFile);
			testDataBook = new XSSFWorkbook(testDataStream);
			//login
			//XSSFSheet testDataSheet = testDataBook.getSheet("Input_Data");
			XSSFSheet testDataSheet = testDataBook.getSheet("login");
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

				if (testDataFlag != null && testDataFlag.trim().startsWith("Y")) {
					List<Object> testDataSet = new ArrayList<>();

					for (int rowCounter = 2; rowCounter <= numberOfDataElement; rowCounter++) {
						try {
							if (testDataSheet.getRow(rowCounter) != null
									&& testDataSheet.getRow(rowCounter).getCell(1) != null) {
								String testData;
							try {
								 elementName = testDataSheet.getRow(rowCounter).getCell(1).getStringCellValue();
								
							}	catch (Exception e) {
								 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(1).getNumericCellValue();
								 elementName=String.valueOf(noofpass);
							}
								
								if (elementName != null && elementName.trim().length() > 0) {
									try {
										testData = testDataSheet.getRow(rowCounter).getCell(columnCounter)
												.getStringCellValue();
									} catch (Exception e) {
										//testData = "";
										 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(columnCounter).getNumericCellValue();
										 testData=String.valueOf(noofpass);
										
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


	@DataProvider(name = "dataLoader_ps")
	public Object[][] testDataProvider1(Method testMethod) {
		// startExtentTest(testMethod.getDeclaringClass().getSimpleName());
		System.out.println("Starting Test : " + testMethod.getDeclaringClass().getName());
		//logger.info("Starting Test : " + testMethod.getDeclaringClass().getName());
		String testClass = testMethod.getDeclaringClass().getSimpleName();

		List<List<Object>> testDataSetList = new ArrayList<>();
		String elementName = null ;
		XSSFWorkbook testDataBook = null;
		FileInputStream testDataStream = null;
		try {
			String testDataFilePath = null;
			//HashMap<String, String> testDataFileDetails = testDataMapping.get(testClass);
			try {
			//	testDataFilePath = TESTDATADIR + "/" + testDataFileDetails.get("DataFile");
				testDataFilePath = DATA_XLSX_FILE_PATH;
				if (!testDataFilePath.endsWith(".xlsx")) {
					testDataFilePath += ".xlsx";
				}
				
			} catch (NullPointerException e) {
				throw new NullPointerException("Test File/Sheet Name is not specified for class " + testClass);
			}

			File testDataFile = new File(testDataFilePath);
			testDataStream = new FileInputStream(testDataFile);
			testDataBook = new XSSFWorkbook(testDataStream);
			//login
			//XSSFSheet testDataSheet = testDataBook.getSheet("Input_Data");
			XSSFSheet testDataSheet = testDataBook.getSheet("passenger_count");
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

				if (testDataFlag != null && testDataFlag.trim().startsWith("Y")) {
					List<Object> testDataSet = new ArrayList<>();

					for (int rowCounter = 2; rowCounter <= numberOfDataElement; rowCounter++) {
						try {
							if (testDataSheet.getRow(rowCounter) != null
									&& testDataSheet.getRow(rowCounter).getCell(1) != null) {
								String testData;
							try {
								 elementName = testDataSheet.getRow(rowCounter).getCell(1).getStringCellValue();
								
							}	catch (Exception e) {
								 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(1).getNumericCellValue();
								 elementName=String.valueOf(noofpass);
							}
								
								if (elementName != null && elementName.trim().length() > 0) {
									try {
										testData = testDataSheet.getRow(rowCounter).getCell(columnCounter)
												.getStringCellValue();
									} catch (Exception e) {
										//testData = "";
										 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(columnCounter).getNumericCellValue();
										 testData=String.valueOf(noofpass);
										
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
	@DataProvider(name = "dataLoader_bf")
	public Object[][] testDataProviderbf(Method testMethod) {
		// startExtentTest(testMethod.getDeclaringClass().getSimpleName());
		System.out.println("Starting Test : " + testMethod.getDeclaringClass().getName());
		//logger.info("Starting Test : " + testMethod.getDeclaringClass().getName());
		String testClass = testMethod.getDeclaringClass().getSimpleName();

		List<List<Object>> testDataSetList = new ArrayList<>();
		String elementName = null ;
		XSSFWorkbook testDataBook = null;
		FileInputStream testDataStream = null;
		try {
			String testDataFilePath = null;
			//HashMap<String, String> testDataFileDetails = testDataMapping.get(testClass);
			try {
			//	testDataFilePath = TESTDATADIR + "/" + testDataFileDetails.get("DataFile");
				testDataFilePath = DATA_XLSX_FILE_PATH;
				if (!testDataFilePath.endsWith(".xlsx")) {
					testDataFilePath += ".xlsx";
				}
				
			} catch (NullPointerException e) {
				throw new NullPointerException("Test File/Sheet Name is not specified for class " + testClass);
			}

			File testDataFile = new File(testDataFilePath);
			testDataStream = new FileInputStream(testDataFile);
			testDataBook = new XSSFWorkbook(testDataStream);
			//login
			//XSSFSheet testDataSheet = testDataBook.getSheet("Input_Data");
			XSSFSheet testDataSheet = testDataBook.getSheet("booking_flow");
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

				if (testDataFlag != null && testDataFlag.trim().startsWith("Y")) {
					List<Object> testDataSet = new ArrayList<>();

					for (int rowCounter = 2; rowCounter <= numberOfDataElement; rowCounter++) {
						try {
							if (testDataSheet.getRow(rowCounter) != null
									&& testDataSheet.getRow(rowCounter).getCell(1) != null) {
								String testData;
							try {
								 elementName = testDataSheet.getRow(rowCounter).getCell(1).getStringCellValue();
								
							}	catch (Exception e) {
								 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(1).getNumericCellValue();
								 elementName=String.valueOf(noofpass);
							}
								
								if (elementName != null && elementName.trim().length() > 0) {
									try {
										testData = testDataSheet.getRow(rowCounter).getCell(columnCounter)
												.getStringCellValue();
									} catch (Exception e) {
										//testData = "";
										 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(columnCounter).getNumericCellValue();
										 testData=String.valueOf(noofpass);
										
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


private void prepareTestDataMapping() {
		XSSFWorkbook testDataBook = null;
		FileInputStream testDataStream = null;
		try {
			File testDataFile = new File("C:\\Automation\\SpiceJetPOC\\TestData\\ScriptDataSheetMapping1.xlsx");
			testDataStream = new FileInputStream(testDataFile);
			testDataBook = new XSSFWorkbook(testDataStream);
			XSSFSheet testDataSheet = testDataBook.getSheet(("ScriptDataSheetMapping"));

			for (int rowCounter = 0; rowCounter <= testDataSheet.getLastRowNum(); rowCounter++) {
				XSSFRow currentRow = testDataSheet.getRow(rowCounter);
				HashMap<String, String> testDataDetails = new HashMap<>();
				testDataDetails.put("DataFile", currentRow.getCell(1).getStringCellValue().trim());
				testDataDetails.put("DataSheet", currentRow.getCell(2).getStringCellValue().trim());
				testDataMapping.put(currentRow.getCell(0).getStringCellValue().trim(), testDataDetails);
			}
			testDataBook.close();
			testDataStream.close();
		} catch (IOException e) {
			throw new NullPointerException("Error in reading spreadsheet");
		}
	}
	

//new dataloader working with mapping sheet
@DataProvider(name = "dataLoader_new_one")
public Object[][] testDataProvider(Method testMethod) {
	prepareTestDataMapping();
	// startExtentTest(testMethod.getDeclaringClass().getSimpleName());
	System.out.println("Starting Test : " + testMethod.getDeclaringClass().getName());
	//logger.info("Starting Test : " + testMethod.getDeclaringClass().getName());
	String testClass = testMethod.getDeclaringClass().getSimpleName();
	String elementName = null ;
	List<List<Object>> testDataSetList = new ArrayList<>();

	XSSFWorkbook testDataBook = null;
	FileInputStream testDataStream = null;
	try {
		String testDataFilePath = null;
		HashMap<String, String> testDataFileDetails = testDataMapping.get(testClass);
		try {
		//testDataFilePath = TESTDATADIR + "/" + testDataFileDetails.get("DataFile");
		testDataFilePath = 	"C:\\Users\\29265\\Desktop\\ITH_Test_Data.xlsx";
			if (!testDataFilePath.endsWith(".xlsx")) {
				testDataFilePath += ".xlsx";
			}
			
		} catch (NullPointerException e) {
			throw new NullPointerException("Test File/Sheet Name is not specified for class " + testClass);
		}

		File testDataFile = new File(testDataFilePath);
		testDataStream = new FileInputStream(testDataFile);
		testDataBook = new XSSFWorkbook(testDataStream);
		XSSFSheet testDataSheet = testDataBook.getSheet(testDataFileDetails.get("DataSheet"));
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

			if (testDataFlag != null && testDataFlag.trim().startsWith("Y")) {
				List<Object> testDataSet = new ArrayList<>();

				for (int rowCounter = 2; rowCounter <= numberOfDataElement; rowCounter++) {
					try {
						if (testDataSheet.getRow(rowCounter) != null
								&& testDataSheet.getRow(rowCounter).getCell(1) != null) {
							String testData;
						try {
							 elementName = testDataSheet.getRow(rowCounter).getCell(1).getStringCellValue();
							
						}	catch (Exception e) {
							 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(1).getNumericCellValue();
							 elementName=String.valueOf(noofpass);
						}
							
							if (elementName != null && elementName.trim().length() > 0) {
								try {
									testData = testDataSheet.getRow(rowCounter).getCell(columnCounter)
											.getStringCellValue();
								} catch (Exception e) {
									//testData = "";
									 int noofpass = (int) testDataSheet.getRow(rowCounter).getCell(columnCounter).getNumericCellValue();
									 testData=String.valueOf(noofpass);
									
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
		//logger.warn("Error in reading spreadsheet");
		System.err.println("Error in reading spreadsheet");
	} catch (NullPointerException e) {
		if (e.getLocalizedMessage() != null) {
			//logger.warn(e.getLocalizedMessage());
			System.err.println(e.getLocalizedMessage());
		}
	//	logger.warn("TestData issue. Check test data file/sheet mapping");
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
			//logger.warn("Issue with workbook/datastream close");
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

}


