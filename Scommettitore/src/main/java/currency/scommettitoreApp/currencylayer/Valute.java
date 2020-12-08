package currency.scommettitoreApp.currencylayer;

import java.io.IOException;
import java.util.Vector;				

import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.service.DataService;
import currency.scommettitoreApp.service.UrlService;

public class Valute {

	public static Vector<String> GetStringsValute() throws UrlException{
	
	ApiParsing p = new ApiParsing();
		
	try {
		p = Currencylayer.GetJsonAndDecode(UrlService.geturl(DataService.DataOdierna(), ""));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	Vector<String> vet = new Vector<String>();
	vet.addAll(p.quotes.keySet());
	return vet;
}
}
