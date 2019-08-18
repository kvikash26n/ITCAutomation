import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class mainClass extends Applet implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	TextField t1=new TextField();
	TextField t2=new TextField();
	TextField t3=new TextField();
	
	public mainClass() {
		// TODO Auto-generated constructor stub
		Label l1=new Label("A");
		Label l2=new Label("B");
		Label l3=new Label("CX");
		setLayout(new GridLayout(3, 2));
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		t2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s1=t1.getText();
		String s2=t2.getText();
		t3.setText(s1+s2);
		
	}

}
