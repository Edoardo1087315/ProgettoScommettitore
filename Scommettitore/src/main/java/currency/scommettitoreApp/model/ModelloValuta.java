package currency.scommettitoreApp.model;

import java.util.Vector;

public class ModelloValuta {

	private String Valuta;

	private Double Media;

	private Double Varianza;

	private Vector<Double> Valori;

	private int Periodo;

	private Double VariaziPercentuale;

	private Double DeviazStandard;
	
	private Vector<Double> VariaziPercentualeGiorn;

	public ModelloValuta(String valuta, Double media, Double varianza, Vector<Double> valori, int periodo,
			Double variaziPercentuale, Double deviazStandard, Vector<Double> variazipercentualegiorn) {
		super();
		Valuta = valuta;
		Media = media;
		Varianza = varianza;
		Valori = valori;
		Periodo = periodo;
		VariaziPercentuale = variaziPercentuale;
		DeviazStandard = deviazStandard;
		VariaziPercentualeGiorn = variazipercentualegiorn;
	}

	public Double getVariaziPercentuale() {
		return VariaziPercentuale;
	}

	public void setVariaziPercentuale(Double variaziPercentuale) {
		VariaziPercentuale = variaziPercentuale;
	}

	public Double getDeviazStandard() {
		return DeviazStandard;
	}

	public void setDeviazStandard(Double deviazStandard) {
		DeviazStandard = deviazStandard;
	}

	public int getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(int periodo) {
		this.Periodo = periodo;
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

	public Vector<Double> getVariaziPercentualeGiorn() {
		return VariaziPercentualeGiorn;
	}

	public void setVariaziPercentualeGiorn(Vector<Double> variaziPercentualeGiorn) {
		VariaziPercentualeGiorn = variaziPercentualeGiorn;
	}

}
