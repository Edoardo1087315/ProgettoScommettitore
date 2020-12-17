package currency.scommettitoreApp.model;

import java.util.Vector;

import currency.scommettitoreApp.filtersstatistics.Statistics;

public class CurrencyModel {

	/**
	 * Valori assunti dalla valuta nel periodo
	 */
	
	private Vector<Double> values;
	
	/**
	 * Valore della media
	 */

	private Double average;
	
	/**
	 * valore della varianza
	 */

	private Double variance;
	
	/**
	 * Valore della deviazione standard
	 */

	private Double standard_deviation;
	
	/**
	 * Valore della variazione percentuale
	 */

	private Double percentage_variation;
	
	/**
	 * Valori delle variazioni percentuali giornaliere
	 */

	private Vector<Double> daily_percentage_variation;

	/**
	 * Costruttore di CurrencyModel
	 * @param vet valori assunti dalla valuta nel periodo
	 */
	
	public CurrencyModel(Vector<Double> vet) {
		values = vet;
	}
	
	/**
	 * Metodo per far calcolare tutte le statistiche
	 * @see currency.scommettitoreApp.filtersstatistics.Statistics
	 */
	
	public void setStatistics() {
		average = Statistics.average(this.values);
		variance = Statistics.variance(this.values);
		standard_deviation = Statistics.standardDeviation(this.values);
		percentage_variation = Statistics.percentageVariation(this.values);
		daily_percentage_variation = Statistics.dailyPercentageVariation(this.values);
	}

	/**
	 * Metodo per ottenere i valori assunti dalla valuta nel periodo
	 * @return un Vector di Double con i valori assunti dalla valuta nel periodo
	 */
	
	public Vector<Double> getValues() {
		return values;
	}

	/**
	 * Metodo per settare i valori assunti dalla valuta nel periodo
	 * @param values valori assunti dalla valuta nel periodo
	 */
	
	public void setValues(Vector<Double> values) {
		this.values = values;
	}

	/**
	 * Metodo per ottenere il valore della media
	 * @return un Double rappresentante il valore della media
	 */
	
	public Double getAverage() {
		return average;
	}

	/**
	 * Metodo per settare la media
	 * @param average
	 */
	
	public void setAverage(Double average) {
		this.average = average;
	}

	/**
	 * Metodo per ottenere il valore della varianza
	 * @return un Double rappresentante il valore della varianza
	 */
	
	public Double getVariance() {
		return variance;
	}

	/**
	 * Metodo per settare la varianza
	 * @param variance
	 */
	
	public void setVariance(Double variance) {
		this.variance = variance;
	}

	/**
	 * Metodo per ottenere il valore della deviazione standard
	 * @return un Double rappresentante il valore della deviazione standard
	 */
	
	public Double getStandard_deviation() {
		return standard_deviation;
	}

	/**
	 * Metodo per settare la deviazione standard
	 * @param standard_deviation
	 */
	
	public void setStandard_deviation(Double standard_deviation) {
		this.standard_deviation = standard_deviation;
	}

	/**
	 * Metodo per ottenere il valore della variazione percentuale
	 * @return un Double rappresentante il valore della variazione percentuale
	 */
	
	public Double getPercentage_variation() {
		return percentage_variation;
	}

	/**
	 * Metodo per settare la variazione percentuale
	 * @param percentage_variation
	 */
	
	public void setPercentage_variation(Double percentage_variation) {
		this.percentage_variation = percentage_variation;
	}

	/**
	 * Metodo per ottenere i valori delle variazioni percentuali giornaliere
	 * @return un Vector di Double rappresentante i valori delle variazioni percentuali giornaliere
	 */
	
	public Vector<Double> getDaily_percentage_variation() {
		return daily_percentage_variation;
	}

	/**
	 * Metodo per settare i valori delle variazioni percentuali giornaliere
	 * @param daily_percentage_variation 
	 */
	
	public void setDaily_percentage_variation(Vector<Double> daily_percentage_variation) {
		this.daily_percentage_variation = daily_percentage_variation;
	}

}
