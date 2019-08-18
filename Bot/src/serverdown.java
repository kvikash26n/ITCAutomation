import java.io.IOException;
import java.net.InetAddress;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class serverdown {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*boolean isAlive = true;
		try {
		  URL hp = new URL("https://www.youtube.com/"); 
		  URLConnection hpCon = hp.openConnection(); 
		  System.out.println(hpCon);
		  // add more checks...
		} catch (Exception e) {
		  isAlive = false;
		}*/
		
		Runtime runtime = Runtime.getRuntime();
		Process proc = runtime.exec("http://www.spicejet.com/"); //<- Try ping -c 1 www.serverURL.com
		int mPingResult = proc .waitFor();
		if(mPingResult == 0){
		    //return true;
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}


