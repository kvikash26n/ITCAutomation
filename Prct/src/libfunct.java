import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class libfunct {
	
	
	static WebDriver driver;
	public libfunct(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	static void launch() {
			System.out.println("Welcome to spicejet");
			String path = "D:\\Selenium\\geckodriver.exe";
			// System.setProperty("webdriver.chrome.driver", path);

			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
			// WebDriver dr=new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.spicejet.com/");
			
		}
	

}
