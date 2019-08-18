package com.bot;
/**
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



/**
 * @author 29265
 *
 */
public class APIResponce {

	/**
	 * @param args
	 */
	static util util;
	static String path = "C:\\Users\\29265\\Desktop\\api_response.xlsx";
	public static HashMap<String, String> initializeResponce() throws InvalidFormatException, IOException {
		
		List Code =util.GetColumnValue(0, "codeValue", path);
		List codemodify= new ArrayList();
		
		for(int k=0;k<Code.size();k++) {
			String aString=(String) Code.get(k);
			aString=aString.replace(".0", "");
			
			codemodify.add(aString);
		}
		System.out.println(codemodify);
	
		List value =util.GetColumnValue(1, "codeValue", path);
	
		 HashMap<String,String> hm=new HashMap<String,String>();
		for(int j=0;j<Code.size();j++) {
			  
		
			  hm.put(codemodify.get(j).toString(),value.get(j).toString());
			  
		}
	//System.out.println("Vikash Resp:"+hm.get("200"));	
		;
		
		/*for(Map.Entry m:hm.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  	
	}*/
		//System.out.println(m.getKey()+" "+m.getValue()); 
		return hm;
}
	public static String getCodeValue(int code) throws InvalidFormatException, IOException {
		HashMap<String, String>hMap=initializeResponce();
		int codeinput=code;
		String cString=String.valueOf(codeinput);
		System.out.println("Resp:"+hMap.get(cString));	
		return hMap.get(cString);
		
	}
	public static void main(String ag[]) throws InvalidFormatException, IOException
	{
		getCodeValue(400);	
	}
}