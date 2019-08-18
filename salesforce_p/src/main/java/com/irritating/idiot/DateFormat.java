/**
 * 
 */
package com.irritating.idiot;

import java.text.SimpleDateFormat;
import java.util.Date;


		// TODO Auto-generated method stub
		import java.text.SimpleDateFormat;
		import java.util.Date;
		public class DateFormat {
		  public static void main(String[] args) {
		   String datePattern = "dd-MMM-yy";
		    //String datePattern = "MMM dd, yy";
		   // String datePattern = "MM-dd-yyyy";
		    Date today;
		    String dateOutput;
		    SimpleDateFormat simpleDateFormat;
		    simpleDateFormat = new SimpleDateFormat(datePattern);
		    today = new Date("Jul 15, 18");
		    dateOutput = simpleDateFormat.format(today);
		    System.out.println(datePattern + " - " + dateOutput);	
	}

}
//Jul 15, 18
