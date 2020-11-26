package currency.scommettitoreApp.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import currency.scommettitoreApp.model.Data;

public class urlService {
	
    public static final String ACCESS_KEY = "b984309fa2a83b1bb5161cfad271e36a";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";
    public static final String ENDPOINT2 = "historical";
 
    

    public static String[] geturl(String data[]) {
    	   String get[] = new String[30];
    	long periodo = Data.getPeriodo();
    	
    	for(int i = 0; i<= periodo; i++) {
    	get[i] = new String(BASE_URL + ENDPOINT2 + "?access_key=" + ACCESS_KEY + "&date=" + data[i]);
    	
    }

    	return get;
}
    public static String geturl(String data) {
    	String get;
    	get = new String(BASE_URL + ENDPOINT2 + "?access_key=" + ACCESS_KEY + "&date=" + data);
    	return get;
}
}
