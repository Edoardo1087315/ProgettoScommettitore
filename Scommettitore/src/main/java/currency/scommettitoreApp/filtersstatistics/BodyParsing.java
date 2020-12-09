package currency.scommettitoreApp.filtersstatistics;

import java.util.ArrayList;
import java.util.HashMap;

import java.lang.reflect.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.CurrencyModel;

public class BodyParsing {

	public static ArrayList<ConstantCurrencyModel> bodyParsing(String filter, HashMap<String, CurrencyModel> hs) throws NoSuchMethodException {

		HashMap<String, Integer> body = new HashMap<String, Integer>();
		ArrayList<ConstantCurrencyModel> ls = new ArrayList<ConstantCurrencyModel>();
		ObjectMapper obj = new ObjectMapper();

		try {
			body = obj.readValue(filter, HashMap.class);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		for (String x : body.keySet()) {
			try {
				Class<?> filterClass = Class.forName("currency.scommettitoreApp.filtersstatistics.Filter");
				Method method = filterClass.getMethod(x, HashMap.class, Integer.class);
				try {
					ls.addAll((ArrayList<ConstantCurrencyModel>) method.invoke(filterClass.newInstance(), hs, body.get(x)));
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return ls;
	}
}
