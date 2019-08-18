import java.security.SecureRandom;

public class Random {

	public static String randonNumber(int n) {


final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
SecureRandom rnd = new SecureRandom();

   StringBuilder sb = new StringBuilder(n);
   for( int i = 0; i < n; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
   return sb.toString();
  
}
public static String main(int i)
{
	String aString=main(4);
	System.out.println(aString);
	return aString;
}

	}


