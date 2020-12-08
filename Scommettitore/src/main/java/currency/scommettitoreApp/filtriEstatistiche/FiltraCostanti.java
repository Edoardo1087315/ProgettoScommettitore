package currency.scommettitoreApp.filtriEstatistiche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import currency.scommettitoreApp.model.ValuteCostanti;
import currency.scommettitoreApp.model.ModelloValuta;

public class FiltraCostanti {
	
	
	
	public static ArrayList<ValuteCostanti> Filtra(HashMap<String, ModelloValuta> hs) {
		
		ArrayList<ValuteCostanti> lista = new ArrayList<ValuteCostanti>();
		ValuteCostanti e;
		for (String valuta : hs.keySet()) {
			e = new ValuteCostanti();
			e.setDeviazione_standard(hs.get(valuta).getDeviazione_standard());
			e.setValuta(valuta);
			lista.add(e);
		}
		return lista;
	}
	
	public static ArrayList<ValuteCostanti> migliori(HashMap<String,ModelloValuta> hs, Integer quantita){
		ArrayList<ValuteCostanti> lista = new ArrayList<ValuteCostanti>();
		lista = Filtra(hs);
		lista.sort(Comparator.comparing(ValuteCostanti::getDeviazione_standard));
		return new ArrayList<ValuteCostanti>(lista.subList(0, quantita));
		
	}
	
	public static ArrayList<ValuteCostanti> peggiori(HashMap<String,ModelloValuta> hs, Integer quantita){
		ArrayList<ValuteCostanti> lista = new ArrayList<ValuteCostanti>();
		lista = Filtra(hs);
		lista.sort(Comparator.comparing(ValuteCostanti::getDeviazione_standard).reversed());
		return new ArrayList<ValuteCostanti>(lista.subList(0, quantita));
		
	}
	
}

