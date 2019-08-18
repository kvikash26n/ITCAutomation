/**
 * 
 */
package desktopdemo.desktopdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

/**
 * @author 29265
 *
 */
public class mov {

	/**
	 * @param args
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		// C:\Users\29265\Documents\Mov Desktop
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\Users\\29265\\Documents\\Mov Desktop\\Movilizer_2-4-10_Desktop_Jar.jar");
		System.setProperty("webdriver.winium.driver.desktop", "D:\\winium\\Winium.Desktop.Driver.exe");
		// WiniumDriver driver=new WiniumDriver(remoteAddress, options)
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
		// System.out.println(driver.findElement(By.id("SystemMenuBar")).getText());
		Thread.sleep(20000);
		driver.findElement(By.name("Close")).click();

	}

}
