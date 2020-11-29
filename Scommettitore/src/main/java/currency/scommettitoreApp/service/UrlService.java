package currency.scommettitoreApp.service;

public class UrlService {

	public static final String ACCESS_KEY = "1fa966594d9bd93d29cf381308bacbbf";
	public static final String BASE_URL = "http://api.currencylayer.com/";
	public static final String ENDPOINT = "historical";

	public static String geturl(String data,String currencies) {
		return new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + data + "&currencies=" + currencies);
	}
}
