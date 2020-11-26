package currency.scommettitoreApp.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import currency.scommettitoreApp.model.Currencylayer;
import currency.scommettitoreApp.model.Data;

public class PrincipalService {
	
	HashMap
	
	public static HashMap<String,ModelloValuta> CiclaDate(String from, String to) {
		String giorni[] = Data.datatostring(from,to);
		for(String x : giorni) {
			Currencylayer.getJson(urlService.geturl(x));
			
		}
	}
}
