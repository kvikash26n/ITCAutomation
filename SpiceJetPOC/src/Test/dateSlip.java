package Test;

import java.util.Calendar;
import java.util.Date;

public class dateSlip {

	//Mon Jun 04 00:00:00 IST 2018
	public static void main(String[] args)
	  {
	    // create a calendar instance, and get the date from that
	    // instance; it defaults to "today", or more accurately,
	    // "now".
	    Date today = Calendar.getInstance().getTime();
	    
	    // print out today's date
	    System.out.println(today);
	    String dd=today.toString();
	    dateSlip d=new dateSlip();
	  System.out.println(d.splitDate(dd));
	  
	  }

String splitDate(String date)
{
	 String[] aString=date.toString().split(" ");
	    
		//System.out.println(aString[3]);
		String finaldate=date.toString().replaceAll(aString[3], "");
		//System.out.println(finaldate);
		return finaldate;
}
}
