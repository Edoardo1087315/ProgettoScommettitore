package currency.scommettitoreApp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import currency.scommettitoreApp.service.PrincipalService;

@RestController
public class ScommesseController {
	@Autowired
	PrincipalService service;

	@RequestMapping(value = "/valute", method = RequestMethod.GET)
	public ResponseEntity<Object> valute() throws MalformedURLException, IOException {
		return new ResponseEntity<>(service.GetValute(), HttpStatus.OK);
	}

	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> metadata() {
		return new ResponseEntity<>(service.GetMatadata(), HttpStatus.OK);
	}

	@RequestMapping(value = "/valute/statistiche", method = RequestMethod.GET)
	public ResponseEntity<Object> dati(@RequestParam(name = "from", defaultValue = "") String from,
			@RequestParam(name = "to", defaultValue = "") String to) {
		return new ResponseEntity<>(service.GetStatistiche(from, to), HttpStatus.OK);

	}

	@RequestMapping(value = "/valute/filtri", method = RequestMethod.POST)
	public ResponseEntity<Object> filtri(@RequestParam(name = "from", required = true) String from,
			@RequestParam(name = "to", defaultValue = "") String to, @RequestBody String filtro)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException {
		return new ResponseEntity<>(service.GetCostanti(from, to, filtro), HttpStatus.OK);
	}
}