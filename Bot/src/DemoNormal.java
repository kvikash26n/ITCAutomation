import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class DemoNormal {

	/**
	 * @param args
	 */
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
          //D:\chromedriver_win32
          // In	stantiation of driver object. To launch Firefox browser
   // driver = new FirefoxDriver();
    driver=new ChromeDriver();
          // To oepn URL "http://softwaretestingmaterial.com"
   driver.get("https://www.amazon.in/");
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
   
   for(int j=0;j<alllink.size();j++) {
	   driver.get((String) alllink.get(j));
   }
  // System.out.println(abc);
   /*for(int i=1;i<=abc.size();i++) {
	  // abc.get(i).click();
	   String aString="(//a[@href])[";
	   String bString="]";
	   try {
	   if(driver.findElement(By.xpath(aString+i+bString)).isDisplayed()) {
		   driver.findElement(By.xpath(aString+i+bString)).click();
		   driver.get("https://www.amazon.in/");
	   }
	   }
	   catch (Exception e) {
		System.out.println(aString+i+bString+" "+"url no working");
	}
	   ////input[@type]
	
   }
*/	
 // String uString= driver.findElement(By.xpath("(//a[@href])[289]")).getAttribute("href");
  // driver.get(uString);
	}

}
