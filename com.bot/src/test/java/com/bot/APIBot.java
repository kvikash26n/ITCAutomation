package com.bot;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
public class APIBot extends util {
	/**
	 * @param driver
	 */
	public APIBot(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static List alllink;
	static util util;
	static WebDriver driver;
	static String path = "C:\\Users\\29265\\Desktop\\bot_url_report.xlsx";

	public static void main(String args[]) throws InvalidFormatException, IOException   {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		driver = new ChromeDriver(options);
		List vaList = com.bot.util.GetColumnValue(1, "input_url", path);
		// System.out.println((String) vaList.get(0));

		// To oepn URL "http://softwaretestingmaterial.com"
		driver.get((String) vaList.get(0));
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> abc = driver.findElements(By.xpath("//a[@href]"));

		alllink = new ArrayList();

		for (int i = 1; i <= abc.size(); i++) {
			String aString = "(//a[@href])[";
			String bString = "]";
			// aString+i+bString
			alllink.add(driver.findElement(By.xpath(aString + i + bString)).getAttribute("href"));
			// alllink.add((aString+i+bString).get(i));
		}
		// to remove javascript related url
		for (int i = 0; i < alllink.size(); i++) {
			//
			if(alllink.get(i).toString().contains("javascript")) {
				alllink.remove(i);
			}
			/*if (alllink.get(i).equals("javascript:void(0)")) {
				alllink.remove(i);
			}*/
		}
		System.out.println("total url count is=" + alllink.size());
		for (int i = 0; i < alllink.size(); i++) {
			String url = (String) alllink.get(i);
			// String url = hostList[i];
			getStatus(url);

		}
		System.out.println("Task completed...");
	}

	public static String getStatus(String url) throws IOException, EncryptedDocumentException, InvalidFormatException {

		String result = "";
		int code = 0;
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();

			code = connection.getResponseCode();

			if (code == 200) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			}

			else if (code == 202) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			}

			else if (code == 201) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			}

			else if (code == 203) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			} else if (code == 204) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			} else if (code == 205) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			} else if (code == 206) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			} else if (code == 207) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			} else if (code == 208) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			} else if (code == 226) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			} else if (String.valueOf(code).contains("3")) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Warning";

			}

			/*
			 * else { // result = "-> Yellow <-\t" + "Code: " + code; result =
			 * "Moved Permanently";
			 * 
			 * }
			 */

		} catch (Exception e) {
			result = "Wrong domain - Exception: " + e.getMessage();

		}
		
		System.out.println(url + "\t\tStatus:" + result);
		if (result.contains("Wrong domain - Exception: ")) {
			Object[][] pnrdetails = { { url,  "Failed","NA" } };
			com.bot.util.AppendPnr(pnrdetails, path, "report");
		} else {
		String responce=	getCodeValue(code);	
			Object[][] pnrdetails = { { url,  result,code ,responce} };
			com.bot.util.AppendPnr(pnrdetails, path, "report");
		}

		return result;
	}

}
