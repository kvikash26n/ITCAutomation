package BOTurlChecks;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//from w w w.  ja  v a  2  s.c o  m
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Main extends JFrame {
	public Main() {
	}

  static Main f1 = null;

  public static void main(String[] args) {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JButton button = new JButton();

    Main f = null;
    f = new Main();

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(700, 400);

    panel1.setLayout(new BorderLayout());
    panel1.setForeground(Color.white);
    button.setText("Convert");
    panel1.add(button, BorderLayout.SOUTH);

    f.setContentPane(panel1);
    f.setVisible(true);

    f1 = new Main();

    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setSize(457, 100);
    f1.setTitle("Conversion Progress");
    f1.setLocationRelativeTo(null);

    panel2.setLayout(new BorderLayout());
    panel2.setForeground(Color.white);

    JProgressBar progressBar = new JProgressBar();
    progressBar.setValue(35);
    progressBar.setStringPainted(true);

    panel2.add(progressBar, BorderLayout.SOUTH);

    f1.setContentPane(panel2);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        f1.setVisible(true);
      }
    });
  }
}
