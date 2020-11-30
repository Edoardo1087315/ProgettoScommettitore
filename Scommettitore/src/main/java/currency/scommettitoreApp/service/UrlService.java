package currency.scommettitoreApp.service;

public class UrlService {

	public static final String ACCESS_KEY = "d0e7418d127b03bec0f0de1309ece7e0";
	public static final String BASE_URL = "http://api.currencylayer.com/";
	public static final String ENDPOINT = "historical";

	public static String geturl(String data,String currencies) {
		return new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + data + "&currencies=" + currencies);
	}
}
