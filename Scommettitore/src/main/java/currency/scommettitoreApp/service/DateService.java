package currency.scommettitoreApp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import currency.scommettitoreApp.exceptions.DateException;

public class DateService{

	static final int DAY = (24 * 60 * 60 * 1000);

	static Date from_date;
	static Date to_date;
	

	public static void dateVerify(String from, String to) throws ParseException {

		if (from.equals("") && to.equals("")) {
			to = today();
			from = yesterday();
		} else if (to.equals("")) {
			to = today();
		}
		from_date = new SimpleDateFormat("yyyy-MM-dd").parse(from);
		to_date = new SimpleDateFormat("yyyy-MM-dd").parse(to);

	}

	public static Vector<String> dateRange(String from, String to) throws DateException, ParseException {

		Long period = getPeriod(from,to);

		Vector<String> days = new Vector<String>();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i <= period; i++) {
			days.add(df.format(from_date));
			from_date.setTime((from_date.getTime() + DAY));
		}
		return days;
	}


	public static String today() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(today);
	}

	public static String yesterday() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(today.getTime() - DAY);
	}

	public static long getPeriod(String from,String to) throws DateException, ParseException {
		dateVerify(from,to);
		if(to_date.getTime()-from_date.getTime() <= 0) {
			throw new DateException();
		}
		return ((to_date.getTime() - from_date.getTime()) / (DAY));
	}
}
