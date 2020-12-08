package currency.scommettitoreApp.service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import currency.scommettitoreApp.data.CreateHashMap;
import currency.scommettitoreApp.data.Currencies;
import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.filtersstatistics.BodyParsing;
import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.Metadata;
import currency.scommettitoreApp.plot.Chart;
import currency.scommettitoreApp.model.CurrencyModel;

@org.springframework.stereotype.Service
public class PrincipalService {

	public Vector<String> getCurrencies() throws UrlException {
		return Currencies.getCurrencies();

	}

	public HashMap<String, String> getMetadata() {
		return Metadata.getMetadata();
	}
	
	public HashMap<String,CurrencyModel> getStatistics(String from, String to,String currencies) throws UrlException, DateException, ParseException{
		return CreateHashMap.createHashMap(Currencies.vectorApiModel(from,to,currencies));	
	}
	
	public ArrayList<ConstantCurrencyModel> getFiltered(String from, String to, String filter, String currencies) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, UrlException, DateException, JsonMappingException, JsonProcessingException, ParseException{
		 return BodyParsing.bodyParsing(filter,CreateHashMap.createHashMap(Currencies.vectorApiModel(from, to,currencies)));
	}
	
	public byte[] getChart(String from, String to, String currencies) throws Exception {
		return Chart.lineChart(CreateHashMap.createHashMap(Currencies.vectorApiModel(from, to, currencies)), from, to);
	}
}
