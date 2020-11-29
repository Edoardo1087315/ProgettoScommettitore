package currency.scommettitoreApp.filtriEstatistiche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import currency.scommettitoreApp.model.Ausiliare;
import currency.scommettitoreApp.model.ModelloValuta;

public class FiltraCostanti {
	
	
	
	public static ArrayList<Ausiliare> Filtra(HashMap<String, ModelloValuta> hs) {
		
		ArrayList<Ausiliare> lista = new ArrayList<Ausiliare>();
		Ausiliare e;
		for (String valuta : hs.keySet()) {
			e = new Ausiliare();
			e.setDeviazione_standard(hs.get(valuta).getDeviazione_standard());
			e.setValuta(valuta);
			lista.add(e);
		}
		return lista;
	}
	
	public static ArrayList<Ausiliare> migliori(HashMap<String,ModelloValuta> hs, Integer quantita){
		ArrayList<Ausiliare> lista = new ArrayList<Ausiliare>();
		lista = Filtra(hs);
		lista.sort(Comparator.comparing(Ausiliare::getDeviazione_standard));
		return new ArrayList<Ausiliare>(lista.subList(0, quantita));
		
	}
	
	public static ArrayList<Ausiliare> peggiori(HashMap<String,ModelloValuta> hs, Integer quantita){
		ArrayList<Ausiliare> lista = new ArrayList<Ausiliare>();
		lista = Filtra(hs);
		lista.sort(Comparator.comparing(Ausiliare::getDeviazione_standard).reversed());
		return new ArrayList<Ausiliare>(lista.subList(0, quantita));
		
	}
	
}

