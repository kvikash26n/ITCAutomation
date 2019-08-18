/**
 * 
 */
package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * @author 29265
 *
 */
public class ColorvalidationMYSe {

	// static WebDriver driver;
		public static void main(String args[]) throws Exception{
		     //Modify the path of the GeckoDriver in the below step based on your local system path
		           // System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
		            System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		            //D:\chromedriver_win32
		            // Instantiation of driver object. To launch Firefox browser
		     // driver = new FirefoxDriver();
		            DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();       
		            		handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		            		WebDriver driver = new ChromeDriver (handlSSLErr);
		            
		            
		     // driver=new ChromeDriver();
		            // To oepn URL "http://softwaretestingmaterial.com"
		     driver.get("https://mysein.btsec.dev.schneider-electric.com/mySchneider/#!/logout");
		     Thread.sleep(2000);
		 //    TakeScreenShot takeScreenShot=new TakeScreenShot();
		   //  takeScreenShot.getScreenshot("Demo");
		    driver.findElement(By.id("username")).sendKeys("myseautotest@gmail.com");//email
		     driver.findElement(By.id("userpassword")).sendKeys("myseautotest@gmail.com!");//password
		     driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
		     Thread.sleep(5000);
		    
		     WebElement element=driver.findElement(By.xpath("//*[text()='My Account']"));
		     String color1=element.getCssValue("color")		;
		     System.out.println("before hover"+color1);
		    // String hex=Color.fromString(color1).asHex();
		   //  System.out.println(hex);
		     Actions act=new Actions(driver);
		     act.moveToElement(element).perform();
		     String color2=element.getCssValue("color");
		     System.out.println("after hover"+color2);
		     
		     }
		
	
		
		
}
