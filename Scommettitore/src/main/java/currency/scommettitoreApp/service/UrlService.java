package currency.scommettitoreApp.service;

public class UrlService {

	private static final String ACCESS_KEY = "0533f14c0a3ce40e6a6766be7b2f54e1";
	private static final String BASE_URL = "http://api.currencylayer.com/";
	private static final String ENDPOINT = "historical";

	public static String getUrl(String date,String currencies) {
		return new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + date + "&currencies=" + currencies);
	}
}
