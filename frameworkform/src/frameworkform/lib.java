package frameworkform;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

public class lib {

static	WebDriver driver;

@BeforeMethod
void setup()
{
	String path = "D:\\Selenium\\geckodriver.exe";
	//test.log(LogStatus.PASS, "broswer has been launch");
	// System.setProperty("webdriver.chrome.driver", path);

	System.setProperty("webdriver.gecko.driver", path);
	driver = new FirefoxDriver();
	// WebDriver dr=new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://www.spicejet.com/");
}

void start()
{
	driver.findElement(By.xpath("")).sendKeys("sdff");
}


}
