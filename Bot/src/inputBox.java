import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class inputBox {

	/**
	 * @param args
	 */
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
         //D:\chromedriver_win32
         // In	stantiation of driver object. To launch Firefox browser
  // driver = new FirefoxDriver();
   driver=new ChromeDriver();
         // To oepn URL "http://softwaretestingmaterial.com"
  driver.get("https://www.spicejet.com/");
  //https://www.snapdeal.com/
  //https://www.flipkart.com/
  //https://www.amazon.in/
  https://www.google.com/
  driver.manage().window().maximize();
  Thread.sleep(2000);
  List list=new ArrayList();
  
  list.add("//input[@type='text']");
  list.add("//input[@type='submit']");
  list.add("//button[@type='submit']");
  list.add("//*[contains(text(),'Email')]");
  list.add("//input[contains(@id,'input')]");
  list.add("//input[@type='text']");
 //tag----> input, button,
  //attribute------> type,text,id
  //Val ----------> text,search,submit,Email,input
  //need to form xpath using tag & attribute
  
  for(int i=0;i<list.size();i++) {
	 // driver.findElement(By.xpath("")).isDisplayed();
	/* if(driver.findElement(By.xpath("//*[text()='x']")).isDisplayed()) {
		 driver.findElement(By.xpath("//*[text()='x']")).click();
	 }
	*/ 
	  Actions action = new Actions(driver);
	  action.sendKeys(Keys.ESCAPE).perform();
	  try {
	  if( driver.findElement(By.xpath((String) list.get(i))).isDisplayed()) {
		  driver.findElement(By.xpath((String) list.get(i))).sendKeys("abc");
		  
		  break;
	  }
  }
  
  catch (Exception exception) {
	// TODO: handle exception
	  System.out.println(exception.getMessage());
}
  
		
	}

}}




