package currency.scommettitoreApp.model;

import java.util.Vector;

public class ModelloValuta {
	
	private String Valuta;
	
	private Double Media;
	
	private Double Varianza;
	
	private Vector<Double> Valori;

	public ModelloValuta(String valuta, Double media, Double varianza, Vector<Double> valori) {
		super();
		Valuta = valuta;
		Media = media;
		Varianza = varianza;
		Valori = valori;
	}

	public String getValuta() {
		return Valuta;
	}

	public void setValuta(String valuta) {
		Valuta = valuta;
	}

	public Double getMedia() {
		return Media;
	}

	public void setMedia(Double media) {
		Media = media;
	}

	public Double getVarianza() {
		return Varianza;
	}

	public void setVarianza(Double varianza) {
		Varianza = varianza;
	}

	public Vector<Double> getValori() {
		return Valori;
	}

	public void setValori(Vector<Double> valori) {
		Valori = valori;
	}
	
	
	
	
}
