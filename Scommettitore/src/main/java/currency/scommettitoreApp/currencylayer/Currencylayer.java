package currency.scommettitoreApp.currencylayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.exceptions.UrlException;

public class Currencylayer {

	public static ApiParsing GetJsonAndDecode(String url) throws MalformedURLException, IOException, UrlException {
		
		ApiParsing p = new ApiParsing();
		URLConnection openConnection = new URL(url).openConnection();
		InputStream in = openConnection.getInputStream();
		
		 String data = "";
		 String line = "";
		 try {
		   InputStreamReader inR = new InputStreamReader( in );
		   BufferedReader buf = new BufferedReader( inR );
		  
		   while ( ( line = buf.readLine() ) != null ) {
			   data+= line;
		   }
		 } finally {
		   in.close();
		 }
		 
		 if(data.contains("\"success\":false")) {
			 throw new UrlException();
		 }
		 ObjectMapper obj = new ObjectMapper();
		 p = obj.readValue(data,ApiParsing.class);
		
		 return p;
	
	}

}

