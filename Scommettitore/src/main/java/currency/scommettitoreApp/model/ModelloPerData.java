package currency.scommettitoreApp.model;

import java.util.HashMap;

public class ModelloPerData {
	
	private String data;
	
	private HashMap<String,Double> Valori;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public HashMap<String, Double> getValori() {
		return Valori;
	}

	public void setValori(HashMap<String, Double> valori) {
		Valori = valori;
	}

	public ModelloPerData(String data, HashMap<String, Double> valori) {
		super();
		this.data = data;
		Valori = valori;
	}
	
	
}
