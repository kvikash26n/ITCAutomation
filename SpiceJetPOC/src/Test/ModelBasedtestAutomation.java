/**
 * 
 */
package Test;

import static org.testng.Assert.assertEquals;


import org.junit.Test;

/**
 * @author 29265
 *
 */
public class ModelBasedtestAutomation {
	
	@Test
	void login() {
		System.out.println("successfull login");
		assertEquals("login", "login");
		
	}
	@Test
	void logout() {
		System.out.println("successfull logout");
	}
	@Test
	void click() {
		System.out.println("Clicked");
		
	}@Test
	void display() {
		System.out.println("displayed");
		
	}@Test
	void report() {
		System.out.println("reported");
	}
}
