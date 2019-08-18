import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class ProgressBar {
	final static int interval=1000;
	int i;
	Timer t;
	JButton btn;
	JProgressBar prg;
	
	
public ProgressBar() {
	JFrame frame=new JFrame();
	frame.setLayout(new FlowLayout());
	btn= new JButton("click");
	//frame.add(btn);
	btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			i=0;
			t.start();
			btn.setEnabled(false);
		}
	});
	prg=new JProgressBar(0,20);
	prg.setValue(0);
	prg.setStringPainted(true);
	frame.add(btn);
	frame.add(prg);
	
	t=new Timer(interval,new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(i==20) {
				t.stop();
				btn.setEnabled(true);
			}
			else {
				i++;
				prg.setValue(i);
			}
		}
	});
	frame.setVisible(true);
	frame.setSize(300, 300);
	
}
public static void main(String ag[]) {
	ProgressBar bar=new ProgressBar();
}
}
