import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/* www.j  a  v  a2s  .c o  m*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

  public static void main(String arg[]) {
    MyFrame m = new MyFrame();
    m.setSize(330, 100);
    m.setVisible(true);
  }
}

class MyFrame extends JFrame implements ActionListener {
  JProgressBar pb;
  JButton b1 = new JButton("LOGIN");

  MyFrame() {
    setLayout(null);    
    b1.setBackground(Color.yellow);
    pb = new JProgressBar(1, 100);
    pb.setValue(0);
    pb.setStringPainted(true);
    b1.setBounds(20, 20, 80, 25);
    pb.setBounds(110, 20, 200, 25);
    pb.setVisible(false);
    add(b1);
    add(pb);
    b1.addActionListener(this);
    setResizable(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e) {
    int i = 0;
    if (e.getSource() == b1) {
      pb.setVisible(true);
      try {
        while (i <= 100) {
          Thread.sleep(50);
          pb.paintImmediately(0, 0, 200, 25);
          pb.setValue(i);
          i++;
          
          System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			// WebDriver driver = new ChromeDriver();
			// driver.get(url);
			/// *******************selenium***********integartion

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("headless");
			 * options.addArguments("window-size=1200x600"); WebDriver driver = new
			 * ChromeDriver(options);
			 */
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.finnair.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }
      } catch (Exception e1) {
        System.out.print("Caughted exception is =" + e1);
      }
    }
  }
}