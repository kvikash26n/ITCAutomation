package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import utility.util;

public class WriteRefundedAmout {

	public static <E> void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String excelFilePath = "C:\\Users\\29265\\Desktop\\PNRRecord.xlsx";
		 
		    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
           Workbook workbook = WorkbookFactory.create(inputStream);
List addval=new ArrayList();
List dateval=new ArrayList();
           Sheet sheet = workbook.getSheet("11_05_2018JD");
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
          Row row = sheet.createRow(1);
           Cell cell = null;
            cell = row.createCell(10);
           //Update the value of cell
           cell = sheet.getRow(1).getCell(10);
           cell.setCellValue("12000");

           inputStream.close();

           FileOutputStream outFile =new FileOutputStream(new File(excelFilePath));
           workbook.write(outFile);
           outFile.close();

       } 

           
           
	}

