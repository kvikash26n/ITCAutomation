package Desktop;

import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.accenture.omnichannelframework.api.MethodDataStore;
import com.accenture.omnichannelframework.api.OmnichannelFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.python.modules.thread.thread;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.accenture.omnichannelframework.api.MethodDataStore;
import com.accenture.omnichannelframework.api.OmnichannelFramework;

public class Attach_Form {
	static WebDriver driver ;

	@BeforeClass
	public void before()  {
		
		driver = (WebDriver) OmnichannelFramework

				.getInstanceFromAdapter("Selenium-Driver");

}
	
	 static MethodDataStore methodDataStore=OmnichannelFramework.getMethodDataStore();
	
	@Test
	public void uplaod_Generate_Forms() throws InterruptedException, FindFailed
	{   
		Thread.sleep(5000);
	    //driver.findElement(By.xpath(".//button[text()='Attach a Form']")).click();
		driver.findElement(By.xpath(methodDataStore.getValue("AttachFormSearch"))).click();
		
	    System.out.println(methodDataStore.getValue("AttachFormSearch"));
	    Thread.sleep(3000);
	   //Have to click on trade\
	    driver.findElement(By.xpath(methodDataStore.getValue("Trade"))).click();
	    Thread.sleep(2000);
	    //SearchText
	    driver.findElement(By.xpath(".//*[@class='twoColumnSearchResults searchBtnUp ng-pristine ng-valid']")).sendKeys("M");
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='resultsSearchBar']//button[5]")).click();
	   //driver.findElement(By.xpath("(.//*[@id='resultsSearchBar']/input)[1]")).sendKeys("M");
	   Thread.sleep(6000);
	   //driver.findElement(By.xpath(".//*[@id='resultsSearchBar']/button[1]")).click();
	   //
	   driver.findElement(By.xpath(".//label[@name='resultRadio']")).click();
	   Thread.sleep(2000);
	  
	   driver.findElement(By.xpath("(.//*[@id='packetSetupBody']//*[text()='Next Step'])[1]")).click();
	  // driver.findElement(By.xpath(".//button[text='Next Step']")).click();
  
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(".//button[@class='ng-binding ng-scope']")).click();
	   Thread.sleep(3000);
	   //label for="W9"
			   driver.findElement(By.xpath(".//label[@for='EPA']")).click();
			   Thread.sleep(3000);
			   driver.findElement(By.xpath(".//button[@ng-click='completeAttachForm()']")).click();
			   Thread.sleep(3000);
			   driver.findElement(By.xpath(".//label[@for='specificOnline']")).click();
			   Thread.sleep(2000);

            driver.findElement(By.xpath(".//input[@name='Signatory_Name__c']")).sendKeys("test");
            Thread.sleep(2000);
            
            driver.findElement(By.xpath(".//input[@name='Signatory_Title__c']")).sendKeys("automation");
            Thread.sleep(2000);
            
            //Attach the existing form
            driver.findElement(By.xpath(".//label[@for='specificNow']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath(".//button[@ng-click='initUpload()']")).click();
            Thread.sleep(2000);
            
           // Pattern Browse = new Pattern(methodDataStore.getValue("Browse"));
			  Pattern Desktop = new Pattern("C:\\Users\\kumar.a.vikash\\Desktop\\Desktop.png");
			  Pattern Window = new Pattern("C:\\Users\\kumar.a.vikash\\Desktop\\window.png");
			  Pattern Filename = new Pattern("C:\\Users\\kumar.a.vikash\\Desktop\\filename_field.png");
            Pattern pdf = new Pattern("C:\\Users\\kumar.a.vikash\\Desktop\\EPA_FLO.pdf");
            Pattern save = new Pattern("C:\\Users\\kumar.a.vikash\\Desktop\\Save_Cont.png");
           // Pattern Browse = new Pattern(methodDataStore.getValue("Browse"));
            Thread.sleep(4000);
			 Screen screen = new Screen();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 String SalesForce=driver.getWindowHandle();
				System.out.println(driver.getWindowHandle());
				Thread.sleep(5000);
				screen.click(Desktop);
				Thread.sleep(4000);
				screen.click(Window);
				Thread.sleep(3000);
				screen.type(methodDataStore.getValue("ImagePath"));
				screen.type(Key.ENTER);
				Thread.sleep(3000);
				screen.click(Filename);
				screen.type("EPA_FLO.pdf");
				Thread.sleep(3000);
				screen.type(Key.ENTER);
            Thread.sleep(8000);
           // button ng-click="saveAndDone()"
            System.out.println("File has been selected");
            Thread.sleep(3000);
            screen.click(save);
            		//driver.findElement(By.xpath("(.//button[@ng-click='saveAndDone()'])[1]")).click();
           // driver.findElement(By.xpath(".//button[@ng-click='saveAndDone()']")).click();
            Thread.sleep(5000);
            
           // label 
            driver.findElement(By.xpath(".//label[@for='customerCopy']")).click();
            Thread.sleep(2000);

           //input 
        	driver.findElement(By.xpath(".//input[@name='customerEmail']")).sendKeys("dsd.automation.coke@gmail.com");
           Thread.sleep(2000);
           driver.findElement(By.xpath(".//input[@name='customerEmailSubject']")).sendKeys("attach");
           Thread.sleep(4000);
           driver.findElement(By.xpath(".//textarea[@name='customerEmailBody']")).sendKeys("Hi,FYI");
           Thread.sleep(3000);
           driver.findElement(By.xpath(".//button[@ng-click='saveAndContinue()']")).click();
           Thread.sleep(5000);
           driver.findElement(By.xpath(".//button[@ng-click='submit(true)']")).click();
            System.out.println("one flow has been completed");
           
	}

}
