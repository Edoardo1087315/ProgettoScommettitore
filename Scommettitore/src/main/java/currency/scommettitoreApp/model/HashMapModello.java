package currency.scommettitoreApp.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import currency.scommettitoreApp.currencylayer.ApiParsing;
import currency.scommettitoreApp.filtriEstatistiche.Statistiche;

public class HashMapModello {

	public static HashMap<String, ModelloValuta> HashMapValori(Vector<ApiParsing> p) {
		
		HashMap<String, ModelloValuta> hs2 = new HashMap<String, ModelloValuta>();
		Vector<Double> vet;
		Double d;
		ModelloValuta m;
		ApiParsing e = new ApiParsing();

		
		for (String s : p.get(0).quotes.keySet()) {
			Iterator<ApiParsing> it2 = p.iterator();
			vet = new Vector<Double>();
			while (it2.hasNext()) {
				e = it2.next();
				d = e.quotes.get(s);
				vet.add(d);
			}
			m = new ModelloValuta(Statistiche.media(vet), Statistiche.varianza(vet), vet, Statistiche.VariazPercentuale(vet), Statistiche.dev_Standard(vet), Statistiche.VariazPercentualeGiornaliera(vet));
			hs2.put(s, m);

		}
		hs2.remove("USDUSD"); //rimuovo questa conversione poichè inutile
		return hs2;
	}
	
}
