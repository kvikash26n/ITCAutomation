package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ModelBasedtestAutomationTest {

  @Test
  public void click() {
   // throw new RuntimeException("Test not implemented");
	  System.out.println("Clicked");
		assertEquals("Clicked", "Clicked");
  }

  @Test
  public void display() {
   // throw new RuntimeException("Test not implemented");
	  System.out.println("displayed");
		assertEquals("displayed", "displayed");
  }

  @Test
  public void login() {
   // throw new RuntimeException("Test not implemented");
	  System.out.println("successfull login");
		assertEquals("logiin", "login");
  }

  @Test
  public void logout() {
  //  throw new RuntimeException("Test not implemented");
	  System.out.println("successfull logout");
		assertEquals("logout", "login");
  }

  @Test
  public void report() {
    //throw new RuntimeException("Test not implemented");
	  System.out.println("reported");
		assertEquals("reported", "reported");
  }
  
  @Test
  public void report123() {
    
  }
  
}
