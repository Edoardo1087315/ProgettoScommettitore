package currency.scommettitoreApp.statistiche;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import currency.scommettitoreApp.model.*;

public class statistiche {

	static HashMap<String,ModelloValuta> hs2 = new HashMap<String,ModelloValuta>();
	static Vector<Double> vet;
	public static Double d;
	public static ModelloValuta m;

	public static HashMap<String,ModelloValuta> HashMapValori(Vector<ApiParsing> p) {
		Iterator<ApiParsing> it = p.iterator();
		ApiParsing e = it.next();
		Set<String> x = e.quotes.keySet();

		for (String s : x) {
			Iterator<ApiParsing> it2 = p.iterator();
			vet = new Vector<Double>();
			while (it2.hasNext()) {
				e = it2.next();
				d = e.quotes.get(s);
				vet.add(d);
			}
			m = new ModelloValuta(s,media(vet),varianza(vet),vet);
			hs2.put(s,m);
			
		}
		return hs2;
	}
	
	public static ModelloValuta HashMapValori(ApiParsing p) {
		Set<String> x = p.quotes.keySet();
		
		
		
		
		

		for (String s : x) {
			Iterator<ApiParsing> it2 = p.iterator();
			vet = new Vector<Double>();
			while (it2.hasNext()) {
				e = it2.next();
				d = e.quotes.get(s);
				vet.add(d);
			}
			m = new ModelloValuta(s,media(vet),varianza(vet),vet);
			hs2.put(s,m);
			
		}
		return hs2;
	}


	
	public static double media(Vector<Double> vet) {
		
		double somma=0;
		for(int i=0;i<vet.size();i++) 
			somma += vet.get(i);
		return (double)somma/vet.size();
		 
	}
	
	
	public static double varianza(Vector<Double> vet)
	{
		double m = media(vet);
		double sommaScartiQuad = 0;
		for(int i=0; i<vet.size(); i++)
			sommaScartiQuad += (vet.get(i)-m)*(vet.get(i)-m);
		return sommaScartiQuad/vet.size();
	}
	
	public static double VariazPercentuale(Vector<Double> vet) {
		double variaz_percentuale = 0.0;
		
		variaz_percentuale = ((vet.firstElement()-vet.lastElement())/vet.firstElement())*100;
		return variaz_percentuale;
	}
	
}
