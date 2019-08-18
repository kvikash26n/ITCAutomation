package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import utility.util;

public class twoD {
	static String day;
	static String cod;
	static String can;
	static boolean flag = true;

	public static void main(String ag[]) throws ParseException {

		String abc = "7/13/2018";
		day = d(abc);
		can = cod;
		// input Jul 07, 2018
		System.out.println("before day=:" + day);

		while (flag) {

			if (day.equals("Saturday") || day.equals("Sunday")) {
				day = d(abc);
				can = cod;
				System.out.println("if part last:=" + cod);

			} else {
				System.out.println(" else part exe after day=:" + day);
				flag = false;
			}

		}
		System.out.println("cancellation date=:"+can);

	}

	public static String d(String abc) throws ParseException {
		Date COD = util.getCancelDate(abc);
		System.out.println("COD=" + COD.toString());
		cod = COD.toString();
		String string1[] = cod.split(" ");
		// string1=string1.replace("00:00:00", arg1)
		String mon = string1[1];
		String day1 = string1[2];
		String year = string1[5];
		cod = mon + " " + day1 + "," + " " + year;
		// System.out.println(cod);
		String day = util.ExtractDayFromDate(cod);
		return day;
	}
}