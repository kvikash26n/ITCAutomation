package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import utility.util;

public class writedatainmap {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		 String excelFilePath = "C:\\Users\\29265\\Desktop\\Bayer_Automation_DataInput.xlsx";
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
 
            Sheet sheet = workbook.getSheet("Sheet1");
		
		
		// XSSFWorkbook workbook = new XSSFWorkbook(); 
         
	        //Create a blank sheet
	    //    XSSFSheet sheet = workbook.createSheet("Employee Data");
	          
	        //This data needs to be written (Object[])
	        Map<String, Object[]> data = new TreeMap<String, Object[]>();
	        data.put("pnr", new Object[] {"ID", "NAME", "LASTNAME"});
	        data.put("A", new Object[] {1, "Amit", "Shukla"});
	        data.put("B", new Object[] {2, "Lokesh", "Gupta"});
	        data.put("a", new Object[] {3, "John", "Adwards"});
	        data.put("e", new Object[] {10, "Brian", "Schultz"});
	        data.put("y", new Object[] {11, "Brian", "Schultz"});
	          
	        //Iterate over data and write to sheet
	        Set<String> keyset = data.keySet();
	        int rownum = 0;
	        for (String key : keyset)
	        {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = data.get(key);
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
	}

