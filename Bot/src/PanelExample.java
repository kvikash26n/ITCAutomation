/**
 * 
 */

/**
 * @author 29265
 *
 */

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;  
public class PanelExample   implements KeyListener{
	
	//static JFrame f;
/*     PanelExample()  
        {  
         f= new JFrame("Panel Example");    
        JPanel panel=new JPanel();  
        panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.gray);  
        JButton b1=new JButton("Button 1");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   
        JButton b2=new JButton("Button 2");   
        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);   
        panel.add(b1); 
        panel.add(b2);  
        f.add(panel);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(new KeyEvent());
      //  f.setVisible(true);
                f.setSize(400,400);    
                f.setLayout(null);    
                f.setVisible(true);    
        } */ 
        public static void main(String args[])  
        {  
     //   new PanelExample();  
        	JFrame  f=new JFrame("key event");
       JPanel panel=new JPanel();  
        panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.gray);  
        JButton b1=new JButton("Button 1");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   
        JButton b2=new JButton("Button 2");   
        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);   
        panel.add(b1); 
        panel.add(b2);  
        f.add(panel); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(new KeyEvent());
      //  f.setVisible(true);
                f.setSize(400,400);    
              //  f.setLayout(null);    
               // f.setVisible(true);    

     //   jf.setSize(400, 400);
       // jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(new KeyEvent());
        f.setVisible(true);
        
      //  event();
        } 
        public void keyPressed(java.awt.event.KeyEvent k) {
    		// TODO Auto-generated method stub
    		System.out.println("key press event"+k.getKeyChar());
    	}

    	/* (non-Javadoc)
    	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
    	 */
    	public void keyReleased(java.awt.event.KeyEvent k) {
    		// TODO Auto-generated method stub
    		System.out.println("key releease event");
    	}

    	/* (non-Javadoc)
    	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
    	 */
    	public void keyTyped(java.awt.event.KeyEvent k) {
    		// TODO Auto-generated method stub
    		System.out.println("key typed event");
    	}

    }