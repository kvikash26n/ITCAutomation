package frameworkform;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.pattern.LiteralPatternConverter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//C:\\Users\\29265\\Desktop\\SpicjetTestdataPNR.xlsx
public class excelread {


	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\29265\\Desktop\\SpicjetTestdataPNR.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
    	List date=new ArrayList();
    	List addval=new ArrayList();
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        

        // Getting the Sheet at index zero
        //Sheet sheet = workbook.getSheetAt(2);
        //Sheet   sheet = workbook.getSheetAt(0);
        Sheet sheet=workbook.getSheet("Sheet2");
      //  Sheet sheet  = workBook.getSheetAt(0); // Get Your Sheet.

        for (Row row : sheet) { // For each Row.
            Cell cell = row.getCell(1); // Get the Cell at the Index / Column you want.
            //System.out.println(cell);
            addval.add(cell);
        }
        DataFormatter dataFormatter = new DataFormatter();
System.out.println(addval);
for (Row row: sheet) {
    for(Cell cell: row) {
        String cellValue = dataFormatter.formatCellValue(cell);
        System.out.print(cellValue + "\t");
    }
    System.out.println();
}
        // Create a DataFormatter to format and get each cell's value as String
      /*  DataFormatter dataFormatter = new DataFormatter();

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
                date.add(cellValue);
               // System.out.print(cellValue + "\t");
            }
            
        }
        System.out.println(date);
*/
}
}