package currency.scommettitoreApp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
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
import com.fasterxml.jackson.databind.JsonMappingException;

import currency.scommettitoreApp.exceptions.DataException;
import currency.scommettitoreApp.exceptions.ExceptionErr;
import currency.scommettitoreApp.exceptions.GenericError;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.service.PrincipalService;

@RestController
public class Controller {
	@Autowired
	PrincipalService service;

	@RequestMapping(value = "/valute", method = RequestMethod.GET)
	public ResponseEntity<Object> getValute() throws MalformedURLException, IOException, UrlException {
		return new ResponseEntity<>(service.GetValute(), HttpStatus.OK);
	}

	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		return new ResponseEntity<>(service.GetMetadata(), HttpStatus.OK);
	}

	@RequestMapping(value = "/valute/statistiche", method = RequestMethod.GET)
	public ResponseEntity<Object> getStatistiche(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to,@RequestParam(name = "currencies", defaultValue = "") String currencies) throws UrlException, DataException {
		return new ResponseEntity<>(service.GetStatistiche(from, to,currencies), HttpStatus.OK);

	}

	@RequestMapping(value = "/valute/filtri", method = RequestMethod.POST)
	public ResponseEntity<Object> getFiltri(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to, @RequestParam(name = "currencies", defaultValue = "") String currencies, @RequestBody String filtro)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException, UrlException, DataException, JsonMappingException, JsonProcessingException {
		return new ResponseEntity<>(service.GetCostanti(from, to, filtro,currencies), HttpStatus.OK);
	}

	@RequestMapping(value = "/valute/grafico", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getGrafico(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to, @RequestParam(name = "currencies", defaultValue = "EUR") String currencies) throws Exception {
		
		return ResponseEntity.status(HttpStatus.OK)
			.contentType(org.springframework.http.MediaType.IMAGE_PNG)
            .body(service.GetGrafico(from, to, currencies));
	}
            
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<Object> handleNoSuchMethodException(NoSuchMethodException e) {
		ExceptionErr error = new ExceptionErr(new Date(), HttpStatus.BAD_REQUEST , e.getClass().getCanonicalName() ,"Controlla di aver utilizzato i metodi disponibili");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<Object> handleJsonProcessingException(JsonProcessingException e){
		ExceptionErr error = new ExceptionErr(new Date(),HttpStatus.BAD_REQUEST, e.getClass().getCanonicalName(),"Controlla di aver scritto correttamente il body");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GenericError.class)
	public ResponseEntity<Object> handleGenericError(GenericError e){
		ExceptionErr error = new ExceptionErr(new Date(), HttpStatus.BAD_REQUEST, e.getClass().getCanonicalName() , e.GetMessaggio());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
	