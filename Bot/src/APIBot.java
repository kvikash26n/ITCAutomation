import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class APIBot {
	static WebDriver driver;
	public static void main(String args[]) throws Exception {
		 System.setProperty("webdriver.chrome.driver",
                 "D:\\chromedriver.exe");
         ChromeOptions options = new ChromeOptions();
         options.addArguments("headless");
         options.addArguments("window-size=1200x600");
        driver = new ChromeDriver(options);
	
 
		
		  
          // To oepn URL "http://softwaretestingmaterial.com"
   driver.get("https://www.myseus.schneider-electric.com/mysedv/login.do");
   driver.manage().window().maximize();
   Thread.sleep(2000);
 
   List<WebElement> abc = driver.findElements(By.xpath("//a[@href]"));
   
   List alllink=new ArrayList();
   
   for(int i=1;i<abc.size();i++) {
	   String aString="(//a[@href])[";
	   String bString="]";
	   //aString+i+bString
	   alllink.add(driver.findElement(By.xpath(aString+i+bString)).getAttribute("href"));
	   //alllink.add((aString+i+bString).get(i));
   }
   System.out.println("total url count is="+alllink.size());
	for (int i = 0; i < alllink.size(); i++) {
		String url = (String) alllink.get(i);
		//String url = hostList[i];
		getStatus(url);

	}
		System.out.println("Task completed...");
	}
	//////////

	public static String getStatus(String url) throws IOException {
		 
		String result = "";
		int code = 200;
		try {
			String url1="https://www.schneider-electric.us/";
			URL siteURL = new URL(url1);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			//connection.setConnectTimeout(6000);
			
		      connection.connect();
		      connection.setReadTimeout(15*1000);
			//connection.connect();
 
			code = connection.getResponseCode();
			if (code == 200) {
				//result = "-> Green <-\t" + "Code: " + code;
				result="Passed"
				;
			} else {
				//result = "-> Yellow <-\t" + "Code: " + code;
				result="Moved Permanently";
				//System.out.println(url + "\t\tStatus:" + result);
			}
		} catch (Exception e) {
			result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
 
		}
		System.out.println(url + "\t\tStatus:" + result);
		
		return result;
	}
	
	
	
}

//input[@type='text']
//input[@type='submit']
//button[@type='submit']
//*[contains(text(),'Email')]
