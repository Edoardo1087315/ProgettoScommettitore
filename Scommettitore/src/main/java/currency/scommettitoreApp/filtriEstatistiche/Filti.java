package currency.scommettitoreApp.filtriEstatistiche;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import currency.scommettitoreApp.model.ModelloValuta;

public class Filti {
	
	static Vector<Double> v = new Vector<Double>();
	private static Vector<String> q = new Vector<String>();
	
	public static Vector<String> FiltraVarianze(HashMap<String,ModelloValuta> hs2, int ripetizioni) {
		
		Set<String> s = hs2.keySet();
		Double min = 1000000.0;
		String smin;
		do {
		smin=null;
		for(String x : s) {	
			if(hs2.get(x).getVarianza()<min) {
				min=hs2.get(x).getVarianza();
				smin = x;
			}
		}
		q.add(smin);
		s.remove(smin);		
		}while(!((ripetizioni--)==0)); 
	
	return q;
	
}
	public static HashMap<String,Double> VarianzeFiltrate(HashMap<String,ModelloValuta> hs2, int ripetizioni){
		Vector<String> q = new Vector<String>();
		q=FiltraVarianze(hs2,ripetizioni);
		HashMap<String,Double> hs = new HashMap<String,Double>();
		for(String x : q) {
			hs.put(x,hs2.get(x).getVarianza());
		}
		return hs;		
	}

	
	public static void DecodeFilter(String filter) {
		
	}
	
	}
	
	



