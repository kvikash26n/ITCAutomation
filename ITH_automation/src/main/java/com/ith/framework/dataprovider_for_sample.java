/**
 * 
 */
package com.ith.framework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

/**
 * @author 29265
 *
 */
public class dataprovider_for_sample {
	@DataProvider(name="sample")
	public Object[][] getDatafromexcel() throws EncryptedDocumentException, InvalidFormatException, IOException{
		excel_read excel_read=new excel_read();
		Object data[][]=excel_read.getData("Sheet2");
		return data;
		
	}
	

}
