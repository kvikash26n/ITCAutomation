import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * 
 */

/**
 * @author 29265
 *
 */
public class CSSLOca {

	/**
	 * @param args
	 */
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	driver.findElement(By.cssSelector
		
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
         //D:\chromedriver_win32
         // In	stantiation of driver object. To launch Firefox browser
  // driver = new FirefoxDriver();
   driver=new ChromeDriver();
         // To oepn URL "http://softwaretestingmaterial.com"
  driver.get("https://www.google.com/");
  /*1. '^' symbol, represents the starting text in a string.
  2. '$' symbol represents the ending text in a string.
  3. '*' symbol represents contains text in a string.*/
  //css=input[id^='ema'] 
  
  //input[type=text][title*=Search] ---->flipcart
  //input[type=text][id*='input'] ------>snapdeal
  // driver.findElement(By.xpath("")).sendKeys("abc");
  //**********Approach**************
 // We have to itrate All attribute With diffrent diffrent value Then we Can find The locator 
  //*********************************************
  driver.findElement(By.cssSelector("input[type=text]")).sendKeys("abc");
	}

}
