package currency.scommettitoreApp.currencylayer;

import java.io.IOException;
import java.util.Vector;

import currency.scommettitoreApp.service.Data;
import currency.scommettitoreApp.service.UrlService;

public class Valute {

	public static Vector<String> GetStringsValute(){
	
	ApiParsing p = new ApiParsing();
		
	try {
		p = Currencylayer.GetJsonAndDecode(UrlService.geturl(Data.DataOdierna(), ""));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	Vector<String> vet = new Vector<String>();
	vet.addAll(p.quotes.keySet());
	return vet;
}
}
