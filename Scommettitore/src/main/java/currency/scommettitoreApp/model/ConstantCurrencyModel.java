package currency.scommettitoreApp.model;

/**
 * Classe rappresentante la valuta e la sua volatilità
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class ConstantCurrencyModel {
	
	/**
	 * Nome della valuta
	 */
	
	private String currency;
	
	/**
	 * Valore della deviazione standard della valuta
	 */
	
	private Double standard_deviation;

	/**
	 * Metodo per ottenere il nome della valuta
	 * @return una String con il nome della valuta
	 */
	
	public String getCurrency() {
		return currency;
	}

	/**
	 * Metodo per settare il nome della valuta
	 * @param currency nome della valuta da settare
	 */
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Metodo per ottenere la deviazione standard 
	 * @return un Double rappresentante la deviazione standard
	 */
	
	public Double getStandard_deviation() {
		return standard_deviation;
	}

	/**
	 * Metodo per settare la deviazione standard
	 * @param standard_deviation valore della deviazione standard da settare
	 */
	
	public void setStandard_deviation(Double standard_deviation) {
		this.standard_deviation = standard_deviation;
	}

}
