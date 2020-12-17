package currency.scommettitoreApp.filtersstatistics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.CurrencyModel;

/**
 * Metodo che si occupa di filtrare le valute
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class Filter {
	
	/**
	 * Lista che contiene le valute filtrate
	 */
	
	static ArrayList<ConstantCurrencyModel> list;

	/**
	 * Metodo che crea e popola la lista con tutte le ConstantCurrencyModel da filtrare
	 * @param hs la HashMap precedentemente creata e popolata con tutte le valute
	 * @return un ArrayList di ConstantCurrencyModel
	 */
	
	public static ArrayList<ConstantCurrencyModel> filter(HashMap<String, CurrencyModel> hs) {
		list = new ArrayList<ConstantCurrencyModel>();
		ConstantCurrencyModel e;
		for (String currency : hs.keySet()) {
			e = new ConstantCurrencyModel();
			e.setStandard_deviation(hs.get(currency).getStandard_deviation());
			e.setCurrency(currency);
			list.add(e);
		}
		return list;
	}

	/**
	 * Metodo che filtra le migliori valute
	 * @param hs la HashMap precedentemente creata e popolata con tutte le valute
	 * @param amount la quantità di valute filtrate richiesta dall'utente
	 * @return un ArrayList delle ConstantCurrencyModel filtrate
	 */
	
	public static ArrayList<ConstantCurrencyModel> best(HashMap<String, CurrencyModel> hs, Integer amount) {
		list = filter(hs);
		list.sort(Comparator.comparing(ConstantCurrencyModel::getStandard_deviation));
		return new ArrayList<ConstantCurrencyModel>(list.subList(0, amount));

	}

	/**
	 * Metodo che filtra le peggiori valute
	 * @param hs la HashMap precedentemente creata e popolata con tutte le valute
	 * @param amount la quantità di valute filtrate richiesta dall'utente
	 * @return un ArrayList delle ConstantCurrencyModel filtrate
	 */
	
	public static ArrayList<ConstantCurrencyModel> worst(HashMap<String, CurrencyModel> hs, Integer amount) {
		list = filter(hs);
		list.sort(Comparator.comparing(ConstantCurrencyModel::getStandard_deviation).reversed());
		return new ArrayList<ConstantCurrencyModel>(list.subList(0, amount));

	}

}
