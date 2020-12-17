package currency.scommettitoreApp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import currency.scommettitoreApp.exceptions.AmountException;
import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.exceptions.ExceptionErr;
import currency.scommettitoreApp.exceptions.GenericError;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.service.PrincipalService;

/**
 * Classe Controller che gestisce le richieste da parte dell'utente
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

@RestController
public class Controller {
	@Autowired
	PrincipalService service;

	/**
	 * Metodo che gestisce la GET nella rotta "/currencies"
	 * @return un Set di String con l'elenco delle valute
	 * @throws UrlException se si verifica un problema nella connessione al sito
	 * @throws IOException se si verifica un problema di I/O
	 */
	
	@RequestMapping(value = "/currencies", method = RequestMethod.GET)
	public ResponseEntity<Object> getCurrencies() throws UrlException, IOException {
		return new ResponseEntity<>(service.getCurrencies(), HttpStatus.OK);
	}

	/**
	 * Metodo che gestisce la GET nella rotta "/currencies/metadata"
	 * @return una HasMap String String contenente i metadata
	 */
	
	@RequestMapping(value = "/currencies/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		return new ResponseEntity<>(service.getMetadata(), HttpStatus.OK);
	}

	/**
	 * Metodo che gestisce la GET nella rotta "/currencies/statistics"
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @param currencies elenco delle valute richieste
	 * @return una HasMap di String, CurrencyModel contenente le valute con le rispettive statistiche
	 * @throws UrlException se si verifica un problema nella connessione al sito
	 * @throws DateException se la data di inizio inserita eccede quella di fine
	 * @throws IOException se si verifica un problema di I/O
	 * @throws ParseException se le date sono state inserite in maniera sbagliata
	 */
	
	@RequestMapping(value = "/currencies/statistics", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatistics(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to,
			@RequestParam(name = "currencies", defaultValue = "") String currencies) throws UrlException, DateException, IOException, ParseException {
		return new ResponseEntity<>(service.getStatistics(from, to, currencies), HttpStatus.OK);

	}

	/**
	 * Metodo che gestisce la GET nella rotta "/currencies/filters"
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @param currencies elenco delle valute richieste
	 * @param filter body del filtro richiesto
	 * @return un ArrayList di ConstantCurrencyModel contenente le valute filtrate
	 * @throws NoSuchMethodException se il filtro viene inserito in maniera non corretta
	 * @throws UrlException se si verifica un problema nella connessione al sito
	 * @throws DateException se la data di inizio inserita eccede quella di fine
	 * @throws IOException se si verifica un problema di I/O
	 * @throws ParseException se le date sono state inserite in maniera sbagliata
	 * @throws AmountException se la quantità nel filtro eccede il numero di valute richieste
	 */
	
	@RequestMapping(value = "/currencies/filters", method = RequestMethod.POST)
	public ResponseEntity<Object> getFiltered(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to,
			@RequestParam(name = "currencies", defaultValue = "") String currencies, @RequestBody String filter) throws NoSuchMethodException, UrlException, DateException, IOException, ParseException, AmountException {
		return new ResponseEntity<>(service.getFiltered(from, to, filter, currencies), HttpStatus.OK);
	}

	/**
	 * 
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @param currencies elenco delle valute richieste
	 * @return un vettore di byte che visualizza il grafico
	 * @throws UrlException se si verifica un problema nella connessione al sito
	 * @throws DateException se la data di inizio inserita eccede quella di fine
	 * @throws IOException se si verifica un problema di I/O
	 * @throws ParseException se le date sono state inserite in maniera sbagliata
	 */
	
	@RequestMapping(value = "/currencies/chart", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getChart(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to,
			@RequestParam(name = "currencies", defaultValue = "EUR") String currencies)
			throws UrlException, DateException, IOException, ParseException{

		return ResponseEntity.status(HttpStatus.OK).contentType(org.springframework.http.MediaType.IMAGE_PNG)
				.body(service.getChart(from, to, currencies));
	}

	/**
	 * Metodo per gestire la NoSuchMethodException
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<Object> handleNoSuchMethodException(NoSuchMethodException e) {
		ExceptionErr error = new ExceptionErr(new Date(), HttpStatus.BAD_REQUEST, e.getClass().getCanonicalName(),
				"Controlla di aver utilizzato i metodi disponibili");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Metodo per gestire la JsonProcessingException
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	
	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<Object> handleJsonProcessingException(JsonProcessingException e) {
		ExceptionErr error = new ExceptionErr(new Date(), HttpStatus.BAD_REQUEST, e.getClass().getCanonicalName(),
				"Controlla di aver scritto correttamente il body");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Metodo per gestire la ParseException
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	
	@ExceptionHandler(ParseException.class)
	public ResponseEntity<Object> handleParseException(ParseException e) {
		ExceptionErr error = new ExceptionErr(new Date(), HttpStatus.BAD_REQUEST, e.getClass().getCanonicalName(),
				"Controlla di aver immesso le date come richiesto");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Metodo per gestire la IOException
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> handleIOException(IOException e) {
		ExceptionErr error = new ExceptionErr(new Date(), HttpStatus.BAD_REQUEST, e.getClass().getCanonicalName(),
				"Problemi di I/O nel collegamento a currencyLayer");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Metodo per gestire le eccezioni personalizzate
	 * @param e eccezione da gestire
	 * @return oggetto di tipo ExceptionError
	 */
	
	@ExceptionHandler(GenericError.class)
	public ResponseEntity<Object> handleGenericError(GenericError e) {
		ExceptionErr error = new ExceptionErr(new Date(), HttpStatus.BAD_REQUEST, e.getClass().getCanonicalName(),
				e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
