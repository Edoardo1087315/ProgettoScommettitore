package currency.scommettitoreApp.data;

import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.model.ApiModel;
import currency.scommettitoreApp.service.*;

public class Currencies {

	public static Vector<String> getCurrencies() throws UrlException, IOException {

		ApiModel p = new ApiModel();

		p = Currencylayer.getJsonAndDecode(UrlService.getUrl(DateService.today(), ""));

		Vector<String> vet = new Vector<String>();
		vet.addAll(p.quotes.keySet());
		return vet;
	}

	public static Vector<ApiModel> vectorApiModel(String from, String to, String currencies)
			throws UrlException, IOException, DateException, ParseException{

		Vector<ApiModel> p = new Vector<ApiModel>();

		Vector<String> days = DateService.dateRange(from, to);
		for (String day : days) {
			p.add(Currencylayer.getJsonAndDecode(UrlService.getUrl(day, currencies)));
		}
		return p;
	}

}
