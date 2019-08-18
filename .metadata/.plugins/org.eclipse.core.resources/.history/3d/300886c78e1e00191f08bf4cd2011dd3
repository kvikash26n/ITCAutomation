package com.bot;
/**
 * 
 */

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 * @author 29265 Kumar Vikash Sanity Bot Created on 01/01/2019
 */
public class BasicWebCrawler {
static String pURL="https://www.flydubai.com/en";
	static private HashSet<String> links;
	static APIResponce apiResponce;
	static List alllink;
	static util util;
	
	static String path = "C:\\Users\\29265\\Desktop\\SanityBotReport\\SanitybotReport.xlsx";
	//static String url;
	public BasicWebCrawler() {
		links = new HashSet<String>();
	}

	public void getPageLinks(String URL) {
		// 4. Check if you have already crawled the URLs
		// (we are intentionally not checking for duplicate content in this example)
		if (!links.contains(URL)) {
			try {
				// 4. (i) If not add it to the index
				if (links.add(URL)) {
					// System.out.println(URL);
				}
				// 2. Fetch the HTML code
				Document document = Jsoup.connect(URL).get();
				// 3. Parse the HTML to extract links to other URLs
				Elements linksOnPage = document.select("a[href]");
				// 5. For each extracted URL... go back to Step 4.
				for (Element page : linksOnPage) {
					String lurl = page.attr("abs:href");
					System.out.println(lurl); // facebook https blog.google mailto https://jobs.lever.co/
												// lurl.startsWith("https://www.hotstar") &&
					// lurl.startsWith("http://www.coca-cola.");
					if (lurl.startsWith(pURL) && !lurl.contains("mailto")
							&& !lurl.contains("apple.com") && !lurl.contains("blog.google") && !lurl.contains("play")
							&& !lurl.contains("google") && !lurl.contains("facebook") && !lurl.contains("twitter")
							&& !lurl.contains("youtube.com") && !lurl.contains("instagram")
							&& !lurl.contains("sp.booking.com") && !lurl.contains("prezly.com")
							&& !lurl.contains("//https://www.gdrfa.ae/") && !lurl.contains("https://jobs.lever.co/")) {
						getPageLinks(page.attr("abs:href"));
					}
				}
			} catch (IOException e) {
				System.err.println("For '" + URL + "': " + e.getMessage());
			}
		}
	}

	// https://www.flydubai.com/en/ https://www.goindigo.in/  https://www.hotstar.com/  https://www.itcinfotech.com/
	public static void main(String[] args) throws InvalidFormatException, IOException {
	//String	ar=com.bot.util.GetColumnValue(1, "input", "");
		new BasicWebCrawler().getPageLinks(pURL+"/");
		System.out.println("Total URL is : " + links.size());
		Iterator value = links.iterator();
		 while (value.hasNext()) { 
			 try {
				getStatus(value.next().toString());
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

			if (String.valueOf(code).startsWith("2")) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			}


			else if (String.valueOf(code).startsWith("3")) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Passed";

			}
			else if (String.valueOf(code).startsWith("4")) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Failed";

			}
			else if (String.valueOf(code).startsWith("5")) {
				// result = "-> Green <-\t" + "Code: " + code;
				result = "Internal Server Error";

			}

		} catch (Exception e) {
			result = "Wrong domain - Exception: " + e.getMessage();

		}

		

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