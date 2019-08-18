package com.bot;

import java.io.BufferedWriter
;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */

/**
 * @author 29265
 *
 */
public class util extends APIResponce{
	//public static WebDriver driver;
	 public static List<Integer>passcoutnlist;
	
/*	 public static String getStatus(String url) throws IOException, EncryptedDocumentException, InvalidFormatException {

			String result = "";
			int code = 0;
			try {
				URL siteURL = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(3000);
				connection.connect();

				code = connection.getResponseCode();

				if (code == 200) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				}

				else if (code == 202) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				}

				else if (code == 201) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				}

				else if (code == 203) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				} else if (code == 204) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				} else if (code == 205) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				} else if (code == 206) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				} else if (code == 207) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				} else if (code == 208) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				} else if (code == 226) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Passed";

				} else if (String.valueOf(code).contains("3")) {
					// result = "-> Green <-\t" + "Code: " + code;
					result = "Warning";

				}

				
				 * else { // result = "-> Yellow <-\t" + "Code: " + code; result =
				 * "Moved Permanently";
				 * 
				 * }
				 

			} catch (Exception e) {
				result = "Wrong domain - Exception: " + e.getMessage();

			}
			
			//919810281813 mausi
			
			System.out.println(url + "\t\tStatus:" + result);
			if (result.contains("Wrong domain - Exception: ")) {
				Object[][] pnrdetails = { { url,  "Failed","NA" } };
				util.AppendPnr(pnrdetails, path, "report");
			} else {
			String responce=	getCodeValue(code);	
				Object[][] pnrdetails = { { url,  result,code ,responce} };
				util.AppendPnr(pnrdetails, path, "report");
			}

			return result;
		}*/
	 

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	public static String ExtractDayFromDate(String ab) {
		// TODO Auto-generated method stub
		 Date now = new Date(ab);
		 
	       SimpleDateFormat simpleDateformat = new SimpleDateFormat(""); // the day of the week abbreviated
	      //  System.out.println(simpleDateformat.format(now));
	 
	        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
	        String day=simpleDateformat.format(now);
	      //  System.out.println(day);
			return day;
	}

	
	
	
/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	public static int generateRandomNoInList(int no_of_max_pax) {
		Random random = new Random();
		int no;
		passcoutnlist = new ArrayList<Integer>();
		///
		for (int c = 1; c <= 6; c++) {
			no = random.nextInt(5) + 1;

			passcoutnlist.add(no);

		}
		// System.out.println(a);
		int sum = 0;

		for (int i : passcoutnlist) {
			sum += i;
		}
		return sum;
	}

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	public static Date CancelDateNeedtoConvert(String dateofcancel) throws ParseException {
		// TODO Auto-generated method stub
		String string = dateofcancel;
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(string);
		System.out.println(date);
		return date;
	}


	public static Date getCancelDate(String ab) throws ParseException
	{

		// TODO Auto-generated method stub
		String mar;
		
		  Random rand=new Random();
		  int randomNum = rand.nextInt((8 - 4) + 1) + 4;
		
		
	System.out.println(randomNum);
	//random.nextInt(4,7);
	String aString=ab;
	String [] AB=aString.split("/");
	String a=AB[0];
	String b=AB[1];
	String c=AB[2];
	aString=c+"-"+a+"-"+b;
	System.out.println(aString);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  String strDate = aString;
  Date date = sdf.parse(strDate);
  Calendar calendar = Calendar.getInstance();
  calendar.setTime(date);
  calendar.add(Calendar.DATE, -randomNum);
  Date yesterday = calendar.getTime();

  System.out.println(yesterday);//Sat Jun 23 00:00:00 IST 2018
  System.out.println(date);
  return yesterday;
	}
	
	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\29265\\Desktop\\SpicjetTestdataPNR.xlsx";
	public static final String SAMPLE_XLSX_FILE_PATHpnr = "C:\\Users\\29265\\Desktop\\PNRRecord.xlsx";

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
    public static ArrayList GetColumnValue(int colno,String Sheetname,String path) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
    	//List date=new ArrayList();
    	List  addval=new ArrayList();
     //   Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
    	Workbook workbook = WorkbookFactory.create(new File(path));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        

        // Getting the Sheet at index zero
        //Sheet sheet = workbook.getSheetAt(2);
        Sheet   sheet = workbook.getSheet(Sheetname);
      //  Sheet sheet  = workBook.getSheetAt(0); // Get Your Sheet.

        for (Row row : sheet) { // For each Row.
            Cell cell = row.getCell(colno); // Get the Cell at the Index / Column you want.
           // System.out.println(cell)
            
            if(cell.toString().endsWith("PNR")||cell.toString().equals("Passenger Name")|| cell.toString().equals("Title")|| cell.toString().equals("FirstName")||cell.toString().equals("LastName")||cell.toString().equals("")||cell.toString().equals("Date")||cell.toString().equals(null))
            {	
            
        }else {
        	addval.add(cell.toString());
		}
        }
        
System.out.println(addval);
return  (ArrayList) addval;
    }

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
    public static ArrayList GetColumndateValue(int colno,String Sheetname) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
    	//List date=new ArrayList();
    	List  addval=new ArrayList();
     //   Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
    	Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATHpnr));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        

        // Getting the Sheet at index zero
        //Sheet sheet = workbook.getSheetAt(2);
        Sheet   sheet = workbook.getSheet(Sheetname);
      //  Sheet sheet  = workBook.getSheetAt(0); // Get Your Sheet.

        for (Row row : sheet) { // For each Row.
            Cell cell = row.getCell(colno); // Get the Cell at the Index / Column you want.
           // System.out.println(cell);
            try {
     String  abcd=   cell.getStringCellValue();
     addval.add(abcd);
      
            }
            catch (Exception e) {
				// TODO: handle exception
            	
           
           Date ab= 	cell.getDateCellValue();
           addval.add(ab);
			}
           /* if(cell.toString().equals("Passenger Name")|| cell.toString().equals("Title")|| cell.toString().equals("FirstName")||cell.toString().equals("LastName")||cell.toString().equals("")||cell.toString().equals("Date")||cell.toString().equals(null))
            {	
            
        }else {
        	addval.add(cell.toString());
		}*/
        }
        addval.remove(0);
System.out.println(addval);
return  (ArrayList) addval;
    }
    public static    String splitDate(String date)
    {
    	 String[] aString=date.toString().split(" ");
    	    
    		//System.out.println(aString[3]);
    		String finaldate=date.toString().replaceAll(aString[3], "");
    		//System.out.println(finaldate);
    		return finaldate;
    }
	public static int price(String price)
	{
	 String price1=price;
	  price1 = price1.indexOf(".") < 0 ? price1 : price1.replaceAll("0*$", "").replaceAll("\\.$", "");
	  // float price1_1 = Float.parseFloat(price1);
	   String newStr = price1.replaceAll(",", "");
	   int price1_1 = Integer.parseInt(newStr);	
	  
	   return price1_1;
	}
	public static String randonString(int n) {


		final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		SecureRandom rnd = new SecureRandom();

		   StringBuilder sb = new StringBuilder(n);
		   for( int i = 0; i < n; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		  
		}
	public static String randonNumber(int n) {


		final String AB = "1234567890";
		SecureRandom rnd = new SecureRandom();

		   StringBuilder sb = new StringBuilder(n);
		   for( int i = 0; i < n; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		  
		}

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	public static void printTextWithExisting(String pnr)
	{
		try
		{
		    String filename= "C:\\Users\\29265\\Desktop\\pnr.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(pnr+"\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	 public static void PrintText(String pnr, String amount) {
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
          
            File logFile = new File("PNR_"+pnr+"_"+timeLog);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(pnr);
            writer.write(amount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
	 //PNR_CancelRecord

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	 public static void  PrintPnrCancel(Map<String, Object[]> pnrdata) throws EncryptedDocumentException, InvalidFormatException, IOException {
			// TODO Auto-generated method stub
			 String excelFilePath = "C:\\Users\\29265\\Desktop\\PNR_CancelledRecord.xlsx";
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				System.out.println(dtf.format(localDate)); //2016/11/16
			    String da=dtf.format(localDate);
			    String datePartscurrent[] = da.split("/");
				String yearcurrent = datePartscurrent[0];
				String monthcurrent = datePartscurrent[1];
				String daycurrent = datePartscurrent[2];
			    String finalsheetname=daycurrent+"_"+monthcurrent+"_"+yearcurrent;
			    finalsheetname=finalsheetname+util.randonString(2);
			        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			        Workbook workbook = WorkbookFactory.create(inputStream);

			        Sheet newSheet = workbook.createSheet(finalsheetname);
			
			
			
			// XSSFWorkbook workbook = new XSSFWorkbook(); 
	         
		        //Create a blank sheet
		    //    XSSFSheet sheet = workbook.createSheet("Employee Data");
		          
		        //This data needs to be written (Object[])
			       // pnrdata = new TreeMap<String, Object[]>();
			     //   pnrdata.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
		      //  data.put("2", new Object[] {1, "Amit", "Shukla"});
		      //  data.put("3", new Object[] {2, "Lokesh", "Gupta"});
		      //  data.put("4", new Object[] {3, "John", "Adwards"});
		      //  data.put("5", new Object[] {4, "Brian", "Schultz"});
		          
		        //Iterate over data and write to sheet
		        Set<String> keyset = pnrdata.keySet();
		        int rownum = 0;
		        for (String key : keyset)
		        {
		            Row row = newSheet.createRow(rownum++);
		            Object [] objArr = pnrdata.get(key);
		            int cellnum = 0;
		            for (Object obj : objArr)
		            {
		               Cell cell = row.createCell(cellnum++);
		               if(obj instanceof String)
		                    cell.setCellValue((String)obj);
		                else if(obj instanceof Integer)
		                    cell.setCellValue((Integer)obj);
		            }
		        }
		        try
		        {
		            //Write the workbook in file system
		            FileOutputStream out = new FileOutputStream(new File(excelFilePath));
		            workbook.write(out);
		            out.close();
		            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
				
		    }

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	 
	 public static void  PrintPnr(Map<String, Object[]> pnrdata) throws EncryptedDocumentException, InvalidFormatException, IOException {
			// TODO Auto-generated method stub
			 String excelFilePath = "C:\\Users\\29265\\Desktop\\PNRRecord.xlsx";
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				System.out.println(dtf.format(localDate)); //2016/11/16
			    String da=dtf.format(localDate);
			    String datePartscurrent[] = da.split("/");
				String yearcurrent = datePartscurrent[0];
				String monthcurrent = datePartscurrent[1];
				String daycurrent = datePartscurrent[2];
			    String finalsheetname=daycurrent+"_"+monthcurrent+"_"+yearcurrent;
			    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	            Workbook workbook = WorkbookFactory.create(inputStream);
	 
	            Sheet sheet = workbook.getSheet("PNRRecord");
			
			
			
			// XSSFWorkbook workbook = new XSSFWorkbook(); 
	         
		        //Create a blank sheet
		    //    XSSFSheet sheet = workbook.createSheet("Employee Data");
		          
		        //This data needs to be written (Object[])
			       // pnrdata = new TreeMap<String, Object[]>();
		      //  data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
		      //  data.put("2", new Object[] {1, "Amit", "Shukla"});
		      //  data.put("3", new Object[] {2, "Lokesh", "Gupta"});
		      //  data.put("4", new Object[] {3, "John", "Adwards"});
		      //  data.put("5", new Object[] {4, "Brian", "Schultz"});
		          
		        //Iterate over data and write to sheet
		        Set<String> keyset = pnrdata.keySet();
		        int rownum = 0;
		        for (String key : keyset)
		        {
		            Row row = sheet.createRow(rownum++);
		            Object [] objArr = pnrdata.get(key);
		            int cellnum = 0;
		            for (Object obj : objArr)
		            {
		               Cell cell = row.createCell(cellnum++);
		               if(obj instanceof String)
		                    cell.setCellValue((String)obj);
		                else if(obj instanceof Integer)
		                    cell.setCellValue((Integer)obj);
		            }
		        }
		        try
		        {
		            //Write the workbook in file system
		            FileOutputStream out = new FileOutputStream(new File(excelFilePath));
		            workbook.write(out);
		            out.close();
		            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
				
		    }

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 * @throws InvalidFormatException 
 * @throws EncryptedDocumentException 
 *
 */
	 public static void AppendPnrDetials(String excelFilePath) throws EncryptedDocumentException, InvalidFormatException {
	       // excelFilePath = "JavaBooks.xls";
	         
	        try {
	            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	            Workbook workbook = WorkbookFactory.create(inputStream);
	 
	            Sheet sheet = workbook.getSheetAt(0);
	 
	            Object[][] bookData = {
	                    {"The Passionate Programmer", "Chad Fowler", 16},
	                    {"Software Craftmanship", "Pete McBreen", 26},
	                    {"The Art of Agile Development", "James Shore", 32},
	                    {"Continuous Delivery", "Jez Humble", 41},
	            };
	 
	            int rowCount = sheet.getLastRowNum();
	 
	            for (Object[] aBook : bookData) {
	                Row row = sheet.createRow(++rowCount);
	 
	                int columnCount = 0;
	                 
	                Cell cell = row.createCell(columnCount);
	                cell.setCellValue(rowCount);
	                 
	                for (Object field : aBook) {
	                    cell = row.createCell(++columnCount);
	                    if (field instanceof String) {
	                        cell.setCellValue((String) field);
	                    } else if (field instanceof Integer) {
	                        cell.setCellValue((Integer) field);
	                    }
	                }
	 
	            }
	 
	            inputStream.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("JavaBooks.xls");
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	             
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

/**
 * @author 
 * Kumar Vikash
 * Spicejet
 *
 */
	 public static  void ToWriteRefundedAmount(int ro,int co,String amount) throws EncryptedDocumentException, InvalidFormatException, IOException {
			String excelFilePath = "C:\\Users\\29265\\Desktop\\PNRRecord.xlsx";
			 
			    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	           Workbook workbook = WorkbookFactory.create(inputStream);
	List addval=new ArrayList();
	List dateval=new ArrayList();
	           Sheet sheet = workbook.getSheet("PNRRecord");
	//from below code will get pnr
	    //   addval=   util.GetColumnValue(4, "11_05_2018JD");
	//from below code 
	      // dateval=util.GetColumnValue(9, "11_05_2018JD");
	      // System.out.println(addval);
	     //  addval.remove(0);
	    //   dateval.remove(0);
	    //   System.out.println(addval);
	     //  System.out.println(dateval);
	       
	    /*   for(int i =0;i<addval.size();i++)
	       {
	    	  int ra=  
	       }*/
	           //get cell value Amit 1,9
	          Row row = sheet.createRow(ro);
	           Cell cell = null;
	            cell = row.createCell(10);
	           //Update the value of cell
	           cell = sheet.getRow(1).getCell(co);
	           cell.setCellValue(amount);

	           inputStream.close();

	           FileOutputStream outFile =new FileOutputStream(new File(excelFilePath));
	           workbook.write(outFile);
	           outFile.close();

	       }
	 
	 
public static	 void AppendPnr(Object[][] bookData,String path,String sheetn) throws EncryptedDocumentException, InvalidFormatException
	 {
	 	 // String excelFilePath = SAMPLE_XLSX_FILE_PATHpnr;
	       
	       try {
	           FileInputStream inputStream = new FileInputStream(new File(path));
	           Workbook workbook = WorkbookFactory.create(inputStream);

	           Sheet sheet = workbook.getSheet(sheetn);

	         /*  Object[][] bookData = {
	                   {"The Passionate Programmer", "Chad Fowler", 16},
	                   {"Software Craftmanship", "Pete McBreen", 26},
	                   {"The Art of Agile Development", "James Shore", 32},
	                   {"Continuous Delivery", "Jez Humble", 43},
	           };*/
	           int rowCount = sheet.getLastRowNum();

	           for (Object[] aBook : bookData) {
	               Row row = sheet.createRow(++rowCount);

	               int columnCount = 0;
	                
	               Cell cell = row.createCell(columnCount);
	             //  cell.setCellValue(rowCount);
	                
	               for (Object field : aBook) {
	                   cell = row.createCell(++columnCount);
	                   if (field instanceof String) {
	                       cell.setCellValue((String) field);
	                   } else if (field instanceof Integer) {
	                       cell.setCellValue((Integer) field);
	                   }
	               }

	           }

	           inputStream.close();

	           FileOutputStream outputStream = new FileOutputStream(path);
	           workbook.write(outputStream);
	           workbook.close();
	           outputStream.close();
	            
	       } catch (IOException ex) {
	           ex.printStackTrace();
	       }
	 }
	 
}

