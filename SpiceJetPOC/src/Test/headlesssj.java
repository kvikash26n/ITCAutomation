/**
 * 
 */
package Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * @author 29265
 *
 */

//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//import com.gargoylesoftware.htmlunit.BrowserVersion;
public class headlesssj {
	
		 
		public static void main(String[] args) throws InterruptedException {
	 
			// Declaring and initialising the HtmlUnitWebDriver
			   File file = new File("C:/Program Files/phantomjs-2.0.0-windows/bin/phantomjs.exe");				
               System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
               WebDriver driver = new PhantomJSDriver();	
               driver.get("http://www.google.com");         
               WebElement element = driver.findElement(By.name("q"));	
               element.sendKeys("Guru99");					
               element.submit();         			
               System.out.println("Page title is: " + driver.getTitle());		
               driver.quit();
			}
	 
	
}
