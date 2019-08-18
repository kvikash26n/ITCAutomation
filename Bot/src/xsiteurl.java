import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class xsiteurl {
	static WebDriver driver;
	public static void main(String args[]) throws InvalidFormatException, IOException   {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		//options.addArguments("window-size=1200x600");
			driver = new ChromeDriver();
	//	List vaList = com.bot.util.GetColumnValue(1, "input_url", path);
		// System.out.println((String) vaList.get(0));

		// To oepn URL "http://softwaretestingmaterial.com"
		driver.get("http://www.xsitemap.com/");
		//Thread.sleep(15000);
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys("www.spicejet.com/");
		
		driver.findElement(By.xpath("//input[@id='generate_sitemap']")).click();
	String aString=	driver.findElement(By.xpath("//*[@id='xml-sitemap-generator']//pre")).getText();
	System.out.println(aString);
	}
}
