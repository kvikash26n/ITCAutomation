/**
 * 
 */
package com.itc.itchotels.test;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author 29265
 *
 */
public class Pro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String path='';
		//System.setProperty("webdriver.gecko.driver", path);
	//WebDriver	driver = new FirefoxDriver();
	//driver.findElement("").c
		
		String str="IND@a#";
		String result="";
		
		for(int i=str.length()-1;i<0;i--)
		{
			result+=str.charAt(i);
		}
		System.out.println(result);

		
		
		
		

	}

}
