package currency.scommettitoreApp.controller;

import currency.scommettitoreApp.model.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import currency.scommettitoreApp.model.Currencylayer;
import currency.scommettitoreApp.service.PrincipalService;
import currency.scommettitoreApp.service.urlService;


@RestController
public class ScommesseController {
	//@Autowired
	
	
	
	/*@RequestMapping(value = "/live", method = RequestMethod.GET)
	public ResponseEntity<Object> live(@RequestParam (name = "currencies",defaultValue = "") String currencies ) throws ClientProtocolException, IOException {
		return new ResponseEntity<>(Currencylayer.getJson(urlService.geturl(currencies)),HttpStatus.OK);
	} */
	
	@RequestMapping(value ="/storico", method = RequestMethod.GET)
	public ResponseEntity<Object> storico(@RequestParam(name = "from",required=true) String data,@RequestParam(name = "to", required = true) String data2) throws MalformedURLException, IOException{
		return new ResponseEntity<>(Currencylayer.getJson(urlService.geturl(Data.datatostring(data,data2))),HttpStatus.OK);

	}
}

