package currency.scommettitoreApp.service;

public class UrlService {

	public static final String ACCESS_KEY = "7968aa015692727a80f612c72f809067";
	public static final String BASE_URL = "http://api.currencylayer.com/";
	public static final String ENDPOINT = "historical";

	public static String geturl(String date,String currencies) {
		return new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + date + "&currencies=" + currencies);
	}
}
