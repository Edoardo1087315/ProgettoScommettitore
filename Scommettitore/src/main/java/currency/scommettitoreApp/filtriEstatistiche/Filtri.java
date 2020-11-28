package currency.scommettitoreApp.filtriEstatistiche;

import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.model.Ausiliare;
import currency.scommettitoreApp.model.ModelloFiltro;
import currency.scommettitoreApp.model.ModelloValuta;

public class Filtri {

	public static java.util.List<Ausiliare> filtri(String filtro,HashMap<String,ModelloValuta> hs) {
		
		ModelloFiltro e = new ModelloFiltro();
		
		ObjectMapper obj = new ObjectMapper();
		
		try {
			e = obj.readValue(filtro, ModelloFiltro.class);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		if(e.migliori.equals("migliori")) {
			return ValuteCostanti(hs,e.quantita,e.migliori);
		}
		else if(e.migliori.equals("peggiori")) {
			return ValuteCostanti(hs,e.quantita,e.migliori);
		}
		else
			System.out.println("metodo sbagliato");
		return null;
	}
	
	
	

	public static java.util.List<Ausiliare> ValuteCostanti(HashMap<String, ModelloValuta> hs, int quantita,
			String metodo) {

		ArrayList<Ausiliare> lista = new ArrayList<Ausiliare>();
		Ausiliare e;
		for (String valuta : hs.keySet()) {
			e = new Ausiliare();
			e.setDev_stand(hs.get(valuta).getDeviazione_standard());
			e.setValuta(valuta);
			lista.add(e);
		}
		if (metodo.equals("migliore"))
			lista.sort(Comparator.comparing(Ausiliare::getDev_stand));
		else
			lista.sort(Comparator.comparing(Ausiliare::getDev_stand).reversed());

		return lista.subList(0, quantita);

	}


}
