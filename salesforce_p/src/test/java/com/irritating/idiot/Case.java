/**
 * 
 */
package com.irritating.idiot;

/**
 * @author 29265
 *
 */

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import com.sun.org.apache.bcel.internal.generic.Select;

public class Case {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver d= new ChromeDriver();
		d.get("https://test.salesforce.com/");
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("prabhjot.kaur@admin.com");
		d.findElement(By.xpath("//input[@id='password']")).sendKeys("Fusion@123");
		d.findElement(By.xpath("//input[@id='Login']")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		d.findElement(By.xpath("//img[@title='All Tabs']")).click();
		d.findElement(By.xpath("//a[@class='listRelatedObject caseBlock title']")).click();
		d.findElement(By.xpath("(//input[@class='btn'])[2]")).click();
		d.findElement(By.xpath("//option[@value='01236000000OmcP']")).click();
		d.findElement(By.xpath("//input[@title='Continue']")).click();
		d.findElement(By.xpath("//select[@id='00N3600000SLMEP']")).click();
		d.findElement(By.xpath("//option[@value='Appeal']")).click();
		d.findElement(By.xpath("//option[@value='Appeal']")).click();
		d.findElement(By.xpath("//select[@id='00N3600000SLMF6']")).click();
		d.findElement(By.xpath("//option[@value='Prior Authorization']")).click();
		d.findElement(By.xpath("(//img[@class='lookupIcon'])[2]")).click();
		Thread.sleep(5000);
		String handle= d.getWindowHandle();
		System.out.println(handle);
		
		
		
		Set window= d.getWindowHandles();
		window.remove(handle);
		String w = (String) window.iterator().next();
		d.switchTo().window(w);
		String s1 = d.getTitle();
		System.out.println(s1);
		d.switchTo().frame(d.findElement(By.xpath("//*[@title='Search']")));
		
		
		d.findElement(By.id("lksrch")).sendKeys("kh hkj hkjh");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@class='btn']")).click();
		Thread.sleep(5000);
}
}