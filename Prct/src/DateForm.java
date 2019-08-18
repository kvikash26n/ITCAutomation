import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		   	Date dateobj = new Date();
		   	String reportDate = df.format(dateobj);
		   	System.out.println("Report Date: " + reportDate);
		   	//to split current date n store in varible
		   	String datePartscurrent[] = reportDate.split("/");
		   	String monthcurrent  = datePartscurrent[0];
			String daycurrent  = datePartscurrent[1];
			String yearcurrent = datePartscurrent[2];
			System.out.println(monthcurrent+" "+daycurrent+" " +yearcurrent);
			int i=Integer.parseInt(monthcurrent);
			int k=Integer.parseInt(daycurrent);
			int l=Integer.parseInt(yearcurrent);
		String 	Departdate="12/07/2018";
			
			/*String dateParts[] = Departdate.split("");
			System.out.println(dateParts[0]);
			String a1=dateParts[0];
			String b1=dateParts[1];
			String c1=dateParts[2];
			String d1=dateParts[3];
			String e1=dateParts[4];
			String f1=dateParts[5];
			String g1=dateParts[6];
			String h1=dateParts[7];
			String i1=dateParts[8];
			String j1=dateParts[9];
			String abvc="/";
		//	String dt12=a1+b1+c1+d1+e1+f1+g1+h1+i1+j1;
			String dt=c1+d1+abvc+a1+b1+abvc+e1+f1+g1+h1;
			System.out.println(dt);  */    
	      
	       
			String dateParts1[] = Departdate.split("/");
			String uday  = dateParts1[0];
			String umonth  = dateParts1[1];
			String uyear = dateParts1[2];
			System.out.println(umonth+" "+uday+" " +uyear);
			//to convert string to integer
			int a=Integer.parseInt(umonth);
			int b=Integer.parseInt(uday);
			
			int monthdiff=a-i;
			System.out.println("diff:"+" "+monthdiff);
			//click opration will go for -1
			String[] myStringArray1 = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			String text=myStringArray1[a-1];
	System.out.println(text);
			//*[text()='text']//ancestor::div//a[text()='b']
			
	}

}
