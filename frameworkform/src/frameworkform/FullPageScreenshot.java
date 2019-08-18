package frameworkform;


import java.io.File;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
 
public class FullPageScreenshot {
 public static void main(String args[]) throws Exception{
     //Modify the path of the GeckoDriver in the below step based on your local system path
            System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
            // Instantiation of driver object. To launch Firefox browser
     WebDriver driver = new FirefoxDriver();
            // To oepn URL "http://softwaretestingmaterial.com"
     driver.get("https://www.spicejet.com");
     Thread.sleep(2000);
     Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
     ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D://FullPageScreenshot.png"));
        }
}