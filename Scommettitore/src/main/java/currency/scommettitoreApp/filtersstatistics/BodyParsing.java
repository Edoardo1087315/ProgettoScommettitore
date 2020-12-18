package currency.scommettitoreApp.filtersstatistics;

import java.util.ArrayList;
import java.util.HashMap;

import java.lang.reflect.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.exceptions.AmountException;
import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.CurrencyModel;

/**
 * Classe che fa il parsing del body del filtro
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class BodyParsing {

	/**
	 * Metodo che prende il body del filtro, lo decodifica e richiama il metodo per filtrare
	 * @param filter body del filtro richiesto
	 * @param hs la HashMap precedentemente creata e popolata con le valute e le statistiche
	 * @return un ArrayList di ConstantCurrencyModel con le valute filtrate
	 * @throws NoSuchMethodException
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws AmountException
	 * @see currency.scommettitoreApp.filtersstatistics.Filter
	 */
	
	public static ArrayList<ConstantCurrencyModel> bodyParsing(String filter, HashMap<String, CurrencyModel> hs) throws NoSuchMethodException, JsonMappingException, JsonProcessingException, AmountException {

		HashMap<String, Integer> body = new HashMap<String, Integer>(); //HashMap che avrà come chiave i metodi, e come valore intero associato la quantità di valute da filtrare
		ArrayList<ConstantCurrencyModel> ls = new ArrayList<ConstantCurrencyModel>();
		ObjectMapper obj = new ObjectMapper();

			body = obj.readValue(filter, HashMap.class); //faccio il parsing del body inserito dall'utente in formato JSON

		for (String x : body.keySet()) {
			try {
				Class<?> filterClass = Class.forName("currency.scommettitoreApp.filtersstatistics.Filter"); //la classe che contiene i metodi per filtrare
				Method method = filterClass.getMethod(x, HashMap.class, Integer.class); //creo oggetto di tipo method che conterrà il metodo inserito e il valore associato
				if(hs.keySet().size()<body.get(x) || body.get(x)<=0) throw new AmountException(); //eseguo dei controlli sul body inserito
				try {
					ls.addAll((ArrayList<ConstantCurrencyModel>) method.invoke(filterClass.newInstance(), hs, body.get(x))); //invoco il metodo (Es. "best") della classe filterClass passando la Hashmap e la quantità di valute da filtrare
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return ls;
	}
}
