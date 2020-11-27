package currency.scommettitoreApp.model;

import java.util.Vector;

public class ModelloValuta {

	private Double media;

	private Double varianza;

	private Vector<Double> valori;

	private Double variazione_percentuale;

	private Double deviazione_standard;
	
	private Vector<Double> variazione_percentuale_giornaliera;

	public ModelloValuta(Double media, Double varianza, Vector<Double> valori, Double variazione_percentuale,
			Double deviazione_standard, Vector<Double> variazione_percentuale_giornaliera) {
		super();
		this.media = media;
		this.varianza = varianza;
		this.valori = valori;
		this.variazione_percentuale = variazione_percentuale;
		this.deviazione_standard = deviazione_standard;
		this.variazione_percentuale_giornaliera = variazione_percentuale_giornaliera;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Double getVarianza() {
		return varianza;
	}

	public void setVarianza(Double varianza) {
		this.varianza = varianza;
	}

	public Vector<Double> getValori() {
		return valori;
	}

	public void setValori(Vector<Double> valori) {
		this.valori = valori;
	}

	public Double getVariazione_percentuale() {
		return variazione_percentuale;
	}

	public void setVariazione_percentuale(Double variazione_percentuale) {
		this.variazione_percentuale = variazione_percentuale;
	}

	public Double getDeviazione_standard() {
		return deviazione_standard;
	}

	public void setDeviazione_standard(Double deviazione_standard) {
		this.deviazione_standard = deviazione_standard;
	}

	public Vector<Double> getVariazione_percentuale_giornaliera() {
		return variazione_percentuale_giornaliera;
	}

	public void setVariazione_percentuale_giornaliera(Vector<Double> variazione_percentuale_giornaliera) {
		this.variazione_percentuale_giornaliera = variazione_percentuale_giornaliera;
	}

	
}

