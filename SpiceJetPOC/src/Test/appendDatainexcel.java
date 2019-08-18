/**
 * 
 */
package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author 29265
 *
 */
public class appendDatainexcel {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
	     Object a[][]= {{"The Passionate Programmer", "Chad Fowler", 16}};
	    Object  b[][]= {{"The Passionate Programmer", "Chad Fowler", 16}};
	     appendDatainexcel ob=new appendDatainexcel();
	     ob.write(a);
	    }



void write(Object[][] bookData)
{
	  String excelFilePath = "C:\\Users\\29265\\Desktop\\Bayer_Automation_DataInput.xlsx";
      
      try {
          FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
          Workbook workbook = WorkbookFactory.create(inputStream);

          Sheet sheet = workbook.getSheet("demo");

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

          FileOutputStream outputStream = new FileOutputStream(excelFilePath);
          workbook.write(outputStream);
          workbook.close();
          outputStream.close();
           
      } catch (IOException | EncryptedDocumentException
              | InvalidFormatException ex) {
          ex.printStackTrace();
      }
}
}