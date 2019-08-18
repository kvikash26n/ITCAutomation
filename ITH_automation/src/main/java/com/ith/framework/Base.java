/**
 * 
 */
package com.ith.framework;

/**
 * @author 29265
 *
 */
public class Base {
	
	public static void main(String ag[]) {
		
		try {
			int a=2,b=0;
			int c=a/b;
			System.out.println(c);
		} catch (Exception e) {
			
			try {
				
				int a=2,b=0;
				int c=a/b;
				System.out.println(c);
			} catch (Exception e2) {
				System.out.println("ok");
			}
		}
	}

}
