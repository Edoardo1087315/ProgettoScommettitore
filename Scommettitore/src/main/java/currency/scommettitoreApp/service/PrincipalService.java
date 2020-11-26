package currency.scommettitoreApp.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import currency.scommettitoreApp.model.*;

public class PrincipalService {
	
	
	static Vector<ApiParsing> p = new Vector<ApiParsing>();
	static HashMap<String,Vector<ApiParsing>> hs = new HashMap<String,Vector<ApiParsing>>();	
	public static HashMap<String,Vector<ApiParsing>> CiclaDate(String from, String to) {
		String giorni[] = Data.datatostring(from,to);
		for(String x : giorni) {
			try {
				p.add(Currencylayer.getJson(urlService.geturl(x)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hs.put(x,p);
		}
		return hs;
			
		}
	}
