package Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class listdel {
	 public static void main(String ag[]) {
		BB ob=new BB();
		ob.printB();
	//	ob.printB(3);
		
	 }
}
class AA extends BB
{
	String val="ABCD";
	void printA(String val)
	{
		System.out.println("Class AA called"+" "+val);
		System.err.println(val);
	}
}
class BB 
{
	void printB()
	{
		System.out.println("Class BB called");
	}
	void printB(int a)
	{
		System.out.println("Class BB called"+a);
	}
}