

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;



import Splash.home;
import Splash.splash;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class BOTUIUSingSwing extends JFrame {
	
	// ***
	final static int interval = 2140;
	int k;
	Timer t;
	JButton btnNewButton;
	JTextArea textArea ;
	//JProgressBar prg;
	JProgressBar progressBar;
	//
	static String input;

	private static JPanel contentPane;
	private JTextField textField;
	static List alllink;
	static util util;
	//static WebDriver driver;
	static String path = "C:\\Users\\29265\\Desktop\\bot_url_report.xlsx";
	static APIResponce apiResponce;
	
	splash	splash1;
	private JLabel lblNewLabel_1;

	// static JLabel label=null ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BOTUIUSingSwing frame = new BOTUIUSingSwing();
					frame.setTitle("BOT UI");
					frame.setVisible(true);
					
					

				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public  BOTUIUSingSwing() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 509);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("Enter the URL :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 170, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 176, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 200, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 280, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel);

	textField = new JTextField();
	sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 176, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, textField, 359, SpringLayout.WEST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, textField, 505, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(30);

		btnNewButton = new JButton("Launch");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 232, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 361, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 255, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 447, SpringLayout.WEST, contentPane);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setToolTipText("Click to launch the url");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				k = 0;
				t.start();
				
				btnNewButton.setEnabled(false);
				/*while(input==null) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
				}
				*/ input = textField.getText();


			}
		});
		contentPane.add(btnNewButton);

		t = new Timer(interval, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (k == 100) {
					t.stop();
					btnNewButton.setEnabled(true);
				} else {
					k++;
					progressBar.setValue(k);
				}
			}
		});
		

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.activeCaption);
		// JProgressBar
		progressBar = new JProgressBar();
		sl_contentPane.putConstraint(SpringLayout.NORTH, progressBar, 325, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, progressBar, 222, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, progressBar, 339, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, progressBar, 581, SpringLayout.WEST, contentPane);
		progressBar.setForeground(Color.GREEN);
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 13));
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		contentPane.add(progressBar);
		
		lblNewLabel_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 11, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 491, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 154, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 716, SpringLayout.WEST, contentPane);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\29265\\Desktop\\All\\ITCLOGO.PNG"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblThisProductIs = new JLabel("This product is licensed to ITC INFOTECH. \u00A9 All rights reserved.");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblThisProductIs, 434, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblThisProductIs, 37, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblThisProductIs, 401, SpringLayout.WEST, contentPane);
		contentPane.add(lblThisProductIs);
		
		

	}
}
