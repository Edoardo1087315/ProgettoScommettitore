package currency.scommettitoreApp.filtersstatistics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.CurrencyModel;

public class Filter {
	
	
	
	public static ArrayList<ConstantCurrencyModel> filter(HashMap<String, CurrencyModel> hs) {
		
		ArrayList<ConstantCurrencyModel> list = new ArrayList<ConstantCurrencyModel>();
		ConstantCurrencyModel e;
		for (String currency : hs.keySet()) {
			e = new ConstantCurrencyModel();
			e.setStandard_deviation(hs.get(currency).getStandard_deviation());
			e.setCurrency(currency);
			list.add(e);
		}
		return list;
	}
	
	public static ArrayList<ConstantCurrencyModel> best(HashMap<String,CurrencyModel> hs, Integer amount){
		ArrayList<ConstantCurrencyModel> list = new ArrayList<ConstantCurrencyModel>();
		list = filter(hs);
		list.sort(Comparator.comparing(ConstantCurrencyModel::getStandard_deviation));
		return new ArrayList<ConstantCurrencyModel>(list.subList(0, amount));
		
	}
	
	public static ArrayList<ConstantCurrencyModel> worst(HashMap<String,CurrencyModel> hs, Integer amount){
		ArrayList<ConstantCurrencyModel> list = new ArrayList<ConstantCurrencyModel>();
		list = filter(hs);
		list.sort(Comparator.comparing(ConstantCurrencyModel::getStandard_deviation).reversed());
		return new ArrayList<ConstantCurrencyModel>(list.subList(0, amount));
		
	}
	
}

