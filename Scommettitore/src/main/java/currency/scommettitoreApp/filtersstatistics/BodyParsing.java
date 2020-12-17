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

		HashMap<String, Integer> body = new HashMap<String, Integer>();
		ArrayList<ConstantCurrencyModel> ls = new ArrayList<ConstantCurrencyModel>();
		ObjectMapper obj = new ObjectMapper();

			body = obj.readValue(filter, HashMap.class);

		for (String x : body.keySet()) {
			try {
				Class<?> filterClass = Class.forName("currency.scommettitoreApp.filtersstatistics.Filter");
				Method method = filterClass.getMethod(x, HashMap.class, Integer.class);
				if(hs.keySet().size()<body.get(x) || body.get(x)<=0) throw new AmountException();
				try {
					ls.addAll((ArrayList<ConstantCurrencyModel>) method.invoke(filterClass.newInstance(), hs, body.get(x)));
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
