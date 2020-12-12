package currency.scommettitoreApp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;



import currency.scommettitoreApp.exceptions.DateException;

public class DateService {

	private static final int DAY = (24 * 60 * 60 * 1000);
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private static Date from_date;
	private static Date to_date;		
	
	public static void dateVerify(String from, String to) throws ParseException {
		
		df.setLenient(false);
		
		if (from.equals("") && to.equals("")) {
			to = today();
			from = yesterday();
		} else if (to.equals("")) {
			to = today();
		}
		from_date = df.parse(from);
		to_date = df.parse(to);
		
	}
		

	public static Vector<String> dateRange(String from, String to) throws DateException, ParseException{

		Long period = getPeriod(from, to);
		Vector<String> days = new Vector<String>();

		for (int i = 0; i <= period; i++) {
			days.add(df.format(from_date));
			from_date.setTime((from_date.getTime() + DAY));
		}
		return days;
	}

	public static String today() {
		Date today = new Date();
		return df.format(today);
	}

	public static String yesterday() {
		Date today = new Date();
		return df.format(today.getTime() - DAY);
	}

	public static long getPeriod(String from, String to) throws DateException, ParseException {
		dateVerify(from, to);
		
		if (to_date.before(from_date)) {
			throw new DateException();
		}
		return ((to_date.getTime() - from_date.getTime()) / (DAY));
	}
}
