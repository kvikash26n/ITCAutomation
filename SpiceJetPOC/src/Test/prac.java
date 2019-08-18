package Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class prac {
	int a=0,j=3;
	List lt;
	 List<String> lines ;
	
	List<String> getqw() throws IOException
	{
		   lines = Files.readAllLines(Paths.get("C:\\Users\\29265\\Desktop\\name.txt"));
	        System.out.println(lines.size());
	        System.out.println(lines.get(2));
	        for (String line : lines) {
	            System.out.println(line);
	        }
			return lines;
	}
	@Test
	void print() throws IOException
	{
getqw();
	lines.remove("MR	Neil	Thomas");
	}
	/*@AfterMethod
	void get()
	{
		//a=a+1;
		System.out.println("insidemethod=:"+a);
		j=j+a;
	}
*/
}
