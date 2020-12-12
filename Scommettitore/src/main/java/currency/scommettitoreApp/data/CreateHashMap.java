package currency.scommettitoreApp.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import currency.scommettitoreApp.model.ApiModel;
import currency.scommettitoreApp.model.CurrencyModel;

public class CreateHashMap {

	static HashMap<String, CurrencyModel> hs;	
	
	public static HashMap<String, CurrencyModel> createHashMap(Vector<ApiModel> v) {
		hs = new HashMap<String, CurrencyModel>();
		
		Vector<Double> vet;
		CurrencyModel m;

		for (String s : v.get(0).quotes.keySet()) {
			Iterator<ApiModel> it = v.iterator();
			vet = new Vector<Double>();
			while (it.hasNext()) {
				vet.add(it.next().quotes.get(s));
			}
			m = new CurrencyModel(vet);
			hs.put(s, m);

		}
		hs.remove("USDUSD"); // rimuovo questa conversione poichè inutile
		return hs;
	}

	public static HashMap<String,CurrencyModel> setStatistics(Vector<ApiModel> v){ 
		createHashMap(v);
		for(String s: hs.keySet()) 
			hs.get(s).setStatistics();
		return hs;
		}
		
	}


	

