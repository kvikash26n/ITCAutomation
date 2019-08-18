import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class text_box_click {

	/**
	 * @param args
	 */
	 static WebDriver driver;  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
          
		    driver=new ChromeDriver();
		    driver.get("https://google.com");
		WebElement element = driver.findElement(By.xpath("//input[@type='text']")); // Your element
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
		System.out.println(aa.toString());
	}

}
