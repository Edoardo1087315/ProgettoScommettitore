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

public class PrincipalService {
	
	static CloseableHttpClient httpClient = HttpClients.createDefault();
	
	public static JSONObject LiveRequest(HttpUriRequest url) throws ClientProtocolException, IOException {
        CloseableHttpResponse response =  httpClient.execute(url);
        HttpEntity entity = response.getEntity();
        JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
        return exchangeRates;
        
	}
}
