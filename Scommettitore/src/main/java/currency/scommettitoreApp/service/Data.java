package currency.scommettitoreApp.service;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Data {

	static long periodo = 0;
	static final int DAY = (24*60*60*1000);
	static final int MAX = 30;

	public static Vector<String> DateRange(String data1, String data2) {

		Date date1 = null;
		Date date2 = null;
		
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		
		periodo = ((date2.getTime() - date1.getTime()) / (DAY));

		Vector<String> giorni = new Vector<String>();
		Calendar c = Calendar.getInstance();
		c.setTime(date1);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		
		for (int i = 0; i <= periodo; i++) {
			giorni.add(df.format(date1));
			date1.setTime((date1.getTime() + DAY));			
		}
		return giorni;
	}

	public static long GetPeriodo() {
		return periodo;

}
	public static String DataOdierna() {
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format( oggi );
	}
	public static String ieri() {
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(oggi.getTime()-DAY);
	}
	
}
