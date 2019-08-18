package Desktop;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.accenture.omnichannelframework.api.MethodDataStore;
import com.accenture.omnichannelframework.api.OmnichannelFramework;

public class CXLogin {
	
	static WebDriver driver ;

	@BeforeClass
	public void before()  {
		
		driver = (WebDriver) OmnichannelFramework

				.getInstanceFromAdapter("Selenium-Driver");

}
	
	 static MethodDataStore methodDataStore=OmnichannelFramework.getMethodDataStore();
	
	
	 @Test(description="Launch CX Application")
		@Parameters({"URL"})
		
		public void launch(@Optional("chrome://apps/") String URL) throws InterruptedException, AWTException
		{
			driver.get(URL);
			Thread.sleep(2000);
			driver.manage().window().maximize(); 
			Thread.sleep(2000);
			
			String Parent=driver.getWindowHandle();
			String salesforce=null, cx=null;
			driver.findElement(By.xpath(".//*[@title='MAY Rollup']")).click();
			Thread.sleep(4000);
			
			for (String handle : driver.getWindowHandles()) {
				
				driver.switchTo().window(handle);
				
				if(handle.equals(Parent)){
					
		
					
				}
				else if(driver.getTitle().equals("Confirm Permissions")){
					salesforce=handle;
					System.out.println("s"+salesforce);
				}
				else{
					cx=handle;
					System.out.println("c"+cx);
				}
//				System.out.println(handle);
//				driver.switchTo().window(handle);
				Thread.sleep(15000);
//				System.out.println(driver.getTitle());

				

			}
			
			System.out.println();
			driver.switchTo().window(salesforce);
				Screen screen = new Screen();
			
		Thread.sleep(1000);
			screen.type(Key.TAB);
			Thread.sleep(1000);		
		screen.type("kumar.a.vikash@accenture.com.sales.mayrollup1");
			Thread.sleep(1000);
			screen.type(Key.TAB);
			Thread.sleep(1000);	
		screen.type("Coke123$");
			Thread.sleep(1000);
			screen.type(Key.TAB);
		Thread.sleep(1000);
			screen.type(Key.ENTER);
			Thread.sleep(1000);
			
			Thread.sleep(100000);
			
			driver.switchTo().window(cx);
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(".//*[@id='btnCustomerExpress']")).click();
			Thread.sleep(17000);
			for (String handle : driver.getWindowHandles()) 
			{
				System.out.println(handle);
				driver.switchTo().window(handle);
				System.out.println("switched to window handle::"+handle);
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			/*String newWindow= null ;
			driver.switchTo().window(Parent);
			Thread.sleep(2000);
			screen.type("N", KeyModifier.CTRL);
			for (String handle : driver.getWindowHandles()) {
				if(!handle.equals(Parent)||handle.equals(cx)){
					newWindow=handle;
				}
			}
			driver.switchTo().window(newWindow);
			
			driver.get("https://nasales--MayRollup.cs40.my.salesforce.com");
			Thread.sleep(6000);
		
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(("r.thilagavathi@accenture.com.sales.mayrollup2")); 
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(("Coke123$"));
			
			Thread.sleep(2000);*/
			
			
			
			
			
			
			
		} 
	

}
