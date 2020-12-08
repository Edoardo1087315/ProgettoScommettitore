package currency.scommettitoreApp.model;

import java.util.HashMap;

public class Metadata {
	
	public static HashMap<String,String> getMetadata(){
		
		HashMap<String,String> hs = new HashMap<String,String>();
		
		hs.put("values", "Contiene i valori della valuta in ordine nelle giornate richieste (dal meno recente al più recente).   Type: Vector<Double>");
		hs.put("average", "Contiene il valore medio dei valori della valuta nel periodo scelto.   Type: Double");
		hs.put("variance", "Contiene la varianza dei valori della valuta nel periodo scelto.   Type: Double");
		hs.put("standard_deviation","Contiene la deviazione standard dei valori della valuta nel periodo scelto (Indice di volatilità).   Type: Double");
		hs.put("percentage_variation","Contiene la variazione percentuale dei valori della valuta nel periodo scelto.   Type: Double");
		hs.put("daily_percentage_variation","Contiene le variazioni percentuali giornaliere dei valori della valuta nel perido scelto.   Type: Vector<Double>");

		return hs;
	}
	
}
 