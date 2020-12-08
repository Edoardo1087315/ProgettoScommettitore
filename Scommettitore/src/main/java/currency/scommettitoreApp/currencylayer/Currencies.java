package currency.scommettitoreApp.currencylayer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.model.ApiModel;
import currency.scommettitoreApp.service.*;

public class Currencies {

	public static Vector<String> getCurrencies() throws UrlException{
	
	ApiModel p = new ApiModel();
		
	try {
		p = Currencylayer.getJsonAndDecode(UrlService.geturl(DateService.today(), ""));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	Vector<String> vet = new Vector<String>();
	vet.addAll(p.quotes.keySet());
	return vet;
}
	
	public static Vector<ApiModel> vectorApiModel(String from, String to, String currencies) throws UrlException, DateException, ParseException {

		Vector<ApiModel> p = new Vector<ApiModel>();

		Vector<String> days = DateService.dateRange(from, to);
		for (String day : days) {
			try {
				p.add(Currencylayer.getJsonAndDecode(UrlService.geturl(day, currencies)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

}
