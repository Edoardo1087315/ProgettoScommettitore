package currency.scommettitoreApp.service;

public class UrlService {

	public static final String ACCESS_KEY = "b984309fa2a83b1bb5161cfad271e36a";
	public static final String BASE_URL = "http://api.currencylayer.com/";
	public static final String ENDPOINT = "historical";

	public static String geturl(String data) {
		String get;
		get = new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + data);
		return get;
	}
}
