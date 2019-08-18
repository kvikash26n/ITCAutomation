package frameworkform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class dayfromdate {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String mar;
	
			  Random rand=new Random();
			  int randomNum = rand.nextInt((7 - 4) + 1) + 4;
			
			
		System.out.println(randomNum);
		//random.nextInt(4,7);
		String aString="6/29/2018";
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
		
        
        
        
	
	}

}
