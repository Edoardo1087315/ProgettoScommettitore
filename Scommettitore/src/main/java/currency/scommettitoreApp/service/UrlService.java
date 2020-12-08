package currency.scommettitoreApp.service;

public class UrlService {

	private static final String ACCESS_KEY = "7968aa015692727a80f612c72f809067";
	private static final String BASE_URL = "http://api.currencylayer.com/";
	private static final String ENDPOINT = "historical";

	public static String getUrl(String date,String currencies) {
		return new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + date + "&currencies=" + currencies);
	}
}
