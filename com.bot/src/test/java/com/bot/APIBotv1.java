/**
 * 
 */
package com.bot;

/**
 * @author 29265
 *
 */

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author 29265
 *
 */
public class APIBotv1 extends util {
	/**
	 * @param driver
	 */
	public APIBotv1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static HashMap<String, String> hm;
	static List allTemplink;
	static List alllink;
	static util util;
	static WebDriver driver;
	static String path = "C:\\Users\\29265\\Desktop\\bot_url_report.xlsx";

	public static void main(String args[]) throws InvalidFormatException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		driver = new ChromeDriver(options);
		// List vaList = com.bot.util.GetColumnValue(1, "input_url", path);
		// System.out.println((String) vaList.get(0));
		hm = new HashMap<String, String>();

		driver.get("https://www.google.com/");
		String title = driver.getTitle();

		// System.out.println("Initial list of elements: "+hm);

		//// System.out.println(link);
		// link = link.replace("=", "");
		hm.put(title, "https://www.google.com/");

		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getallLinkFromPage();
		// need to make a copy for all url list
		if (alllink.size() >= 1) {
			for (int i = 0; i < alllink.size(); i++) {
				driver.get((String) alllink.get(i));
				// getallLinkFromPage();
				String title1 = driver.getTitle();
				if (title!="") {
					// System.out.println("Initial list of elements: "+hm);
					String link = alllink.get(i).toString();
					System.out.println(link);
					link = link.replace("=", "");
					hm.put(title1, link);
					System.out.println("Initial list of elements: " + hm);
				}
			}
		} else {
			System.out.println("no url is captured");
		}
		// 2nd
		for (int i = 0; i < alllink.size(); i++) {
			driver.get((String) alllink.get(i));
			// getallLinkFromPage();
			String title1 = driver.getTitle();

			// System.out.println("Initial list of elements: "+hm);
			String link = alllink.get(i).toString();
			System.out.println(link);
			link = link.replace("=", "");
			hm.put(title1, link);
			System.out.println("Initial list of elements: " + hm);
		}

	}

	static void getallLinkFromPage() {
		List<WebElement> abc = driver.findElements(By.xpath("//a[@href]"));

		allTemplink = new ArrayList();
		alllink = allTemplink;

		for (int i = 1; i <= abc.size(); i++) {
			String aString = "(//a[@href])[";
			String bString = "]";
			// aString+i+bString
			allTemplink.add(driver.findElement(By.xpath(aString + i + bString)).getAttribute("href"));
			// alllink.add((aString+i+bString).get(i));
		}
		/*
		 * for (int i = 1; i <= abc.size(); i++) { String aString = "(//a[@href])[";
		 * String bString = "]"; // aString+i+bString
		 * alllink.add(driver.findElement(By.xpath(aString + i +
		 * bString)).getAttribute("href")); // alllink.add((aString+i+bString).get(i));
		 * hm=new HashMap<String,String>();
		 * System.out.println("Initial list of elements: "+hm); hm.put("","Amit");
		 * hm.put("","Vijay"); hm.put("","Rahul"); }
		 */

	}
}
