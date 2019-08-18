package frameworkform;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeScreenShot {
	 static WebDriver driver;
	public static void main(String args[]) throws Exception{
	     //Modify the path of the GeckoDriver in the below step based on your local system path
	           // System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
	            System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	            //D:\chromedriver_win32
	            // Instantiation of driver object. To launch Firefox browser
	     // driver = new FirefoxDriver();
	      driver=new ChromeDriver();
	            // To oepn URL "http://softwaretestingmaterial.com"
	     driver.get("https://www.finnair.com/");
	     Thread.sleep(2000);
	     TakeScreenShot takeScreenShot=new TakeScreenShot();
	     takeScreenShot.getScreenshot("Demo");
	     
	     }
	
	public String getScreenshot(String imageName) throws IOException
	{
		File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation=System.getProperty("user.dir")+"\\src\\screenshot\\";
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName=imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile=new File(actualImageName);
		FileUtils.copyFile(image,destFile);
		return actualImageName;
		
	}
}
