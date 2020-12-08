package currency.scommettitoreApp.model;

import java.util.HashMap;

public class Metadata {
	
	public static HashMap<String,String> getMetadata(){
		
		HashMap<String,String> hs = new HashMap<String,String>();
		
		hs.put("success", "Restituisce vero o falso a seconda che la tua query abbia esito positivo o negativo. /n Type: Boolean");
		hs.put("timestamp", "Restituisce la data e l'ora esatte (UNIX) in cui sono stati raccolti i tassi di cambio. /n Type: Long");
		hs.put("source", "Restituisce la valuta a cui fanno riferimento tutti i tassi di cambio (USD). /n Type");
		hs.put("quotes","Restituisce tutti i valori dei tassi di cambio, costituiti dalle coppie di valute e dai rispettivi tassi di conversione.");
	
		return hs;
	}
	
}
 