package currency.scommettitoreApp.filtersstatistics;

import java.util.ArrayList;
import java.util.HashMap;

import java.lang.reflect.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.CurrencyModel;

public class BodyParsing {

	public static ArrayList<ConstantCurrencyModel> bodyParsing(String filter, HashMap<String, CurrencyModel> hs)
			throws JsonMappingException, JsonProcessingException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		HashMap<String, Integer> body = new HashMap<String, Integer>();
		ArrayList<ConstantCurrencyModel> ls = new ArrayList<ConstantCurrencyModel>();
		ObjectMapper obj = new ObjectMapper();

		body = obj.readValue(filter, HashMap.class);

		for (String x : body.keySet()) {
			try {
				Class<?> filterClass = Class.forName("currency.scommettitoreApp.filtersstatistics.Filter");
				Method method = filterClass.getMethod(x, HashMap.class, Integer.class);
				ls.addAll((ArrayList<ConstantCurrencyModel>) method.invoke(filterClass, hs, body.get(x)));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return ls;
	}
}
