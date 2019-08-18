/**
 * 
 */
package com.bot;

/**
 * @author 29265
 *
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BOTUI extends APIResponce{
	static List alllink;
	static util util;
	static WebDriver driver;
	static String path = "C:\\Users\\29265\\Desktop\\bot_url_report.xlsx";

	final static int interval=1000;
	static int i;
	static Timer t;
//	JButton btnNewButton ;
	static JProgressBar prg;
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("BOT");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());

        final JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 25));

        final JLabel label = new JLabel("url will appear here");
        final JLabel url = new JLabel("load the url one by one");

        final JButton okButton = new JButton("Launch");
        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                System.out.println("Input: " + input);

                label.setText(input);
                i=0;
    			t.start();
    			okButton.setEnabled(false);
                ///*******************selenium***********integartion

        		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        		/*ChromeOptions options = new ChromeOptions();
        		options.addArguments("headless");
        		options.addArguments("window-size=1200x600");
        	WebDriver	driver = new ChromeDriver(options);*/
        		WebDriver driver=new ChromeDriver();
        		        	driver.get(input);
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
        			//  url.setText("all url");
        			try {
						getStatus(url);
					//	url.setText("Task completed...");
			            
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
        		url.setText("Task completed...");
        		Desktop dt = Desktop.getDesktop();
        		try {
					dt.open(new File(path));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
                //**********************************End************
           
            }
        });
        
        prg=new JProgressBar(0,20);
    	prg.setValue(0);
    	prg.setStringPainted(true);
    	frame.add(okButton);
    	frame.add(prg);
    	
    	t=new Timer(interval,new ActionListener() {
    		
    		
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if(i==20) {
    				t.stop();
    				okButton.setEnabled(true);
    			}
    			else {
    				i++;
    				prg.setValue(i);
    			}
    		}
    	});

        container.add(textField);
        container.add(okButton);
        container.add(label);
        container.add(url);

        frame.setVisible(true);
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
		
		//919810281813 mausi
		
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
	