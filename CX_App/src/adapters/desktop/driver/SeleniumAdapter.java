package adapters.desktop.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.accenture.omnichannelframework.api.Adapter;

public class SeleniumAdapter extends Adapter {

	WebDriver driver;

	@Override
	public void initialize() {
		//String currentDriver = getPropertyValue("driver");
		String Path = getPropertyValue("Path");
	String ChromeProfile = getPropertyValue("ChromeProfile");

		System.setProperty("webdriver.chrome.driver", Path);

	
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("user-data-dir="+ChromeProfile);
	driver = new ChromeDriver(opt);
		
	//	driver=new ChromeDriver();
	}

	@Override
	public Object getInstance() {
		return driver;
	}

	@Override
	public String getName() {
		return "Selenium WebDriver";
	}

	@Override
	public void configureProperties() {
		
		addProperty("driver", "Driver", "chrome");
		addProperty("Path", "Path","C:/chromedriver.exe");
		addProperty("ChromeProfile","ChromeProfile","C:\\Users\\kumar.a.vikash\\AppData\\Local\\Google\\Chrome\\New User\\User Data");
	
	}

	@Override
	public String getId() {
		return "Selenium-Driver";
	}

	@Override
	public void cleanUp() {
//		driver.quit();
//		String os = System.getProperty("os.name");
//
//		if (os.contains("Windows")) {
//
//		try {
//			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}

	}

	@Override
	public void afterSuite() {
		// TODO Auto-generated method stub

	}

}
