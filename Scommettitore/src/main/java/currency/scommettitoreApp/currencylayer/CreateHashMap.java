package currency.scommettitoreApp.currencylayer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import currency.scommettitoreApp.filtersstatistics.Statistics;
import currency.scommettitoreApp.model.ApiModel;
import currency.scommettitoreApp.model.CurrencyModel;

public class CreateHashMap {

	public static HashMap<String, CurrencyModel> createHashMap(Vector<ApiModel> p) {
		
		HashMap<String, CurrencyModel> hs = new HashMap<String, CurrencyModel>();
		Vector<Double> vet;
		CurrencyModel m;
		ApiModel e = new ApiModel();

		
		for (String s : p.get(0).quotes.keySet()) {
			Iterator<ApiModel> it2 = p.iterator();
			vet = new Vector<Double>();
			while (it2.hasNext()) {
				e = it2.next();
				vet.add(e.quotes.get(s));
			}
			m = new CurrencyModel(vet, Statistics.average(vet), Statistics.variance(vet), Statistics.standardDeviation(vet), Statistics.percentageVariation(vet), Statistics.dailyPercentageVariation(vet));
			hs.put(s, m);

		}
		hs.remove("USDUSD"); //rimuovo questa conversione poichè inutile
		return hs;
	}
	
}
