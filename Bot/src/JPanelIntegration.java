import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class JPanelIntegration {

	/**
	 * @param args
	 */
	private static JPanel contentPane;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();
		EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();

                frame.getContentPane().add(panel);

                panel.addKeyListener(new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {}

                    @Override
                    public void keyReleased(KeyEvent e) {}

                    @Override
                    public void keyPressed(KeyEvent e) {
                        System.out.println("Pressed " + e.getKeyChar());
                    }
                });

                panel.setFocusable(true);
                panel.requestFocusInWindow();

                frame.setSize(new Dimension(300, 300));
                frame.setVisible(true);
            }

        };
	
        SwingUtilities.invokeLater();

    
			public void run() {
				try {
					JPanelIntegration frame = new JPanelIntegration();
					frame.setVisible(true);
					//jf.add(contentPane);
					//jf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	//method for browser
	public JPanelIntegration() {
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

	
}
