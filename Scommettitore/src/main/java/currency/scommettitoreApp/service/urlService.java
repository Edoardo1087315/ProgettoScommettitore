package currency.scommettitoreApp.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class urlService {
	
    public static final String ACCESS_KEY = "61a81621eef28b86edb01f125def3bfb";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";

    public static String geturl(String currencies) {
    	String get = new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&currencies=" + currencies);
    	return get;
    }
	
}
