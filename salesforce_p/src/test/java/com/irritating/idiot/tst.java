/**
 * 
 */
package com.irritating.idiot;

import java.sql.Driver;

/**
 * @author 29265
 *
 */

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tst {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://test.salesforce.com/");
		d.findElement(By.xpath("//input[@name='username']")).sendKeys("prabhjot.kaur@admin.com");
		d.findElement(By.xpath("//input[@id='password']")).sendKeys("Fusion@123");
		d.findElement(By.xpath("//input[@id='Login']")).click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.findElement(By.xpath("//img[@title='All Tabs']")).click();
		d.findElement(By.xpath("//a[@class='listRelatedObject caseBlock title']")).click();
		d.findElement(By.xpath("//input[@value=' New ']")).click();
		d.findElement(By.xpath("//select[@id='p3']")).click();
		d.findElement(By.xpath("//option[@value='01236000000OmcF']")).click();
		d.findElement(By.xpath("//input[@title='Continue']")).click();
		d.findElement(By.xpath("(//img[@class='lookupIcon'])[5]")).click();
		Thread.sleep(5000);
		String handle = d.getWindowHandle();

		System.out.println(handle);

		String parent = d.getWindowHandle();

		
		Set window = d.getWindowHandles();
		String p = d.getWindowHandle();
		window.remove(p);
		String w = (String) window.iterator().next();
		d.switchTo().window(w);
		// ((WebDriver) window).switchTo().window(w);
		String s1 = d.getTitle();
		System.out.println(s1);
		d.switchTo().frame(d.findElement(By.xpath("//*[@title='Search']")));
		d.findElement(By.id("lksrch")).sendKeys("LIBTAYO Surround");
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[@name='go']")).click();
		Thread.sleep(2000);

		d.switchTo().defaultContent();
		d.switchTo().frame(d.findElement(By.xpath("//*[@title='Results']")));
		Thread.sleep(2000);

		d.findElement(By.xpath("//a[@class=' dataCell ']")).click();
		Thread.sleep(2000);

		d.switchTo().window(p);
		Thread.sleep(2000);

		System.out.println(d.getTitle());

	}
}
