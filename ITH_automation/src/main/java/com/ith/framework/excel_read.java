/**
 * 
 */
package com.ith.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author 29265
 *
 */
public class excel_read {
	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\29265\\Desktop\\ITH_Test_Data.xlsx";
	static Workbook workbook;
	 
	public static Object[][] getData(String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException{
		workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
	//	FileInputStream file=null;
		Sheet sheet=workbook.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];
		for(int i=2;i<sheet.getLastRowNum()+1;i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				
				data[i][k]=sheet.getRow(i).getCell(k).toString();
				
			}
			
		}
		//file.close();
		workbook.close();
		
		return data;
		
	}
	
	

}
