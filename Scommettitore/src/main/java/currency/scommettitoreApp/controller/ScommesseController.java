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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import currency.scommettitoreApp.model.Currencylayer;
import currency.scommettitoreApp.service.PrincipalService;
import currency.scommettitoreApp.service.urlService;
import currency.scommettitoreApp.statistiche.Filti;
import currency.scommettitoreApp.statistiche.statistiche;


@RestController
public class ScommesseController {
	//@Autowired
	
	@RequestMapping(value ="/storico", method = RequestMethod.GET)
	public ResponseEntity<Object> storico(@RequestParam(name = "from",required=true) String data,@RequestParam(name = "to", required = true) String data2) throws MalformedURLException, IOException{
		return new ResponseEntity<>(statistiche.HashMapValori(Currencylayer.getJson(urlService.geturl(Data.datatostring(data,data2)))),HttpStatus.OK);

	}
	@RequestMapping(value ="/storico2", method = RequestMethod.GET)
	public ResponseEntity<Object> storico2(@RequestParam(name = "from",required=true) String data,@RequestParam(name = "to", required = true) String data2,@RequestParam(name = "ripetizioni", required = true)int ripetizioni) throws MalformedURLException, IOException{
		return new ResponseEntity<>(Filti.VarianzeFiltrate(statistiche.HashMapValori(Currencylayer.getJson(urlService.geturl(Data.datatostring(data,data2)))),ripetizioni),HttpStatus.OK);

	
	
	@RequestMapping(value ="/valute", method = RequestMethod.GET)
	public ResponseEntity<Object> valute(){
	return new ResponseEntity<>(Currencylayer.getJson(urlService.geturl(Data.dataOdierna())));
	}
	
	
	
	@RequestMapping(value = "/valute/dati",method = RequestMethod.GET)
	public ResponseEntity<Object> dati(@RequestParam(name = "from",required=true) String data,@RequestParam(name = "to", required = true) String data2){
	return new ResponseEntity<>(PrincipalService.CiclaDate(data,data2));
}
	}