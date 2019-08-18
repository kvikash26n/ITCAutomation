
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.lang.annotation.Native;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 * @author 29265
 *
 */
public class browserOn extends JFrame  implements KeyListener{
	//JFrame
	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//KeyEvent key;
	
	public static void main(String[] args) {
		UIUtils.setPreferredLookAndFeel();
		//NativeInterface.open();
		NativeInterface.initialize();
		
	/*	JFrame jf=new JFrame("key event");
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.addKeyListener(new KeyEvent());
		jf.setVisible(true);
	*/	//modified below
		/*jf.add(contentPane);
		jf.setVisible(true);*/
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					browserOn frame = new browserOn();
					frame.setVisible(true);
					//jf.add(contentPane);
					//jf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void keyReleased(java.awt.event.KeyEvent k) {
		// TODO Auto-generated method stub
		System.out.println("key releease event");
	}
	public browserOn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0,0));
		
		final JWebBrowser browser=new JWebBrowser();
		browser.navigate("https://www.google.com");
		panel.add(browser,BorderLayout.CENTER);
		
		JPanel config=new JPanel(new BorderLayout());
		config.setBorder(BorderFactory.createTitledBorder("config"));
		String ls ="";
		final JTextArea area=new JTextArea(
				"<html>"+ls+
				"<body>"+ls+
				"<h1> some header </h1>"+ls+
				"<p> a paragraph with <a href=\"https://www.google.com\">link</a>" +ls+
				"</body>"+ls+
				"</html>"
				);
		JScrollPane scroll = new JScrollPane(area);
		Dimension siz =scroll.getPreferredSize();
		siz.height+=20;
		scroll.setPreferredSize(siz);
		config.add(scroll,BorderLayout.CENTER);
		JPanel config2=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		JButton but =new JButton("set");
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				browser.setHTMLContent(area.getText());
				
			}
		});
		
	config2.add(but);
	config.add(config2,BorderLayout.SOUTH);
	add(config,BorderLayout.NORTH);
	
	
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
