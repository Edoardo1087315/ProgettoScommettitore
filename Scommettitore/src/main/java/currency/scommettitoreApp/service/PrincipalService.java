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

/**
 * Service principale
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

@org.springframework.stereotype.Service
public class PrincipalService {

	/**
	 * Metodo che ottiene la lista delle valute
	 * @return un Set di String contenente le valute
	 * @throws UrlException 
	 * @throws IOException
	 * @see currency.scommettitoreApp.data.Currencies
	 */
	
	public Set<String> getCurrencies() throws UrlException, IOException {
		return Currencies.getCurrencies();
	}

	/**
	 * Metodo che ottiene i metadata
	 * @return una HasMap String, String contenente i metadata
	 * @see currency.scommettitoreApp.model.Metadata
	 */
	
	public HashMap<String, String> getMetadata() {
		return Metadata.getMetadata();
	}
	
	/**
	 * Metodo che ottiene le statistiche
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @param currencies elenco delle valute richieste
	 * @return una HashMap String, CurrencyModel contenente le valute con le rispettive statistiche
	 * @throws UrlException
	 * @throws DateException
	 * @throws IOException
	 * @throws ParseException
	 * @see currency.scommettitoreApp.data.CreateHashMap
	 * @see currency.scommettitoreApp.data.Currencies
	 */
	
	public HashMap<String,CurrencyModel> getStatistics(String from, String to,String currencies) throws UrlException, DateException, IOException, ParseException {
		return CreateHashMap.setStatistics(Currencies.vectorApiModel(from,to,currencies));	
	}
	
	/**
	 * Metodo che ottiene le valute filtrate
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @param filter body del filtro richiesto
	 * @param currencies elenco delle valute richieste
	 * @return un ArrayList di ConstantCurrencyModel contenente le valute filtrate
	 * @throws NoSuchMethodException
	 * @throws UrlException
	 * @throws DateException
	 * @throws IOException
	 * @throws ParseException
	 * @throws AmountException
	 * @see currency.scommettitoreApp.filtersstatistics.BodyParsing
	 * @see currency.scommettitoreApp.data.CreateHashMap
	 * @see currency.scommettitoreApp.data.Currencies
	 */
	
	public ArrayList<ConstantCurrencyModel> getFiltered(String from, String to, String filter, String currencies) throws NoSuchMethodException, UrlException, DateException, IOException, ParseException, AmountException {
		 return BodyParsing.bodyParsing(filter,CreateHashMap.setStatistics(Currencies.vectorApiModel(from, to,currencies)));
	}
	
	/**
	 * Metodo che ottiene il grafico
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @param currencies elenco delle valute richieste
	 * @return un vettore di byte che visualizza il grafico
	 * @throws DateException
	 * @throws UrlException
	 * @throws IOException
	 * @throws ParseException
	 * @see currency.scommettitoreApp.data.CreateHashMap
	 * @see currency.scommettitoreApp.data.Currencies
	 * @see currency.scommettitoreApp.plot.Chart
	 */
	
	public byte[] getChart(String from, String to, String currencies) throws DateException, UrlException, IOException, ParseException{
		return Chart.lineChart(CreateHashMap.createHashMap(Currencies.vectorApiModel(from, to, currencies)), from, to);
	}
}
