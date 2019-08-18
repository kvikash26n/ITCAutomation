


import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



/**
 * @author 29265 KUMAR VIKASH
 *
 */
public class javaDoc extends APIResponce {
	static APIResponce apiResponce;
	static List alllink;
	static util util;
	static WebDriver driver;
	static String path = "C:\\Users\\29265\\Desktop\\bot_url_report.xlsx";
	static String url;

	public static void main(String ag[]) {
		BOTUIUSingSwing bot = new BOTUIUSingSwing();

		System.out.println(url);
		bot.setVisible(true);
		bot.setTitle("BOT Sanity URL Checks");

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		url = BOTUIUSingSwing.input;
		System.out.println(url);

		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		apiResponce = new APIResponce();
		System.out.println("entered url:" + url);
		////System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		/// *******************selenium***********integartion

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		/*
		 * * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("headless");
		 * options.addArguments("window-size=1200x600"); WebDriver driver = new
		 * ChromeDriver(options);
		 */

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		List<WebElement> abc = driver.findElements(By.xpath("//a[@href]"));
		System.out.println(abc.size());
		alllink = new ArrayList();

		for (int i = 1; i <= abc.size(); i++) {
			String aString = "(//a[@href])[";
			String bString = "]";
			// aString+i+bString
			alllink.add(driver.findElement(By.xpath(aString + i + bString)).getAttribute("href"));

		}
		/*// to remove javascript related url
		for (int i = 0; i < alllink.size(); i++) {
			//
			if (alllink.get(i).toString().contains("javascript")) {
				alllink.remove(i);
			}

			if (alllink.get(i).equals("javascript:void(0)")) {
				alllink.remove(i);
			}

		}*/
		System.out.println("total url count is=" + alllink.size());
		for (int i = 0; i < alllink.size(); i++) {
			String url = (String) alllink.get(i);

			try {
				getStatus(url);

			} catch (EncryptedDocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		System.out.println("Task completed...");
		// url.setText("Task completed...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		Desktop dt = Desktop.getDesktop();
		try {
			dt.open(new File(path));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// **********************************End************

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

		} catch (Exception e) {
			result = "Wrong domain - Exception: " + e.getMessage();

		}

		// 919810281813 mausi

		System.out.println(url + "\t\tStatus:" + result);
		if (result.contains("Wrong domain - Exception: ")) {
			Object[][] pnrdetails = { { url, "Failed", "NA" } };
			util.AppendPnr(pnrdetails, path, "report");
		} else {
			String responce = apiResponce.getCodeValue(code);
			Object[][] pnrdetails = { { url, result, code, responce } };
			util.AppendPnr(pnrdetails, path, "report");
		}

		return result;
	}

}
