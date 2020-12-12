package currency.scommettitoreApp.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import currency.scommettitoreApp.data.CreateHashMap;
import currency.scommettitoreApp.data.Currencies;
import currency.scommettitoreApp.exceptions.AmountException;
import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.filtersstatistics.BodyParsing;
import currency.scommettitoreApp.model.ConstantCurrencyModel;
import currency.scommettitoreApp.model.Metadata;
import currency.scommettitoreApp.plot.Chart;
import currency.scommettitoreApp.model.CurrencyModel;

@org.springframework.stereotype.Service
public class PrincipalService {

	public Set<String> getCurrencies() throws UrlException, IOException {
		return Currencies.getCurrencies();
	}

	public HashMap<String, String> getMetadata() {
		return Metadata.getMetadata();
	}
	
	public HashMap<String,CurrencyModel> getStatistics(String from, String to,String currencies) throws UrlException, DateException, IOException, ParseException {
		return CreateHashMap.setStatistics(Currencies.vectorApiModel(from,to,currencies));	
	}
	
	public ArrayList<ConstantCurrencyModel> getFiltered(String from, String to, String filter, String currencies) throws NoSuchMethodException, UrlException, DateException, IOException, ParseException, AmountException {
		 return BodyParsing.bodyParsing(filter,CreateHashMap.setStatistics(Currencies.vectorApiModel(from, to,currencies)));
	}
	
	public byte[] getChart(String from, String to, String currencies) throws DateException, UrlException, IOException, ParseException{
		return Chart.lineChart(CreateHashMap.createHashMap(Currencies.vectorApiModel(from, to, currencies)), from, to);
	}
}
