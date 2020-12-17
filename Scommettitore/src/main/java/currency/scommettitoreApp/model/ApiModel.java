package currency.scommettitoreApp.model;

import java.util.HashMap;

/**
 * Classe per il parsing
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class ApiModel {
	
	public Boolean success;
	
	public String terms;
	
	public String privacy;
	
	public String timestamp;
	
	public String source;
		
	public HashMap<String,Double> quotes;
	
	public String date;
	
	public Boolean historical;
		
}
