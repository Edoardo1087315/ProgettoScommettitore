package currency.scommettitoreApp.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import currency.scommettitoreApp.model.ApiModel;
import currency.scommettitoreApp.model.CurrencyModel;

/**
 * Classe che si occupa di creare e popolare la HasMap delle valute
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class CreateHashMap {

	/**
	 * La HashMap che conterrà tutte le valute con i relativi dati
	 */
	
	static private HashMap<String, CurrencyModel> hs;	
	
	/**
	 * Metodo per creare e riempire la HashMap senza le statistiche
	 * @param v Vector di tutti gli ApiModel ottenuti
	 * @return una HashMap String, CurrencyModel popolata senza statistiche
	 */
	
	public static HashMap<String, CurrencyModel> createHashMap(Vector<ApiModel> v) {
		hs = new HashMap<String, CurrencyModel>();
		
		Vector<Double> vet;
		CurrencyModel m;

		for (String s : v.get(0).quotes.keySet()) {   //for each dove ad ogni ciclo cambio valuta
			Iterator<ApiModel> it = v.iterator();
			vet = new Vector<Double>();
			while (it.hasNext()) {
				vet.add(it.next().quotes.get(s));   //inserisco nel vettore tutti i valori assunti dalla valuta nel periodo
			}
			m = new CurrencyModel(vet);
			hs.put(s, m);	//l'hashmap usa come chiavi i nomi delle valute e come valori oggetti di tipo apimodel, le statistiche non sono state calcolate.

		}
		hs.remove("USDUSD"); // rimuovo questa conversione poichè inutile
		return hs;
	}

	/**
	 * Metodo per far calcolare le statistiche nella HashMap
	 * @param v Vector di tutti gli ApiModel ottenuti
	 * @return una HashMap String, CurrencyModel popolata con anche le statistiche
	 */
	
	public static HashMap<String,CurrencyModel> setStatistics(Vector<ApiModel> v){ 
		createHashMap(v);
		for(String s: hs.keySet()) 
			hs.get(s).setStatistics(); //richiamo il metodo setStatistics che mi va a fare il calcolo di tutte le statistiche a partire dai valori delle valute nel periodo
		return hs;
		}
		
	}


	

