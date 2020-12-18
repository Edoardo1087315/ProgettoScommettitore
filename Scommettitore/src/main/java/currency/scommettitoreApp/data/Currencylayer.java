package currency.scommettitoreApp.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.model.ApiModel;

/**
 * Classe che si occupa della connessione al sito
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class Currencylayer {

	/**
	 * Metodo che esegue la connessione al sito e il parsing dei dati
	 * @param url url generato a cui connettersi
	 * @return un oggetto ApiModel
	 * @throws UrlException
	 * @throws IOException
	 */
	
	public static ApiModel getJsonAndDecode(String url) throws UrlException,IOException {

		ApiModel p = new ApiModel();
		URLConnection openConnection = new URL(url).openConnection();
		InputStream in = openConnection.getInputStream();

		String data = "";
		String line = "";
		try {
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader buf = new BufferedReader(inR);

			while ((line = buf.readLine()) != null) {
				data += line;
			}
		} finally {
			in.close();
		}

		if (data.contains("\"success\":false")) {  //se il sito restituisce un insuccesso per il tipo di richiesta fatta 
			throw new UrlException();			   //viene lanciata l'eccezione che segnala all'utente che qualcosa non ha funzionato
		}
		ObjectMapper obj = new ObjectMapper();
		p = obj.readValue(data, ApiModel.class);  //faccio il parsing del JSON ottenuto dalle API di currencylayer

		return p;

	}

}
