/**
 * 
 */
package com.bot;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * @author 29265
 *
 */
public class KeyEvent implements KeyListener{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame jf=new JFrame("key event");
jf.setSize(400, 400);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.addKeyListener(new KeyEvent());
jf.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(java.awt.event.KeyEvent k) {
		// TODO Auto-generated method stub
		System.out.println("key press event");
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
