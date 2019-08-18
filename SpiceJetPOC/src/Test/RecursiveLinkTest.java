/**
 * 
 */
package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author 29265
 *
 */

public class RecursiveLinkTest {
	// list to save visited links
	static List<String> linkAlreadyVisited = new ArrayList<String>();
	WebDriver driver;

	public RecursiveLinkTest(WebDriver driver) {
		this.driver = driver;
	}

	public void linkTest() throws InterruptedException {
		// loop over all the a elements in the page
		for (WebElement link : driver.findElements(By.tagName("a"))) {
			// Check if link is displayed and not previously visited
			if (link.isDisplayed() && !linkAlreadyVisited.contains(link.getText())) {
				// add link to list of links already visited
				linkAlreadyVisited.add(link.getText());
				System.out.println(link.getText());
				// click on the link. This opens a new page
				link.click();
				// call recursiveLinkTest on the new page
				Thread.sleep(3000);
				new RecursiveLinkTest(driver).linkTest();
			}
		}
		driver.navigate().back();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver ;//= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		driver = new ChromeDriver();
		//https://www.google.com/    http://newtours.demoaut.com/
		driver.get("https://www.google.com/");
		// start recursive linkText
		new RecursiveLinkTest(driver).linkTest();
	}
}
