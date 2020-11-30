package currency.scommettitoreApp.service;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import currency.scommettitoreApp.currencylayer.ApiParsing;
import currency.scommettitoreApp.currencylayer.Currencylayer;

public class Data {

	static final int DAY = (24 * 60 * 60 * 1000);

	static Date date1;
	static Date date2;

	public static void DateVerify(String from, String to) {

		if (from.equals("") && to.equals("")) {
			to = Data.DataOdierna();
			from = Data.DataIeri();
		} else if (to.equals("")) {
			to = Data.DataOdierna();
		}
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(from);
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(to);
		} catch (ParseException e) {
			e.printStackTrace();

		}
	}

	public static Vector<String> DateRange(String from, String to) {
		long periodo = 0;
		date1 = new Date();
		date2 = new Date();

		DateVerify(from, to);

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

	public static Vector<ApiParsing> CiclaDate(String from, String to, String currencies) {

		Vector<ApiParsing> p = new Vector<ApiParsing>();

		DateVerify(from, to);

		Vector<String> giorni = Data.DateRange(from, to);
		for (String x : giorni) {
			try {
				p.add(Currencylayer.GetJsonAndDecode(UrlService.geturl(x, currencies)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	public static String DataOdierna() {
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(oggi);
	}

	public static String DataIeri() {
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(oggi.getTime() - DAY);
	}

	public static long getPeriodo(String from, String to) {

		return ((date2.getTime() - date1.getTime()) / (DAY));
	}
}
