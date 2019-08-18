package Test;

import java.io.File
;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utility.util;

public class TestControlAgent {
	public static final String DATA_XLSX_FILE_PATH ="C:\\Users\\29265\\Desktop\\SpicjetTestdataPNR.xlsx";
	public static final String DATA_XLSX_FILE_PATH_PNR="C:\\Users\\29265\\Desktop\\PNRCancel.xlsx";
	public static final String DATA_XLSX_FILE_PATH_PNRRecord="C:\\Users\\29265\\Desktop\\PNRRecord.xlsx";

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
	@AfterClass(alwaysRun = true)
	public void endTest() {
		//driver.quit();
		extent.endTest(test);
		extent.flush();
	}
	ArrayList getPassengerNameDetails() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	List nameinfo=new ArrayList();
    	
        Workbook workbook = WorkbookFactory.create(new File(DATA_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        

        // Getting the Sheet at index zero
        //Sheet sheet = workbook.getSheetAt(2);
        Sheet   sheet = workbook.getSheet("MOBILEAPP");

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
       // for() {
        while (rowIterator.hasNext()) {
            Row row =rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                if (cellValue!="") {
                	nameinfo.add(cellValue);	
				}
                
               // System.out.print(cellValue + "\t");
            }
            
        }
        
        System.out.println(nameinfo);
		return (ArrayList) nameinfo;

}
		
	
	static
	{
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir") + "\\src\\report" + formater.format(calendar.getTime()) + ".html" , false);
	}
	/*public String getScreenshot(String imageName) throws IOException
	{
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation=System.getProperty("user.dir")+"\\src\\screenshot\\";
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName=imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile=new File(actualImageName);
		FileUtils.copyFile(image,destFile);
		return actualImageName;
		
	}*/
	/*public String getScreenshot(String imageName) throws IOException
	{
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation=System.getProperty("user.dir")+"\\src\\main\\java\\screenshot";
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName=imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile=new File(actualImageName);
		FileUtils.copyFile(image,destFile);
		return actualImageName;
		
	}*/
	
	@DataProvider(name = "dataLoader")
	public Object[][] testDataProvider(Method testMethod) {
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
	
	
    public static ArrayList getDate(String FlightNo) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
    	List date=new ArrayList();
    	
        Workbook workbook = WorkbookFactory.create(new File(DATA_XLSX_FILE_PATH_PNRRecord));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        

        // Getting the Sheet at index zero
        //Sheet sheet = workbook.getSheetAt(2);
        Sheet   sheet = workbook.getSheet(FlightNo);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                if (cellValue!="") {
                	date.add(cellValue);	
				}
                
               // System.out.print(cellValue + "\t");
            }
            
        }
        System.out.println(date);
		return (ArrayList) date;

}
    /*@AfterSuite
    void pnrgenerate()
    {
    	
    	util.PrintPnr(FilePath, pnrdata);
    }*/
    
	@DataProvider(name = "dataLoaderpnr")
	public Object[][] testDataProviderpnr(Method testMethod) {
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
				testDataFilePath = DATA_XLSX_FILE_PATH_PNR;
				if (!testDataFilePath.endsWith(".xlsx")) {
					testDataFilePath += ".xlsx";
				}
				
			} catch (NullPointerException e) {
				throw new NullPointerException("Test File/Sheet Name is not specified for class " + testClass);
			}

			File testDataFile = new File(testDataFilePath);
			testDataStream = new FileInputStream(testDataFile);
			testDataBook = new XSSFWorkbook(testDataStream);
			XSSFSheet testDataSheet = testDataBook.getSheet("PNR");
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

}
