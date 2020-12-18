package currency.scommettitoreApp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;



import currency.scommettitoreApp.exceptions.DateException;

/**
 * Classe che opera e gestisce le date
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class DateService {

	/**
	 * Valore che corrisponde ad un giorno nel DateFormat
	 * DAY Valore costante :{@value}
	 */
	
	private static final int DAY = (24 * 60 * 60 * 1000);
	
	/**
	 * DateFormat per il parsing della data
	 */
	
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Data di inzio
	 */
	
	private static Date from_date;
	
	/**
	 * Data di fine
	 */
	
	private static Date to_date;		
	
	/**
	 * Metodo che auto-genera le date se non sono state inserite dall'utente
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @throws ParseException
	 */
	
	public static void dateVerify(String from, String to) throws ParseException {
		
		df.setLenient(false); //con questo comando l'oggetto df non sarà clemente sul parse che dovrà fare della stringa, se la stringa non è scritta come da sintassi chiama l'eccezione ParseException
		
		if (from.equals("") && to.equals("")) {
			to = today();
			from = yesterday();
		} else if (to.equals("")) {
			to = today();
		}
		from_date = df.parse(from);
		to_date = df.parse(to);
		
	}

	/**
	 * Metodo che genera tutte le date comprese nel periodo e le inserisce in un vettore 
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @return un Vector di String con tutte le date del periodo
	 * @throws DateException
	 * @throws ParseException
	 */
	
	public static Vector<String> dateRange(String from, String to) throws DateException, ParseException{

		Long period = getPeriod(from, to);
		Vector<String> days = new Vector<String>();

		for (int i = 0; i <= period; i++) {					
			days.add(df.format(from_date));
			from_date.setTime((from_date.getTime() + DAY));
		}
		return days;
	}

	
	/**
	 * Metodo che genera la data odierna
	 * @return una String con la data odierna
	 */
	
	public static String today() {
		Date today = new Date();
		return df.format(today);
	}

	/**
	 * Metodo che genera la data di ieri
	 * @return una String con la data di ieri
	 */
	
	public static String yesterday() {
		Date today = new Date();
		return df.format(today.getTime() - DAY);
	}

	/**
	 * Metodo che calcola la lunghezza del periodo 
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @return un long che rappresenta la lunghezza del periodo
	 * @throws DateException
	 * @throws ParseException
	 */
	
	public static long getPeriod(String from, String to) throws DateException, ParseException {
		dateVerify(from, to);
		
		if (to_date.before(from_date)) {
			throw new DateException();
		}
		return ((to_date.getTime() - from_date.getTime()) / (DAY));
	}
}
