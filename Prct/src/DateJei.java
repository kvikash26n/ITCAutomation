import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 */

/**
 * @author 29265
 *
 */
public class DateJei {

	public static void main(String ag[]) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();
		String reportDate = df.format(dateobj);
		// Mon 12.05 Mon 12.15
		System.out.println("Report Date: " + reportDate);
		String datePartscurrent[] = reportDate.split("/");
		String monthcurrent = datePartscurrent[0];
		String daycurrent = datePartscurrent[1];
		String yearcurrent = datePartscurrent[2];
		System.out.println(monthcurrent + " " + daycurrent + " " + yearcurrent);

		Date now = new Date(reportDate);

		SimpleDateFormat simpleDateformat = new SimpleDateFormat(""); // the day of the week abbreviated
		// System.out.println(simpleDateformat.format(now));

		simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
		String day = simpleDateformat.format(now);
		day = day.substring(0, 3);
		System.out.println(day);
		List appVal = new ArrayList();
		List WeekDate = new ArrayList();
		List WeekDateValidate = new ArrayList();
		appVal.add("Mon 12.10");
		appVal.add("Tue 12.11");
		appVal.add("Wed 12.12");
		appVal.add("Thu 12.13");
		appVal.add("Fri 12.14");
		String[] week = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
		int a, b, c, d, e;
		if (day.equalsIgnoreCase("Mon")) {

			a = Integer.parseInt(daycurrent);
			b = a + 1;
			c = a + 2;
			d = a + 3;
			e = a + 4;
			WeekDate.add(a);
			WeekDate.add(b);
			WeekDate.add(c);
			WeekDate.add(d);
			WeekDate.add(e);

			WeekDateValidate.add(week[0] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[1] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[2] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[3] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[4] + " " + yearcurrent + "." + a);

			// WeekDateValidate appVal
			if (WeekDateValidate.equals(appVal)) {
				// print log massgae
			}

		} else if (day.equalsIgnoreCase("Tue")) {
			a = Integer.parseInt(daycurrent) - 1;
			b = a + 1;
			c = a + 2;
			d = a + 3;
			e = a + 4;
			WeekDate.add(a);
			WeekDate.add(b);
			WeekDate.add(c);
			WeekDate.add(d);
			WeekDate.add(e);

			WeekDateValidate.add(week[0] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[1] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[2] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[3] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[4] + " " + yearcurrent + "." + a);

			// WeekDateValidate appVal
			if (WeekDateValidate.equals(appVal)) {
				// print log massgae
			}
		} else if (day.equalsIgnoreCase("Wed")) {
			a = Integer.parseInt(daycurrent) - 2;
			b = a + 2;
			c = a + 3;
			d = a + 4;
			e = a + 5;
			WeekDate.add(a);
			WeekDate.add(b);
			WeekDate.add(c);
			WeekDate.add(d);
			WeekDate.add(e);

			WeekDateValidate.add(week[0] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[1] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[2] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[3] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[4] + " " + yearcurrent + "." + a);

			// WeekDateValidate appVal
			if (WeekDateValidate.equals(appVal)) {
				// print log massgae
			}
		} else if (day.equalsIgnoreCase("Thu")) {
			a = Integer.parseInt(daycurrent) - 3;
			b = a + 3;
			c = a + 4;
			d = a + 5;
			e = a + 6;
			WeekDate.add(a);
			WeekDate.add(b);
			WeekDate.add(c);
			WeekDate.add(d);
			WeekDate.add(e);

			WeekDateValidate.add(week[0] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[1] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[2] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[3] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[4] + " " + yearcurrent + "." + a);

			// WeekDateValidate appVal
			if (WeekDateValidate.equals(appVal)) {
				// print log massgae
			}
		} else if (day.equalsIgnoreCase("Fri")) {
			a = Integer.parseInt(daycurrent) - 4;
			b = a + 4;
			c = a + 5;
			d = a + 6;
			e = a + 7;
			WeekDate.add(a);
			WeekDate.add(b);
			WeekDate.add(c);
			WeekDate.add(d);
			WeekDate.add(e);

			WeekDateValidate.add(week[0] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[1] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[2] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[3] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[4] + " " + yearcurrent + "." + a);

			// WeekDateValidate appVal
			if (WeekDateValidate.equals(appVal)) {
				// print log massgae
			}
		} else if (day.equalsIgnoreCase("Sat")) {
			a = Integer.parseInt(daycurrent) - 5;
			b = a + 5;
			c = a + 6;
			d = a + 7;
			e = a + 8;
			WeekDate.add(a);
			WeekDate.add(b);
			WeekDate.add(c);
			WeekDate.add(d);
			WeekDate.add(e);

			WeekDateValidate.add(week[0] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[1] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[2] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[3] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[4] + " " + yearcurrent + "." + a);

			// WeekDateValidate appVal
			if (WeekDateValidate.equals(appVal)) {
				// print log massgae
			}

		} else if (day.equalsIgnoreCase("Sun")) {
			a = Integer.parseInt(daycurrent) - 6;
			b = a + 6;
			c = a + 7;
			d = a + 8;
			e = a + 9;
			WeekDate.add(a);
			WeekDate.add(b);
			WeekDate.add(c);
			WeekDate.add(d);
			WeekDate.add(e);

			WeekDateValidate.add(week[0] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[1] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[2] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[3] + " " + yearcurrent + "." + a);
			WeekDateValidate.add(week[4] + " " + yearcurrent + "." + a);

			// WeekDateValidate appVal
			if (WeekDateValidate.equals(appVal)) {
				// print log massgae
			}

		}

	}

}
