package currency.scommettitoreApp.filtriEstatistiche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import currency.scommettitoreApp.model.Ausiliare;
import currency.scommettitoreApp.model.ModelloValuta;

public class FiltraCostanti {
	

	public static ArrayList<Ausiliare> migliori(HashMap<String, ModelloValuta> hs, Integer quantita, String metodo) {

		ArrayList<Ausiliare> lista = new ArrayList<Ausiliare>();
		Ausiliare e;
		for (String valuta : hs.keySet()) {
			e = new Ausiliare();
			e.setDev_stand(hs.get(valuta).getDeviazione_standard());
			e.setValuta(valuta);
			lista.add(e);
		}
		if (metodo.equals("migliori"))
			lista.sort(Comparator.comparing(Ausiliare::getDev_stand));
		else
			lista.sort(Comparator.comparing(Ausiliare::getDev_stand).reversed());

		return (ArrayList<Ausiliare>) lista.subList(0, quantita);

	}

	
}
