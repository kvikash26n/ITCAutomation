import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class multi {
	
	public static void main(String args[]){
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    WebDriver webDriver =new ChromeDriver();
    openNewTab(webDriver, "http://www.spicejet.com/", 1);
    
    openNewTab(webDriver, "http://www.spicejet.com/", 2);
    openNewTab(webDriver, "http://www.spicejet.com/", 3);
    openNewTab(webDriver, "http://www.spicejet.com/", 4);
    openNewTab(webDriver, "http://www.spicejet.com/", 5);
    openNewTab(webDriver, "http://www.spicejet.com/", 6);
    openNewTab(webDriver, "http://www.spicejet.com/", 7);
    openNewTab(webDriver, "http://www.spicejet.com/", 8);
    openNewTab(webDriver, "http://www.spicejet.com/", 9);
    openNewTab(webDriver, "http://www.spicejet.com/", 10);
    openNewTab(webDriver, "http://www.spicejet.com/", 11);
    openNewTab(webDriver, "http://www.spicejet.com/", 12);
    openNewTab(webDriver, "http://www.spicejet.com/", 13);
    openNewTab(webDriver, "http://www.spicejet.com/", 14);
    openNewTab(webDriver, "http://www.spicejet.com/", 15);
    openNewTab(webDriver, "http://www.spicejet.com/", 16);
    openNewTab(webDriver, "http://www.spicejet.com/", 17);
    openNewTab(webDriver, "http://www.spicejet.com/", 18);
    openNewTab(webDriver, "http://www.spicejet.com/", 19);
    openNewTab(webDriver, "http://www.spicejet.com/", 20);
    openNewTab(webDriver, "http://www.spicejet.com/", 21);
    openNewTab(webDriver, "http://www.spicejet.com/", 22);
    openNewTab(webDriver, "http://www.spicejet.com/", 23);
    openNewTab(webDriver, "http://www.spicejet.com/", 24);
}

public static void openNewTab(WebDriver webDriver, String url, int position) {
    ((JavascriptExecutor) webDriver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
    System.out.println("tabs : " + tabs.size() + " >position: " + position + " >\t" + url);
    webDriver.switchTo().window(tabs.get(position));
    webDriver.get(url);
   System.out.println(webDriver.getTitle()); 
    
}
}
