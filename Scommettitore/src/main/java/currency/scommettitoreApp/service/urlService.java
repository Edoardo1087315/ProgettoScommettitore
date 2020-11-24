package currency.scommettitoreApp.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import currency.scommettitoreApp.model.Data;

public class urlService {
	
    public static final String ACCESS_KEY = "61a81621eef28b86edb01f125def3bfb";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";
    public static final String ENDPOINT2 = "historical";
    public static String get[] = new String[30];
    

    public static String[] geturl(String data[]) {
    	
    	long periodo = Data.getPeriodo();
    	
    	for(int i = 0; i<= periodo; i++) {
    	get[i] = new String(BASE_URL + ENDPOINT2 + "?access_key=" + ACCESS_KEY + "&date=" + data[i]);
    	
    }

    	return get;
}
}
